package com.cthiebaud;

import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SnakeYAMLBeanExample {

    public static void main(String[] args) throws IOException {
        System.out.println("\n" + SnakeYAMLBeanExample.class + "\n");

        // Create YAML instance
        Yaml yaml = new Yaml();
        // Read data from YAML file
        Path path = Paths.get("example-bean.yaml");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            // Deserialize YAML data into Java bean
            NameAndBirthBean bean = yaml.loadAs(reader, NameAndBirthBean.class);
            // Display bean details
            System.out.println("Name: " + bean.getName());
            System.out.println("Birth: " + bean.getBirth());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Java bean class representing Name and Birth attributes
    public static class NameAndBirthBean {

        static DateTimeFormatter formatterIn = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        static DateTimeFormatter formatterOut = DateTimeFormatter.ofPattern("MMMM d, yyyy");

        private String name;
        private LocalDate birth;

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBirth() {
            return birth.format(formatterOut);
        }

        public void setBirth(String birth) {
            this.birth = LocalDate.parse(birth, formatterIn);
        }
    }
}
