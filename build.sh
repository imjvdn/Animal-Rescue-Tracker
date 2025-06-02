#!/bin/bash

# Define Java paths
JAVA_HOME="/opt/homebrew/Cellar/openjdk/23.0.2/libexec/openjdk.jdk/Contents/Home"
JAVAC="$JAVA_HOME/bin/javac"
JAVA="$JAVA_HOME/bin/java"

# Create target directories
mkdir -p target/classes
mkdir -p target/test-classes

# Compile main classes
echo "Compiling main classes..."
$JAVAC -d target/classes src/main/java/com/graziosalvare/animalrescue/*.java

# Compile test classes
echo "Compiling test classes..."
$JAVAC -cp target/classes -d target/test-classes src/test/java/com/graziosalvare/animalrescue/*.java

echo "Build completed successfully!"
