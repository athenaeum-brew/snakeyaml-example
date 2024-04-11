#!/bin/bash

# Define SnakeYAML version, jar file, and download URL
SNAKEYAML_VERSION="2.2"
SNAKEYAML_JAR="snakeyaml-$SNAKEYAML_VERSION.jar"
SNAKEYAML_URL="https://repo1.maven.org/maven2/org/yaml/snakeyaml/$SNAKEYAML_VERSION/$SNAKEYAML_JAR"

# Download SnakeYAML jar file
curl -o "$SNAKEYAML_JAR" "$SNAKEYAML_URL"
# Check if download was successful
[ $? -eq 0 ] || { echo "Download failed."; exit 1; }

# Remove existing build directory and create a new one
rm -rf build
mkdir build

# Compile Java source files and place class files in the build directory
javac -d build -cp "$(basename $SNAKEYAML_JAR)" src/main/java/com/cthiebaud/SnakeYAMLReadExample.java
# Check if compilation was successful
[ $? -eq 0 ] || { echo "Compilation failed."; exit 1; }

# Run the Java program with the necessary classpath
java -cp "build:$(basename $SNAKEYAML_JAR)" com.cthiebaud.SnakeYAMLReadExample
