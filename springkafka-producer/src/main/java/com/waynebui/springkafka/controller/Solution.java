package com.waynebui.springkafka.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        System.out.println(changeDirectoryString("/dev/task", "cd /"));  // Output: "/"
        System.out.println(changeDirectoryString("/dev/task", "cd .."));  // Output: "/dev"
        System.out.println(changeDirectoryString("/dev/task", "cd java"));  // Output: "/dev/task/java"
        System.out.println(changeDirectoryString("/dev/task", "cd ../solution"));  // Output: "/dev/solution"
        System.out.println(changeDirectoryString("/dev/task/java", "cd ../.."));  // Output: "/dev"
    }
    public static String changeDirectoryString(String currentDirectory, String command) {
        if (!currentDirectory.startsWith("/")) {
            currentDirectory = "/" + currentDirectory;
        }

        if (currentDirectory.endsWith("/")) {
            currentDirectory = currentDirectory.substring(0, currentDirectory.length() - 1);
        }

        List<String> commandEle = Arrays.asList(command.split(" "));

        if (commandEle.size() == 0 || !Objects.equals(commandEle.get(0), "cd")) {
            throw new IllegalStateException();
        }

        if (commandEle.get(1).equals("/")) {
            return "/";
        }

        if (currentDirectory.length() > command.length() && currentDirectory.contains(commandEle.get(1))) {
            String result = commandEle.get(1);

            if (result.endsWith("/")) {
                result = result.substring(0, result.length() - 1);
            }
            return result;
        }

        String[] paths = commandEle.get(1).split("/");

        for (String component : paths) {
            if (component.equals(".")) {
                // Do nothing
            } else if (component.equals("..")) {
                // Move up one level in directory hierarchy
                int lastSlashIndex = currentDirectory.lastIndexOf("/");
                if (lastSlashIndex > 0) {
                    currentDirectory = currentDirectory.substring(0, lastSlashIndex);
                } else {
                    currentDirectory = "/";
                }
            } else {
                // Move down one level in directory hierarchy
                if (!component.isEmpty()) {
                    currentDirectory += "/" + component;
                }
            }
        }
        if (currentDirectory.endsWith("/")) {
            currentDirectory = currentDirectory.substring(0, currentDirectory.length() - 1);
        }
        return currentDirectory;
    }

}
