package com.cthiebaud.yaml.snakeyamengine;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.snakeyaml.engine.v2.api.ConstructNode;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.nodes.Tag;

import com.cthiebaud.yaml.Person;

import java.util.HashMap;
import java.util.Map;

public class SnakeYAMLEngineExample {
        public static void main(String[] args) {
                LoadSettings settings = LoadSettings.builder()
                                .setTagConstructors(getTagConstructors())
                                .build();

                Load yaml = new Load(settings);

                String yamlData = """
                                !com.cthiebaud.oop2.Person
                                name: qwe
                                age: 12
                                """;

                // Convert String to InputStream
                InputStream inputStream = new ByteArrayInputStream(yamlData.getBytes());

                // Parse YAML directly into the specified class
                Person parsedPerson = (Person) yaml.loadFromInputStream(inputStream);

                // Print parsed Java object
                System.out.println(parsedPerson);

        }

        private static Map<Tag, ConstructNode> getTagConstructors() {
                Map<Tag, ConstructNode> tagConstructors = new HashMap<>();
                tagConstructors.put(new Tag("!com.cthiebaud.oop2.Person"), new SnakeYAMLEngineConstructPerson());
                return tagConstructors;
        }

}
