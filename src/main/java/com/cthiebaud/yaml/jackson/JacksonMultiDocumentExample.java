package com.cthiebaud.yaml.jackson;

import java.io.IOException;

import com.cthiebaud.yaml.Person;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class JacksonMultiDocumentExample {
    public static void main(String[] args) throws IOException {
        String yamlData = """
                name: John
                age: 30
                ---
                name: Alice
                age: 25
                ---
                name: Bob
                age: 35
                """;

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        MappingIterator<Person> iterator = mapper.readerFor(Person.class).readValues(yamlData);

        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println(person);
        }
    }
}
