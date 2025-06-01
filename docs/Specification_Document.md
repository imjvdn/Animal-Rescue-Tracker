# Grazioso Salvare Specification Document

## Overview
Grazioso Salvare is an international search-and-rescue animal training company that trains animals to rescue humans from difficult or life-threatening situations. This document outlines the specifications for a software application to help track, search, and manage rescue animals.

## Current Operations
Grazioso Salvare currently uses dogs as search and rescue animals and plans to begin training monkeys as well. In current operations, animals follow a specific status progression:

1. **Intake**: Initial status before training starts
2. **Training Phases**: Phase I, Phase II, Phase III, Phase IV, and Phase V
3. **In Service**: Animals that have graduated from training
4. **Farm**: Animals that did not successfully complete training

## Animal Information Requirements

### Dogs
For each dog, Grazioso Salvare records:
- Name
- Breed
- Gender
- Age
- Weight
- Acquisition date and location
- Training status
- Reservation status
- Service country

### Monkeys
For monkeys, Grazioso Salvare will record all the information tracked for dogs, plus:
- Species (limited to eligible species)
- Tail length
- Height
- Body length

### Eligible Monkey Species
Only the following monkey species are eligible for training:
- Capuchin
- Guenon
- Macaque
- Marmoset
- Squirrel monkey
- Tamarin

## Functional Requirements

### Animal Intake
The system must allow users to:
- Add new dogs to the system
- Add new monkeys to the system
- Validate that animal names are unique within their type
- Validate that monkey species are from the eligible list

### Animal Reservation
The system must allow users to:
- Reserve animals for service
- Search for animals by type and country
- Update an animal's reservation status

### Reporting
The system must allow users to:
- View a list of all dogs
- View a list of all monkeys
- View a list of all animals that are "in service" and not reserved

### User Interface
The system must provide:
- A menu-driven command-line interface
- Clear options for all available actions
- Input validation for all user interactions
- Appropriate feedback for user actions

## Technical Requirements

### Class Structure
The application must include the following classes:
- **RescueAnimal**: Parent class for all rescue animals
- **Dog**: Class for dog-specific attributes and behaviors
- **Monkey**: Class for monkey-specific attributes and behaviors
- **Driver**: Main application class with user interface and core functionality

### Implementation Guidelines
The implementation must follow these guidelines:
- Use object-oriented programming principles
- Include appropriate comments and documentation
- Follow Java naming conventions
- Validate all user inputs
- Use ArrayLists for data storage

## Deliverables
The completed project must include:
- RescueAnimal.java
- Dog.java
- Monkey.java
- Driver.java

---
© 2025 Global Rain. All Rights Reserved.
