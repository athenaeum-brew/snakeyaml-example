package com.cthiebaud;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.cthiebaud.SnakeYAMLBeanExample.NameAndBirthBean;

import org.yaml.snakeyaml.LoaderOptions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SnakeYAMLBeansExample {
    public static void main(String[] args) throws IOException {
        System.out.println("\n" + SnakeYAMLBeansExample.class + "\n");

        // Define file path
        String filePath = "example-beans.yaml";

        // Create a YAML parser with a custom constructor for NameAndBirthBean class
        Yaml yaml = new Yaml(new Constructor(NameAndBirthBean.class, new LoaderOptions()));

        // Load the YAML file as an input stream
        Path path = Paths.get(filePath);
        try (InputStream inputStream = Files.newInputStream(path)) {
            // Parse YAML data into a stream of objects representing YAML documents
            Stream<NameAndBirthBean> stream = StreamSupport
                    .stream(yaml.loadAll(inputStream).spliterator(), false)
                    .map(SnakeYAMLBeanExample.NameAndBirthBean.class::cast);

            // Print loaded entities
            stream.forEach(entity -> {
                System.out.println("---");
                System.out.println("Name: " + entity.getName());
                System.out.println("Birth: " + entity.getBirth());
            });
        }
    }

}
