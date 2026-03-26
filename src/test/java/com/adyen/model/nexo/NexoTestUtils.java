package com.adyen.model.nexo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

final class NexoTestUtils {

  private NexoTestUtils() {}

  static String readResource(String fileName) throws IOException {
    ClassLoader classLoader = NexoTestUtils.class.getClassLoader();
    try (InputStream fileStream = classLoader.getResourceAsStream(fileName)) {
      if (fileStream == null) {
        throw new IOException("Unable to load resource: " + fileName);
      }
      return new String(fileStream.readAllBytes(), StandardCharsets.UTF_8);
    }
  }
}
