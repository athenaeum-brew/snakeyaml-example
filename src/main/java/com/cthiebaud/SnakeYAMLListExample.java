package com.cthiebaud;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.LoaderOptions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SnakeYAMLListExample {
    public static void main(String[] args) throws IOException {
        // Define file path
        String filePath = "example-list.yaml";

        // Create a YAML parser with a custom constructor for NameAndBirthBean class
        Yaml yaml = new Yaml(new Constructor(NameAndBirthBean.class, new LoaderOptions()));

        // Load the YAML file as an input stream
        Path path = Paths.get(filePath);
        try (InputStream inputStream = Files.newInputStream(path)) {
            // Parse YAML data into a stream of objects representing YAML documents
            Stream<NameAndBirthBean> stream = StreamSupport.stream(yaml.loadAll(inputStream).spliterator(), false)
                    .map(NameAndBirthBean.class::cast);

            // Print loaded entities
            stream.forEach(entity -> {
                System.out.println("---");
                System.out.println("Name: " + entity.getName());
                System.out.println("Birth: " + entity.getBirth());
            });
        }
    }

    // Java bean class representing Name and Birth attributes
    public static class NameAndBirthBean {
        private String name;
        private String birth;

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBirth() {
            return birth;
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }
    }
}
