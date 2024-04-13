package com.cthiebaud.yaml.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

public class JacksonRecordExample {
    public record Inside(String someContent) {

    }

    public record Person2(String dugenou, Float percent, Boolean gender, Inside inside) {
    }

    public static void main(String[] args) throws IOException {
        String yamlData = """
                ---
                dugenou: lui
                percent: 2.0
                gender: true
                inside:
                    someContent: qwe
                    """;

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Person2 person = mapper.readValue(yamlData, Person2.class);
        System.out.println(person.dugenou() + " - " + person.dugenou().getClass()); // Accessing dugenou component
        System.out.println(person.percent() + " - " + person.percent().getClass()); // Accessing percent component
        System.out.println(person.gender() + " - " + person.gender().getClass()); // Accessing percent component
        System.out.println(person.inside() + " - " + person.inside().getClass()); // Accessing percent component
    }
}
