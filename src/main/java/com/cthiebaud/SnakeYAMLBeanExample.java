package com.cthiebaud;

import org.yaml.snakeyaml.Yaml;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SnakeYAMLBeanExample {
    public static void main(String[] args) throws IOException {
        // Define file path
        String filePath = "example-bean.yaml";

        // Read data from YAML file
        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            // Create YAML instance
            Yaml yaml = new Yaml();

            // Deserialize YAML data into Java bean
            NameAndBirthBean bean = yaml.loadAs(Files.newBufferedReader(path), NameAndBirthBean.class);

            // Display bean details
            System.out.println("Bean Details:");
            System.out.println("Name: " + bean.getName());
            System.out.println("Birth: " + bean.getBirth());
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
