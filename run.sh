#!/bin/bash

# Define Java paths - Update these paths to match your Java installation
# Example for macOS with Homebrew-installed Java:
JAVA_HOME="/opt/homebrew/Cellar/openjdk/23.0.2/libexec/openjdk.jdk/Contents/Home"
# Example for Windows: JAVA_HOME="C:\Program Files\Java\jdk-11"
# Example for Linux: JAVA_HOME="/usr/lib/jvm/java-11-openjdk"

JAVA="$JAVA_HOME/bin/java"

# Check if target directories exist, if not, run build script
if [ ! -d "target/classes" ] || [ ! -d "target/test-classes" ]; then
    echo "Build artifacts not found. Running build script first..."
    ./build.sh
fi

# Function to run the main application
run_app() {
    echo "Running Animal Rescue Tracker application..."
    $JAVA -cp target/classes main.java.com.graziosalvare.animalrescue.Driver
}

# Function to run the tests
run_tests() {
    echo "Running Animal Rescue Tracker tests..."
    $JAVA -cp target/classes:target/test-classes test.java.com.graziosalvare.animalrescue.TestAnimalRescueTracker
}

# Check command line arguments
if [ "$1" == "test" ]; then
    run_tests
else
    run_app
fi
