package com.cthiebaud.yaml.snakeyaml;

import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/*
    mvn exec:java -Dexec.mainClass="com.cthiebaud.yaml.snakeyaml.SnakeYAMLReadExample"
*/
public class SnakeYAMLReadExample {
    public static void main(String[] args) {
        System.out.println("\n" + SnakeYAMLReadExample.class + "\n");

        Yaml yaml = new Yaml();

        // Define file path
        String filePath = "example-bean.yaml";

        // Read data from YAML file
        Path path = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            Map<String, Object> data = yaml.load(reader);
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
