package com.graziosalvare.animalrescue;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Driver class for the Animal Rescue Tracker application
 * This class provides the main functionality and user interface
 * for the Grazioso Salvare animal tracking system.
 * 
 * @author Jadan Morrow
 * @version 1.0
 */
public class Driver {
    // ArrayList to store all dogs in the system
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    
    // ArrayList to store all monkeys in the system
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    /**
     * Main method - entry point of the application
     * Displays menu, accepts user input, and takes appropriate action
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize the animal lists with sample data
        initializeDogList();
        initializeMonkeyList();
        
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Variable to store user's menu choice
        String menuChoice;
        
        // Main menu loop - continues until user chooses to quit
        do {
            // Display the menu options
            displayMenu();
            
            // Get user's choice
            menuChoice = scanner.nextLine().trim();
            
            // Process user's choice with input validation
            switch(menuChoice) {
                case "1":
                    // Intake a new dog
                    intakeNewDog(scanner);
                    break;
                    
                case "2":
                    // Intake a new monkey
                    intakeNewMonkey(scanner);
                    break;
                    
                case "3":
                    // Reserve an animal
                    reserveAnimal(scanner);
                    break;
                    
                case "4":
                    // Print a list of all dogs
                    printAnimals("dog");
                    break;
                    
                case "5":
                    // Print a list of all monkeys
                    printAnimals("monkey");
                    break;
                    
                case "6":
                    // Print a list of all animals that are not reserved
                    printAnimals("available");
                    break;
                    
                case "q":
                    // Quit the application
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                    
                default:
                    // Invalid menu choice
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
            
            // Pause to allow user to read output before showing menu again
            if (!menuChoice.equalsIgnoreCase("q")) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
            
        } while (!menuChoice.equalsIgnoreCase("q"));
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }

    /**
     * Displays the main menu options to the user
     */
    public static void displayMenu() {
        System.out.println("\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    /**
     * Adds sample dogs to the dogList ArrayList
     */
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    /**
     * Adds sample monkeys to the monkeyList ArrayList
     */
    public static void initializeMonkeyList() {
        // Initialize with sample monkey data
        Monkey monkey1 = new Monkey("Curious George", "Capuchin", "male", "3", "10.5", 
                                   "12.5", "20.0", "15.0", "01-15-2021", 
                                   "Brazil", "Phase I", false, "United States");
        
        Monkey monkey2 = new Monkey("Cheeta", "Macaque", "female", "5", "15.2", 
                                   "14.0", "22.5", "18.0", "03-22-2020", 
                                   "Indonesia", "in service", true, "United States");
        
        Monkey monkey3 = new Monkey("Marcel", "Capuchin", "male", "2", "8.7", 
                                   "11.0", "18.5", "14.0", "05-10-2022", 
                                   "Peru", "intake", false, "United States");
        
        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }

    /**
     * Validates if a training status is valid
     * 
     * @param status The training status to validate
     * @return true if the status is valid, false otherwise
     */
    public static boolean isValidTrainingStatus(String status) {
        String[] validStatuses = {"intake", "Phase I", "Phase II", "Phase III", "Phase IV", "Phase V", "in service", "farm"};
        
        for (String validStatus : validStatuses) {
            if (validStatus.equalsIgnoreCase(status)) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Intakes a new dog into the system
     * Prompts user for dog attributes, validates input, and adds to dogList
     * 
     * @param scanner Scanner object for user input
     */
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        
        // Check if dog already exists
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; // Return to menu
            }
        }

        // Get dog attributes from user
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();
        
        System.out.println("What is the dog's gender (male/female)?");
        String gender = scanner.nextLine();
        
        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();
        
        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();
        
        System.out.println("What is the dog's acquisition date (mm-dd-yyyy)?");
        String acquisitionDate = scanner.nextLine();
        
        System.out.println("What is the dog's acquisition country?");
        String acquisitionCountry = scanner.nextLine();
        
        // Get and validate training status
        String trainingStatus;
        do {
            System.out.println("What is the dog's training status? (intake, Phase I, Phase II, Phase III, Phase IV, Phase V, in service, farm)");
            trainingStatus = scanner.nextLine();
            
            if (!isValidTrainingStatus(trainingStatus)) {
                System.out.println("Invalid training status. Please enter a valid status.");
            }
        } while (!isValidTrainingStatus(trainingStatus));
        
        System.out.println("Is the dog reserved? (true/false)");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        
        System.out.println("What is the dog's service country?");
        String inServiceCountry = scanner.nextLine();
        
        // Create new dog and add to list
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        dogList.add(newDog);
        
        System.out.println("\nDog successfully added to the system!");
    }

    /**
     * Intakes a new monkey into the system
     * Prompts user for monkey attributes, validates input, and adds to monkeyList
     * 
     * @param scanner Scanner object for user input
     */
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();
        
        // Check if monkey already exists
        for(Monkey monkey: monkeyList) {
            if(monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; // Return to menu
            }
        }
        
        // Get and validate monkey species
        String species;
        boolean validSpecies = false;
        do {
            System.out.println("What is the monkey's species?");
            System.out.println("Valid species: Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin");
            species = scanner.nextLine();
            
            validSpecies = Monkey.isValidSpecies(species);
            if (!validSpecies) {
                System.out.println("Invalid species. Please enter a valid monkey species.");
            }
        } while (!validSpecies);
        
        // Get monkey attributes from user
        System.out.println("What is the monkey's gender (male/female)?");
        String gender = scanner.nextLine();
        
        System.out.println("What is the monkey's age?");
        String age = scanner.nextLine();
        
        System.out.println("What is the monkey's weight?");
        String weight = scanner.nextLine();
        
        System.out.println("What is the monkey's tail length?");
        String tailLength = scanner.nextLine();
        
        System.out.println("What is the monkey's height?");
        String height = scanner.nextLine();
        
        System.out.println("What is the monkey's body length?");
        String bodyLength = scanner.nextLine();
        
        System.out.println("What is the monkey's acquisition date (mm-dd-yyyy)?");
        String acquisitionDate = scanner.nextLine();
        
        System.out.println("What is the monkey's acquisition country?");
        String acquisitionCountry = scanner.nextLine();
        
        // Get and validate training status
        String trainingStatus;
        do {
            System.out.println("What is the monkey's training status? (intake, Phase I, Phase II, Phase III, Phase IV, Phase V, in service, farm)");
            trainingStatus = scanner.nextLine();
            
            if (!isValidTrainingStatus(trainingStatus)) {
                System.out.println("Invalid training status. Please enter a valid status.");
            }
        } while (!isValidTrainingStatus(trainingStatus));
        
        System.out.println("Is the monkey reserved? (true/false)");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        
        System.out.println("What is the monkey's service country?");
        String inServiceCountry = scanner.nextLine();
        
        // Create new monkey and add to list
        Monkey newMonkey = new Monkey(name, species, gender, age, weight, tailLength, height, bodyLength, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        monkeyList.add(newMonkey);
        
        System.out.println("\nMonkey successfully added to the system!");
    }

    /**
     * Reserves an animal for service
     * Prompts user for animal type and service country, then finds and reserves an available animal
     * 
     * @param scanner Scanner object for user input
     */
    public static void reserveAnimal(Scanner scanner) {
        // Get animal type from user
        System.out.println("Enter animal type (dog/monkey):");
        String animalType = scanner.nextLine().toLowerCase();
        
        // Validate animal type
        if (!animalType.equals("dog") && !animalType.equals("monkey")) {
            System.out.println("Invalid animal type. Please enter 'dog' or 'monkey'.");
            return;
        }
        
        // Get service country from user
        System.out.println("Enter the service country:");
        String serviceCountry = scanner.nextLine();
        
        boolean animalFound = false;
        
        // Process based on animal type
        if (animalType.equals("dog")) {
            // Look for available dogs for the specified service country
            for (Dog dog : dogList) {
                if (!dog.getReserved() && dog.getTrainingStatus().equalsIgnoreCase("in service") && 
                    dog.getInServiceCountry().equalsIgnoreCase(serviceCountry)) {
                    // Reserve the dog
                    dog.setReserved(true);
                    System.out.println("\nDog " + dog.getName() + " has been reserved for service in " + serviceCountry);
                    animalFound = true;
                    break; // Reserve only one dog
                }
            }
        } else { // monkey
            // Look for available monkeys for the specified service country
            for (Monkey monkey : monkeyList) {
                if (!monkey.getReserved() && monkey.getTrainingStatus().equalsIgnoreCase("in service") && 
                    monkey.getInServiceCountry().equalsIgnoreCase(serviceCountry)) {
                    // Reserve the monkey
                    monkey.setReserved(true);
                    System.out.println("\nMonkey " + monkey.getName() + " has been reserved for service in " + serviceCountry);
                    animalFound = true;
                    break; // Reserve only one monkey
                }
            }
        }
        
        // If no suitable animal was found
        if (!animalFound) {
            System.out.println("\nNo available " + animalType + " found for service in " + serviceCountry);
        }
    }

    /**
     * Prints lists of animals based on specified criteria
     * 
     * @param listType Type of list to print: "dog", "monkey", or "available"
     */
    public static void printAnimals(String listType) {
        switch (listType.toLowerCase()) {
            case "dog":
                // Print all dogs
                System.out.println("\n\nDOGS IN THE SYSTEM:");
                System.out.println("------------------------------------------");
                
                if (dogList.isEmpty()) {
                    System.out.println("No dogs in the system.");
                } else {
                    // Print header
                    System.out.printf("%-10s %-15s %-10s %-10s %-15s %-15s%n", 
                                     "Name", "Breed", "Status", "Reserved", "Service Country", "Acquisition Country");
                    System.out.println("------------------------------------------");
                    
                    // Print each dog's details
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
                    // Print header
                    System.out.printf("%-10s %-15s %-10s %-10s %-15s %-15s%n", 
                                     "Name", "Species", "Status", "Reserved", "Service Country", "Acquisition Country");
                    System.out.println("------------------------------------------");
                    
                    // Print each monkey's details
                    for (Monkey monkey : monkeyList) {
                        System.out.printf("%-10s %-15s %-10s %-10s %-15s %-15s%n", 
                                         monkey.getName(), monkey.getSpecies(), monkey.getTrainingStatus(), 
                                         monkey.getReserved(), monkey.getInServiceCountry(), monkey.getAcquisitionCountry());
                    }
                }
                break;
                
            case "available":
                // Print all available animals (not reserved)
                System.out.println("\n\nAVAILABLE ANIMALS (NOT RESERVED):");
                System.out.println("------------------------------------------");
                
                boolean availableFound = false;
                
                // Print header
                System.out.printf("%-10s %-10s %-15s %-10s %-15s%n", 
                                 "Name", "Type", "Breed/Species", "Status", "Service Country");
                System.out.println("------------------------------------------");
                
                // Print available dogs
                for (Dog dog : dogList) {
                    if (!dog.getReserved()) {
                        System.out.printf("%-10s %-10s %-15s %-10s %-15s%n", 
                                         dog.getName(), "Dog", dog.getBreed(), dog.getTrainingStatus(), dog.getInServiceCountry());
                        availableFound = true;
                    }
                }
                
                // Print available monkeys
                for (Monkey monkey : monkeyList) {
                    if (!monkey.getReserved()) {
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
}
