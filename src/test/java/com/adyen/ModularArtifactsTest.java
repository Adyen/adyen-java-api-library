package com.adyen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

class ModularArtifactsTest {

  @Test
  void modularArtifactsPartitionAllCompiledClasses() throws Exception {
    Map<String, JarPatterns> jarPatterns = readJarPatterns();
    assertEquals(
        Set.of(
            "core",
            "checkout",
            "platforms",
            "payments",
            "terminal",
            "classic-platforms",
            "webhooks",
            "webhook-handlers"),
        jarPatterns.keySet());

    Map<String, List<String>> ownersByClass = new HashMap<>();
    try (Stream<Path> compiledClasses = Files.walk(Path.of("target/classes/com/adyen"))) {
      compiledClasses
          .filter(path -> path.toString().endsWith(".class"))
          .map(path -> Path.of("target/classes").relativize(path).toString().replace('\\', '/'))
          .forEach(
              className ->
                  ownersByClass.put(
                      className,
                      jarPatterns.entrySet().stream()
                          .filter(entry -> entry.getValue().matches(className))
                          .map(Map.Entry::getKey)
                          .collect(Collectors.toList())));
    }

    List<String> unassigned =
        ownersByClass.entrySet().stream()
            .filter(entry -> entry.getValue().isEmpty())
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    List<String> duplicated =
        ownersByClass.entrySet().stream()
            .filter(entry -> entry.getValue().size() > 1)
            .map(entry -> entry.getKey() + " -> " + entry.getValue())
            .collect(Collectors.toList());

    assertTrue(unassigned.isEmpty(), "Classes missing from modular artifacts: " + unassigned);
    assertTrue(duplicated.isEmpty(), "Classes duplicated across modular artifacts: " + duplicated);
  }

  private static Map<String, JarPatterns> readJarPatterns() throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
    NodeList plugins =
        factory
            .newDocumentBuilder()
            .parse(Path.of("pom.xml").toFile())
            .getElementsByTagName("plugin");
    Map<String, JarPatterns> patternsByClassifier = new HashMap<>();

    for (int pluginIndex = 0; pluginIndex < plugins.getLength(); pluginIndex++) {
      Element plugin = (Element) plugins.item(pluginIndex);
      if (!"maven-jar-plugin".equals(text(plugin, "artifactId"))) {
        continue;
      }
      NodeList executions = plugin.getElementsByTagName("execution");
      for (int executionIndex = 0; executionIndex < executions.getLength(); executionIndex++) {
        Element execution = (Element) executions.item(executionIndex);
        NodeList classifiers = execution.getElementsByTagName("classifier");
        if (classifiers.getLength() == 0) {
          continue;
        }
        String classifier = classifiers.item(0).getTextContent().trim();
        patternsByClassifier.put(
            classifier,
            new JarPatterns(patterns(execution, "include"), patterns(execution, "exclude")));
      }
    }
    return patternsByClassifier;
  }

  private static String text(Element element, String tagName) {
    return element.getElementsByTagName(tagName).item(0).getTextContent().trim();
  }

  private static List<Pattern> patterns(Element execution, String tagName) {
    NodeList nodes = execution.getElementsByTagName(tagName);
    List<Pattern> patterns = new ArrayList<>();
    for (int index = 0; index < nodes.getLength(); index++) {
      patterns.add(Pattern.compile(toRegex(nodes.item(index).getTextContent().trim())));
    }
    return patterns;
  }

  private static String toRegex(String glob) {
    StringBuilder regex = new StringBuilder("^");
    for (int index = 0; index < glob.length(); index++) {
      char character = glob.charAt(index);
      if (character == '*') {
        boolean doubleWildcard = index + 1 < glob.length() && glob.charAt(index + 1) == '*';
        regex.append(doubleWildcard ? ".*" : "[^/]*");
        if (doubleWildcard) {
          index++;
        }
      } else if ("\\.[]{}()+-^$|".indexOf(character) >= 0) {
        regex.append('\\').append(character);
      } else {
        regex.append(character);
      }
    }
    return regex.append('$').toString();
  }

  private static final class JarPatterns {
    private final List<Pattern> includes;
    private final List<Pattern> excludes;

    private JarPatterns(List<Pattern> includes, List<Pattern> excludes) {
      this.includes = includes;
      this.excludes = excludes;
    }

    private boolean matches(String className) {
      return includes.stream().anyMatch(pattern -> pattern.matcher(className).matches())
          && excludes.stream().noneMatch(pattern -> pattern.matcher(className).matches());
    }
  }
}
