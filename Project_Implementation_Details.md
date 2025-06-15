# Animal Rescue Tracker - Implementation Details

This document provides a comprehensive overview of the Animal Rescue Tracker project implementation, detailing how each requirement was addressed with corresponding code snippets.

## Table of Contents
1. [Monkey Class Implementation](#monkey-class-implementation)
2. [Driver Class Modifications](#driver-class-modifications)
   - [Menu Loop](#menu-loop)
   - [intakeNewDog()](#intakenewdog)
   - [intakeNewMonkey()](#intakenewmonkey)
   - [reserveAnimal()](#reserveanimal)
   - [printAnimals()](#printanimals)
3. [Exemplary Features](#exemplary-features)
4. [Input Validation](#input-validation)
5. [Code Organization](#code-organization)

## Monkey Class Implementation

### Requirements
- Create a new `Monkey` class that inherits from `RescueAnimal`
- Implement all specified attributes
- Include constructors, accessors, and mutators
- Add input validation for species
- Follow coding standards and best practices

### Implementation

#### Class Declaration and Attributes
```java
public class Monkey extends RescueAnimal {
    private String species;
    private String tailLength;
    private String height;
    private String bodyLength;
    
    private static final String[] VALID_SPECIES = {
        "Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin"
    };
}
```

#### Constructors
```java
// Default constructor
public Monkey() {
    super();
    this.species = "";
    this.tailLength = "";
    this.height = "";
    this.bodyLength = "";
    setAnimalType("monkey");
}

// Parameterized constructor
public Monkey(String name, String species, String gender, String age, String weight,
             String tailLength, String height, String bodyLength, String acquisitionDate,
             String acquisitionCountry, String trainingStatus, boolean reserved,
             String inServiceCountry) {
    super();
    if (!isValidSpecies(species)) {
        throw new IllegalArgumentException("Invalid monkey species: " + species);
    }
    setName(name);
    this.species = species;
    setGender(gender);
    setAge(age);
    setWeight(weight);
    setAcquisitionDate(acquisitionDate);
    setAcquisitionCountry(acquisitionCountry);
    setTrainingStatus(trainingStatus);
    setReserved(reserved);
    setInServiceCountry(inServiceCountry);
    this.tailLength = tailLength;
    this.height = height;
    this.bodyLength = bodyLength;
    setAnimalType("monkey");
}
```

#### Species Validation
```java
public static boolean isValidSpecies(String species) {
    for (String validSpecies : VALID_SPECIES) {
        if (validSpecies.equalsIgnoreCase(species)) {
            return true;
        }
    }
    return false;
}
```

## Driver Class Modifications

### Menu Loop

#### Requirements
- Display menu with options
- Handle user input with validation
- Call appropriate methods based on user selection
- Continue until user chooses to quit

#### Implementation
```java
public static void main(String[] args) {
    initializeDogList();
    initializeMonkeyList();
    
    Scanner scanner = new Scanner(System.in);
    String menuChoice;
    
    do {
        displayMenu();
        menuChoice = scanner.nextLine().trim();
        
        switch(menuChoice) {
            case "1":
                intakeNewDog(scanner);
                break;
            case "2":
                intakeNewMonkey(scanner);
                break;
            case "3":
                reserveAnimal(scanner);
                break;
            case "4":
                printAnimals("dog");
                break;
            case "5":
                printAnimals("monkey");
                break;
            case "6":
                printAnimals("available");
                break;
            case "q":
                System.out.println("Exiting the application. Goodbye!");
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
        
        if (!menuChoice.equalsIgnoreCase("q")) {
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
        
    } while (!menuChoice.equalsIgnoreCase("q"));
    
    scanner.close();
}
```

### intakeNewDog()

#### Requirements
- Prompt for dog information
- Validate input
- Add new dog to dogList

#### Implementation
```java
public static void intakeNewDog(Scanner scanner) {
    System.out.println("What is the dog's name?");
    String name = scanner.nextLine();
    
    // Check if dog already exists
    for(Dog dog: dogList) {
        if(dog.getName().equalsIgnoreCase(name)) {
            System.out.println("\n\nThis dog is already in our system\n\n");
            return;
        }
    }

    // Get dog attributes
    System.out.println("What is the dog's breed?");
    String breed = scanner.nextLine();
    
    // ... (other attribute inputs)
    
    // Create and add new dog
    Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, 
                        acquisitionCountry, trainingStatus, reserved, inServiceCountry);
    dogList.add(newDog);
    
    System.out.println("\nDog successfully added to the system!");
}
```

### intakeNewMonkey()

#### Requirements
- Prompt for monkey information
- Validate species and other inputs
- Add new monkey to monkeyList

#### Implementation
```java
public static void intakeNewMonkey(Scanner scanner) {
    System.out.println("What is the monkey's name?");
    String name = scanner.nextLine();
    
    // Check if monkey already exists
    for(Monkey monkey: monkeyList) {
        if(monkey.getName().equalsIgnoreCase(name)) {
            System.out.println("\n\nThis monkey is already in our system\n\n");
            return;
        }
    }
    
    // Get and validate species
    String species;
    do {
        System.out.println("What is the monkey's species?");
        System.out.println("Valid species: Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin");
        species = scanner.nextLine();
    } while (!Monkey.isValidSpecies(species));
    
    // ... (other attribute inputs)
    
    // Create and add new monkey
    Monkey newMonkey = new Monkey(name, species, gender, age, weight, tailLength, 
                                height, bodyLength, acquisitionDate, acquisitionCountry, 
                                trainingStatus, reserved, inServiceCountry);
    monkeyList.add(newMonkey);
    
    System.out.println("\nMonkey successfully added to the system!");
}
```

### reserveAnimal()

#### Requirements
- Prompt for animal type and service country
- Find and reserve available animal
- Provide feedback on success/failure

#### Implementation
```java
public static void reserveAnimal(Scanner scanner) {
    System.out.println("Enter animal type (dog/monkey):");
    String animalType = scanner.nextLine().toLowerCase();
    
    if (!animalType.equals("dog") && !animalType.equals("monkey")) {
        System.out.println("Invalid animal type. Please enter 'dog' or 'monkey'.");
        return;
    }
    
    System.out.println("Enter the service country:");
    String serviceCountry = scanner.nextLine();
    
    boolean animalFound = false;
    
    if (animalType.equals("dog")) {
        for (Dog dog : dogList) {
            if (!dog.getReserved() && dog.getTrainingStatus().equalsIgnoreCase("in service") && 
                dog.getInServiceCountry().equalsIgnoreCase(serviceCountry)) {
                dog.setReserved(true);
                System.out.println("\nDog " + dog.getName() + " has been reserved for service in " + serviceCountry);
                animalFound = true;
                break;
            }
        }
    } else {
        for (Monkey monkey : monkeyList) {
            if (!monkey.getReserved() && monkey.getTrainingStatus().equalsIgnoreCase("in service") && 
                monkey.getInServiceCountry().equalsIgnoreCase(serviceCountry)) {
                monkey.setReserved(true);
                System.out.println("\nMonkey " + monkey.getName() + " has been reserved for service in " + serviceCountry);
                animalFound = true;
                break;
            }
        }
    }
    
    if (!animalFound) {
        System.out.println("\nNo available " + animalType + " found for service in " + serviceCountry);
    }
}
```

### printAnimals()

#### Requirements
- Print lists of animals based on criteria
- Support different list types (dogs, monkeys, available)
- Format output for readability

#### Implementation
```java
public static void printAnimals(String listType) {
    switch (listType.toLowerCase()) {
        case "dog":
            // Print all dogs
            System.out.println("\n\nDOGS IN THE SYSTEM:");
            System.out.println("------------------------------------------");
            
            if (dogList.isEmpty()) {
                System.out.println("No dogs in the system.");
            } else {
                System.out.printf("%-10s %-15s %-10s %-10s %-15s %-15s%n", 
                                 "Name", "Breed", "Status", "Reserved", "Service Country", "Acquisition Country");
                System.out.println("------------------------------------------");
                
                for (Dog dog : dogList) {
                    System.out.printf("%-10s %-15s %-10s %-10s %-15s %-15s%n", 
                                     dog.getName(), dog.getBreed(), dog.getTrainingStatus(), 
                                     dog.getReserved(), dog.getInServiceCountry(), dog.getAcquisitionCountry());
                }
            }
            break;
            
        case "monkey":
            // Print all monkeys
            System.out.println("\n\nMONKEYS IN THE SYSTEM:");
            System.out.println("------------------------------------------");
            
            if (monkeyList.isEmpty()) {
                System.out.println("No monkeys in the system.");
            } else {
                System.out.printf("%-10s %-15s %-10s %-10s %-15s %-15s%n", 
                                 "Name", "Species", "Status", "Reserved", "Service Country", "Acquisition Country");
                System.out.println("------------------------------------------");
                
                for (Monkey monkey : monkeyList) {
                    System.out.printf("%-10s %-15s %-10s %-10s %-15s %-15s%n", 
                                     monkey.getName(), monkey.getSpecies(), monkey.getTrainingStatus(), 
                                     monkey.getReserved(), monkey.getInServiceCountry(), monkey.getAcquisitionCountry());
                }
            }
            break;
            
        case "available":
            // Print all available animals (not reserved and in service)
            System.out.println("\n\nAVAILABLE ANIMALS (NOT RESERVED AND IN SERVICE):");
            System.out.println("------------------------------------------");
            
            boolean availableFound = false;
            
            // Print header
            System.out.printf("%-10s %-10s %-15s %-10s %-15s%n", 
                             "Name", "Type", "Breed/Species", "Status", "Service Country");
            System.out.println("------------------------------------------");
            
            // Print available dogs
            for (Dog dog : dogList) {
                if (!dog.getReserved() && dog.getTrainingStatus().equalsIgnoreCase("in service")) {
                    System.out.printf("%-10s %-10s %-15s %-10s %-15s%n", 
                                     dog.getName(), "Dog", dog.getBreed(), dog.getTrainingStatus(), dog.getInServiceCountry());
                    availableFound = true;
                }
            }
            
            // Print available monkeys
            for (Monkey monkey : monkeyList) {
                if (!monkey.getReserved() && monkey.getTrainingStatus().equalsIgnoreCase("in service")) {
                    System.out.printf("%-10s %-10s %-15s %-10s %-15s%n", 
                                     monkey.getName(), "Monkey", monkey.getSpecies(), monkey.getTrainingStatus(), monkey.getInServiceCountry());
                    availableFound = true;
                }
            }
            
            if (!availableFound) {
                System.out.println("No available animals found.");
            }
            break;
            
        default:
            System.out.println("Invalid list type specified.");
            break;
    }
}
```

## Exemplary Features

### Detailed Constructor
```java
public Monkey(String name, String species, String gender, String age, String weight,
             String tailLength, String height, String bodyLength, String acquisitionDate,
             String acquisitionCountry, String trainingStatus, boolean reserved,
             String inServiceCountry) {
    // Implementation shown above
}
```

### Comprehensive printAnimals() Method
- Handles multiple list types
- Includes formatted output
- Shows both basic and advanced filtering options

## Input Validation

### Species Validation
```java
public static boolean isValidSpecies(String species) {
    for (String validSpecies : VALID_SPECIES) {
        if (validSpecies.equalsIgnoreCase(species)) {
            return true;
        }
    }
    return false;
}
```

### Training Status Validation
```java
public static boolean isValidTrainingStatus(String status) {
    String[] validStatuses = {"intake", "Phase I", "Phase II", "Phase III", "Phase IV", "Phase V", "in service", "farm"};
    
    for (String validStatus : validStatuses) {
        if (validStatus.equalsIgnoreCase(status)) {
            return true;
        }
    }
    
    return false;
}
```

## Code Organization

### Package Structure
```
src/main/java/com/graziosalvare/animalrescue/
    ├── Dog.java
    ├── Driver.java
    ├── Monkey.java
    └── RescueAnimal.java
```

### Key Design Decisions
1. **Inheritance**: `Monkey` and `Dog` both extend `RescueAnimal`
2. **Encapsulation**: All attributes are private with public getters/setters
3. **Input Validation**: Comprehensive validation for user inputs
4. **Code Reuse**: Common functionality in parent class
5. **Error Handling**: Graceful handling of invalid inputs

This implementation meets all specified requirements and follows object-oriented principles and Java best practices.
