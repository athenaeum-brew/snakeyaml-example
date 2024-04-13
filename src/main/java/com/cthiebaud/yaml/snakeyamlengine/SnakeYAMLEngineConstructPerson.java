package com.cthiebaud.yaml.snakeyamlengine;

import org.snakeyaml.engine.v2.api.ConstructNode;
import org.snakeyaml.engine.v2.nodes.MappingNode;
import org.snakeyaml.engine.v2.nodes.Node;
import org.snakeyaml.engine.v2.nodes.NodeTuple;
import org.snakeyaml.engine.v2.nodes.ScalarNode;

import com.cthiebaud.yaml.Person;

public class SnakeYAMLEngineConstructPerson implements ConstructNode {
    @Override
    public Object construct(Node node) {
        if (!(node instanceof MappingNode)) {
            throw new IllegalArgumentException("Node must be a mapping node");
        }

        MappingNode mappingNode = (MappingNode) node;
        String name = null;
        int age = -1;

        for (NodeTuple tuple : mappingNode.getValue()) {
            Node keyNode = tuple.getKeyNode();
            Node valueNode = tuple.getValueNode();

            if (!(keyNode instanceof ScalarNode) || !(valueNode instanceof ScalarNode)) {
                throw new IllegalArgumentException("Key and value nodes must be scalar nodes");
            }

            ScalarNode keyScalar = (ScalarNode) keyNode;
            ScalarNode valueScalar = (ScalarNode) valueNode;

            if ("name".equals(keyScalar.getValue())) {
                name = valueScalar.getValue();
            } else if ("age".equals(keyScalar.getValue())) {
                age = Integer.parseInt(valueScalar.getValue());
            }
        }

        if (name == null || age == -1) {
            throw new IllegalArgumentException("Name and age must be provided");
        }

        return new Person(name, age);
    }
}
