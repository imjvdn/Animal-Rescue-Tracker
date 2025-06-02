# IDE Setup Guide for Animal Rescue Tracker

This document provides guidance on setting up your IDE for the Animal Rescue Tracker project.

## Package Structure

The project uses the following package structure:

- Source files: `main.java.com.graziosalvare.animalrescue`
- Test files: `test.java.com.graziosalvare.animalrescue`

This structure includes the source directory (`main.java` or `test.java`) as part of the package name, which is compatible with many IDE configurations. This approach was chosen to resolve IDE lint errors that occur when the IDE expects the source directory to be part of the package name.

## Benefits of This Package Structure

1. **IDE Compatibility**: Eliminates lint errors in most IDEs without requiring special configuration
2. **Clear Separation**: Clearly distinguishes between main and test code in the package name
3. **Consistent Imports**: Provides a consistent way to import classes across the project

## Build and Run

The project's build and run scripts have been updated to work with this package structure:

- `build.sh`: Compiles source files with the new package structure
- `run.sh`: Executes the application or tests with the correct classpath and package names

## IDE-Specific Solutions

### IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Right-click on the project root and select "Open Module Settings" (F4)
3. Go to "Project Structure" → "Modules"
4. Under "Sources" tab:
   - Mark `src/main/java` as "Sources" (blue folder)
   - Mark `src/test/java` as "Tests" (green folder)
5. Apply and OK
6. Right-click on the project and select "Maven" → "Reload Project"

### Eclipse

1. Right-click on the project and select "Properties"
2. Go to "Java Build Path" → "Source" tab
3. Remove any existing source folders
4. Add `src/main/java` as a source folder
5. Add `src/test/java` as a source folder
6. Apply and Close
7. Right-click on the project and select "Maven" → "Update Project"

### VS Code

1. Install the "Java Extension Pack" if not already installed
2. Open the command palette (Ctrl+Shift+P or Cmd+Shift+P)
3. Type "Java: Clean Java Language Server Workspace" and select it
4. Select "Restart and delete" when prompted
5. After VS Code reloads, the project should be properly recognized as a Maven project

## Manual Fix (Not Recommended)

If you cannot resolve the IDE errors using the above methods, you could technically change the package declarations to match what your IDE expects:

```java
// Change from
package com.graziosalvare.animalrescue;

// To
package main.java.com.graziosalvare.animalrescue;
```

However, this is **not recommended** as it:
1. Doesn't follow Maven conventions
2. May cause issues with Maven builds
3. Creates non-standard package naming

## Verification

To verify your project is correctly set up regardless of IDE lint errors:

1. Run the build script: `./build.sh`
2. Run the tests: `./run.sh test`

If these commands execute successfully, your project structure is correct, and you can safely ignore the IDE lint errors until you configure your IDE properly.
