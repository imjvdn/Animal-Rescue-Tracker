#!/bin/bash

# Define Java paths - Update these paths to match your Java installation
# Example for macOS with Homebrew-installed Java:
JAVA_HOME="/opt/homebrew/Cellar/openjdk/23.0.2/libexec/openjdk.jdk/Contents/Home"
# Example for Windows: JAVA_HOME="C:\Program Files\Java\jdk-11"
# Example for Linux: JAVA_HOME="/usr/lib/jvm/java-11-openjdk"

JAVAC="$JAVA_HOME/bin/javac"
JAVA="$JAVA_HOME/bin/java"

# Create target directories
mkdir -p target/classes/main/java/com/graziosalvare/animalrescue
mkdir -p target/test-classes/test/java/com/graziosalvare/animalrescue

# Compile main classes
echo "Compiling main classes..."
$JAVAC -d target/classes src/main/java/com/graziosalvare/animalrescue/*.java

# Compile test classes
echo "Compiling test classes..."
$JAVAC -cp target/classes -d target/test-classes src/test/java/com/graziosalvare/animalrescue/*.java

echo "Build completed successfully!"
