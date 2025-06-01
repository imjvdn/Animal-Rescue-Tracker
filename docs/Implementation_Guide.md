# Grazioso Salvare Implementation Guide

## Introduction
This document provides detailed implementation guidelines for the Animal Rescue Tracker application developed for Grazioso Salvare. It outlines the class structure, implementation details, and design decisions made during development.

## Class Structure

### RescueAnimal Class
The RescueAnimal class serves as the parent class for all rescue animals in the system. It encapsulates common attributes and behaviors shared by all rescue animals.

#### Attributes
- `name`: String - The animal's name
- `animalType`: String - Type of animal (e.g., "Dog", "Monkey")
- `gender`: String - The animal's gender
- `age`: String - The animal's age
- `weight`: String - The animal's weight
- `acquisitionDate`: String - Date when the animal was acquired
- `acquisitionCountry`: String - Country where the animal was acquired
- `trainingStatus`: String - Current training status
- `reserved`: boolean - Whether the animal is reserved for service
- `inServiceCountry`: String - Country where the animal is in service

#### Methods
- Accessor methods (getters) for all attributes
- Mutator methods (setters) for all attributes

### Dog Class
The Dog class extends the RescueAnimal class and adds dog-specific attributes and behaviors.

#### Additional Attributes
- `breed`: String - The dog's breed

#### Methods
- Constructor that initializes all attributes
- Accessor and mutator methods for dog-specific attributes

### Monkey Class
The Monkey class extends the RescueAnimal class and adds monkey-specific attributes and behaviors.

#### Additional Attributes
- `species`: String - The monkey's species (limited to specific eligible species)
- `tailLength`: String - Length of the monkey's tail
- `height`: String - Height of the monkey
- `bodyLength`: String - Length of the monkey's body

#### Methods
- Constructor that initializes all attributes
- Accessor and mutator methods for monkey-specific attributes
- Validation method for species type

### Driver Class
The Driver class serves as the main application class that provides the user interface and core functionality.

#### Attributes
- `dogList`: ArrayList<Dog> - List of all dogs in the system
- `monkeyList`: ArrayList<Monkey> - List of all monkeys in the system

#### Methods
- `main()`: Entry point of the application
- `displayMenu()`: Displays the menu options
- `initializeDogList()`: Initializes the dog list with sample data
- `initializeMonkeyList()`: Initializes the monkey list with sample data
- `intakeNewDog()`: Adds a new dog to the system
- `intakeNewMonkey()`: Adds a new monkey to the system
- `reserveAnimal()`: Reserves an animal for service
- `printAnimals()`: Prints animal information based on specified criteria

## Implementation Details

### Training Status Progression
Animals progress through the following training statuses:
1. Intake (initial status)
2. Phase I
3. Phase II
4. Phase III
5. Phase IV
6. Phase V
7. In Service (graduated)
8. Farm (did not complete training)

### Eligible Monkey Species
Only the following monkey species are eligible for training:
- Capuchin
- Guenon
- Macaque
- Marmoset
- Squirrel monkey
- Tamarin

### Input Validation
The application implements comprehensive input validation:
- Validates that animal names are unique within their type
- Validates that monkey species are from the eligible list
- Validates menu selections
- Validates reservation criteria

## Design Decisions

### Object-Oriented Design
The application follows object-oriented design principles:
- **Inheritance**: Monkey and Dog classes inherit from RescueAnimal
- **Encapsulation**: All attributes are private with public accessors and mutators
- **Abstraction**: Common behaviors are defined in the parent class
- **Polymorphism**: Animal-specific behaviors are implemented in child classes

### Data Storage
The application uses ArrayLists to store animal objects, allowing for:
- Dynamic addition of new animals
- Efficient searching and filtering
- Type-safe storage of animal objects

### User Interface
The application uses a command-line interface with a menu-driven approach to:
- Provide clear options to the user
- Validate user input
- Display appropriate feedback

## Future Enhancements
Potential future enhancements for the system include:
- Persistent storage (database integration)
- Additional animal types
- Advanced search and filtering capabilities
- Graphical user interface
- Training history tracking
- Health record integration

---
© 2025 Global Rain. All Rights Reserved.
