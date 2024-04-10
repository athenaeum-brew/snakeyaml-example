package com.cthiebaud;

import org.yaml.snakeyaml.Yaml;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class SnakeYAMLReadExample {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();

        // Define file path
        String filePath = "example-object.yaml";

        // Read data from YAML file
        Path path = Paths.get(filePath);
        try (var reader = Files.newBufferedReader(path)) {
            Map<String, Object> data = yaml.load(reader);
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
