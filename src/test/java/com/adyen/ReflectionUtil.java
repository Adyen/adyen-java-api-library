/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

class ReflectionUtil {

    private static final char PACKAGE_SEPARATOR = '.';
    private static final String CLASS_FILE_EXTENSION = ".class";

    /**
     * Returns all the fields matching the annotation in the given package
     *
     * @param packageName package name
     * @param annotation annotation class
     * @return list of fields
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static List<Field> getFieldsWithAnnotation(String packageName, Class<? extends Annotation> annotation) throws IOException, ClassNotFoundException {
        return ReflectionUtil.getClasses(packageName).stream()
                .flatMap(clazz -> Arrays.stream(clazz.getDeclaredFields()))
                .filter(field -> field.getAnnotation(annotation) != null)
                .collect(Collectors.toList());
    }

    /**
     * Returns all the enum classes in the given package
     *
     * @param packageName package name
     * @return list of enum classes
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> getEnumClasses(String packageName) throws IOException, ClassNotFoundException {
        return ReflectionUtil.getClasses(packageName).stream()
                .filter(Class::isEnum)
                .collect(Collectors.toList());
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static List<Class<?>> getClasses(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(PACKAGE_SEPARATOR, File.separatorChar);
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class<?>> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClasses(file, packageName + PACKAGE_SEPARATOR + file.getName()));
            } else if (file.getName().endsWith(CLASS_FILE_EXTENSION)) {
                classes.add(Class.forName(packageName + PACKAGE_SEPARATOR + file.getName().substring(0, file.getName().length() - CLASS_FILE_EXTENSION.length())));
            }
        }
        return classes;
    }
}
