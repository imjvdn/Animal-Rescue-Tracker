# Animal Rescue Tracker

## Project Overview

The Animal Rescue Tracker is a comprehensive management system developed for Grazioso Salvare, an international search-and-rescue animal training organization. This Java-based application enables efficient tracking, management, and deployment of rescue animals that are trained to assist humans in life-threatening situations across the globe.

## Table of Contents

- [Project Overview](#project-overview)
- [Key Features](#key-features)
- [System Architecture](#system-architecture)
- [Class Structure](#class-structure)
- [Training Status Workflow](#training-status-workflow)
- [Installation and Setup](#installation-and-setup)
- [Usage Guide](#usage-guide)
- [Testing](#testing)
- [Development Workflow](#development-workflow)
- [Contributing](#contributing)
- [License](#license)

## Key Features

- **Animal Intake Processing**: Streamlined intake of new rescue animals (dogs and monkeys) with comprehensive data validation
- **Training Status Management**: Track animals through multiple training phases with detailed progress monitoring
- **Reservation System**: Reserve trained animals for deployment to specific service countries
- **Reporting Capabilities**: Generate detailed reports of animals by type, status, and availability
- **Data Validation**: Robust input validation for all animal attributes including species-specific validation

## System Architecture

The Animal Rescue Tracker implements a robust object-oriented architecture with proper inheritance hierarchies and encapsulation. The system follows these design principles:

- **Inheritance**: Specialized animal classes inherit from a base RescueAnimal class
- **Encapsulation**: All attributes are properly encapsulated with appropriate accessor and mutator methods
- **Validation**: Input validation is implemented at multiple levels to ensure data integrity
- **User Interface**: Command-line interface with intuitive menu-driven interaction

## Class Structure

### RescueAnimal Class

Base abstract class for all rescue animals with common attributes:

- **Basic Information**: name, animalType, gender, age, weight
- **Acquisition Details**: acquisitionDate, acquisitionCountry
- **Training Information**: trainingStatus
- **Service Details**: reserved (boolean), inServiceCountry

### Dog Class

Extends RescueAnimal with dog-specific attributes:

- **Breed**: Specific dog breed information
- Inherits all base attributes and behaviors from RescueAnimal

### Monkey Class

Extends RescueAnimal with monkey-specific attributes:

- **Species**: Limited to specific eligible species (Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin)
- **Physical Characteristics**: tailLength, height, bodyLength
- **Validation**: Species validation to ensure only eligible monkey species are accepted

### Driver Class

Main application controller that provides:

- **User Interface**: Menu-driven command-line interface
- **Data Management**: Methods for animal intake, reservation, and reporting
- **Input Validation**: Comprehensive validation for all user inputs
- **Test Data**: Sample data initialization for demonstration purposes

## Training Status Workflow

Animals progress through a structured training pipeline:

1. **Intake**: Initial registration and assessment
2. **Phase I**: Basic obedience and aptitude testing
3. **Phase II**: Specialized skill development
4. **Phase III**: Advanced training techniques
5. **Phase IV**: Scenario-based training
6. **Phase V**: Final assessment and certification
7. **In Service**: Fully trained and available for deployment
8. **Farm**: Retirement for animals that did not complete training

## Installation and Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Command-line terminal

### Installation Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/imjvdn/Animal-Rescue-Tracker.git
   ```

2. Navigate to the project directory:
   ```bash
   cd Animal-Rescue-Tracker
   ```

3. Compile the Java files:
   ```bash
   javac *.java
   ```

4. Run the application:
   ```bash
   java Driver
   ```

## Usage Guide

### Main Menu Options

1. **Intake a new dog**: Register a new dog with the system
2. **Intake a new monkey**: Register a new monkey with the system
3. **Reserve an animal**: Reserve an available animal for service
4. **Print a list of all dogs**: View all dogs in the system
5. **Print a list of all monkeys**: View all monkeys in the system
6. **Print a list of all animals that are not reserved**: View available animals
7. **Quit application**: Exit the system

### Testing

A comprehensive test suite is included to verify system functionality:

```bash
java TestAnimalRescueTracker
```

The test suite validates:
- RescueAnimal class functionality
- Dog class inheritance and specific methods
- Monkey class inheritance, species validation, and specific attributes
- Method name consistency across all classes

## Development Workflow

This project follows a structured Git workflow:

1. **Feature Branches**: New features are developed in dedicated feature branches
2. **Code Reviews**: All code changes undergo peer review before merging
3. **Testing**: Comprehensive testing is performed on all changes
4. **Documentation**: All code is thoroughly documented with JavaDoc comments

## Contributing

Contributions to the Animal Rescue Tracker project should follow these guidelines:

1. Fork the repository
2. Create a feature branch from develop (`git checkout -b feature/your-feature-name develop`)
3. Implement your changes with appropriate tests and documentation
4. Submit a pull request to the develop branch

## License

This project is proprietary software developed for Grazioso Salvare by Global Rain.

---

© 2025 Global Rain. All Rights Reserved.

*Developed by Jadan Morrow*
