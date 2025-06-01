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
                    System.out.println("\nExiting the application. Goodbye!");
                    break;
                    
                default:
                    // Invalid input - provide feedback to user
                    System.out.println("\nInvalid input. Please enter a number from 1-6 or 'q' to quit.");
                    break;
            }
            
        } while (!menuChoice.equalsIgnoreCase("q"));
        
        // Close the scanner
        scanner.close();
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
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


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    /**
     * Adds monkeys to a list for testing
     * Initializes the monkey list with sample data
     */
    public static void initializeMonkeyList() {
        // Create sample monkey objects
        Monkey monkey1 = new Monkey("Curious", "Capuchin", "male", "3", "10.5", 
                                  "20", "40", "35", "01-02-2022", 
                                  "Brazil", "in service", false, "United States");
                                  
        Monkey monkey2 = new Monkey("George", "Tamarin", "male", "5", "8.2", 
                                  "18", "35", "30", "03-15-2021", 
                                  "Peru", "Phase IV", false, "United States");
                                  
        Monkey monkey3 = new Monkey("Lucy", "Macaque", "female", "4", "12.1", 
                                  "22", "42", "38", "05-20-2020", 
                                  "Indonesia", "in service", true, "Canada");
        
        // Add the monkeys to the list
        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }


    /**
     * Complete the intakeNewDog method
     * Prompts user for dog information, creates a new Dog object,
     * and adds it to the dogList
     * 
     * @param scanner Scanner object for user input
     */
    public static void intakeNewDog(Scanner scanner) {
        // Check if dog name already exists in the system
        System.out.println("\nWhat is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\nThis dog is already in our system\n");
                return; //returns to menu
            }
        }

        // Get dog breed
        System.out.println("\nEnter the dog's breed:");
        String breed = scanner.nextLine();
        
        // Get dog gender with validation
        String gender;
        do {
            System.out.println("\nEnter the dog's gender (male/female):");
            gender = scanner.nextLine().toLowerCase();
            if (!gender.equals("male") && !gender.equals("female")) {
                System.out.println("Invalid input. Please enter 'male' or 'female'.");
            }
        } while (!gender.equals("male") && !gender.equals("female"));
        
        // Get dog age
        System.out.println("\nEnter the dog's age:");
        String age = scanner.nextLine();
        
        // Get dog weight
        System.out.println("\nEnter the dog's weight:");
        String weight = scanner.nextLine();
        
        // Get acquisition date
        System.out.println("\nEnter the acquisition date (MM-DD-YYYY):");
        String acquisitionDate = scanner.nextLine();
        
        // Get acquisition country
        System.out.println("\nEnter the acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        
        // Get training status with validation
        String trainingStatus;
        do {
            System.out.println("\nEnter the training status (intake/Phase I/Phase II/Phase III/Phase IV/Phase V/in service/farm):");
            trainingStatus = scanner.nextLine();
            if (!isValidTrainingStatus(trainingStatus)) {
                System.out.println("Invalid training status. Please try again.");
            }
        } while (!isValidTrainingStatus(trainingStatus));
        
        // Get reserved status
        System.out.println("\nIs the dog reserved? (true/false):");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        
        // Get in-service country
        System.out.println("\nEnter the in-service country:");
        String inServiceCountry = scanner.nextLine();
        
        // Create new Dog object with collected information
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, 
                            acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        
        // Add the new dog to the list
        dogList.add(newDog);
        
        System.out.println("\nDog successfully added to the system!\n");
    }


    /**
     * Implements the intakeNewMonkey method
     * Prompts user for monkey information, validates input,
     * creates a new Monkey object, and adds it to the monkeyList
     * 
     * @param scanner Scanner object for user input
     */
    public static void intakeNewMonkey(Scanner scanner) {
        // Check if monkey name already exists in the system
        System.out.println("\nWhat is the monkey's name?");
        String name = scanner.nextLine();
        for(Monkey monkey: monkeyList) {
            if(monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\nThis monkey is already in our system\n");
                return; //returns to menu
            }
        }
        
        // Get and validate monkey species
        String species;
        boolean validSpecies = false;
        do {
            System.out.println("\nEnter the monkey's species:");
            System.out.println("Eligible species: Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin");
            species = scanner.nextLine();
            
            // Validate species using the Monkey class method
            if (Monkey.isValidSpecies(species)) {
                validSpecies = true;
            } else {
                System.out.println("Invalid species. Please enter one of the eligible species.");
            }
        } while (!validSpecies);
        
        // Get monkey gender with validation
        String gender;
        do {
            System.out.println("\nEnter the monkey's gender (male/female):");
            gender = scanner.nextLine().toLowerCase();
            if (!gender.equals("male") && !gender.equals("female")) {
                System.out.println("Invalid input. Please enter 'male' or 'female'.");
            }
        } while (!gender.equals("male") && !gender.equals("female"));
        
        // Get monkey age
        System.out.println("\nEnter the monkey's age:");
        String age = scanner.nextLine();
        
        // Get monkey weight
        System.out.println("\nEnter the monkey's weight:");
        String weight = scanner.nextLine();
        
        // Get tail length
        System.out.println("\nEnter the monkey's tail length (in cm):");
        String tailLength = scanner.nextLine();
        
        // Get height
        System.out.println("\nEnter the monkey's height (in cm):");
        String height = scanner.nextLine();
        
        // Get body length
        System.out.println("\nEnter the monkey's body length (in cm):");
        String bodyLength = scanner.nextLine();
        
        // Get acquisition date
        System.out.println("\nEnter the acquisition date (MM-DD-YYYY):");
        String acquisitionDate = scanner.nextLine();
        
        // Get acquisition country
        System.out.println("\nEnter the acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        
        // Get training status with validation
        String trainingStatus;
        do {
            System.out.println("\nEnter the training status (intake/Phase I/Phase II/Phase III/Phase IV/Phase V/in service/farm):");
            trainingStatus = scanner.nextLine();
            if (!isValidTrainingStatus(trainingStatus)) {
                System.out.println("Invalid training status. Please try again.");
            }
        } while (!isValidTrainingStatus(trainingStatus));
        
        // Get reserved status
        System.out.println("\nIs the monkey reserved? (true/false):");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        
        // Get in-service country
        System.out.println("\nEnter the in-service country:");
        String inServiceCountry = scanner.nextLine();
        
        // Create new Monkey object with collected information
        Monkey newMonkey = new Monkey(name, species, gender, age, weight, tailLength, 
                                     height, bodyLength, acquisitionDate, acquisitionCountry, 
                                     trainingStatus, reserved, inServiceCountry);
        
        // Add the new monkey to the list
        monkeyList.add(newMonkey);
        
        System.out.println("\nMonkey successfully added to the system!\n");
    }

    /**
     * Implements the reserveAnimal method
     * Allows user to reserve an animal by type and country
     * Updates the reserved status of the selected animal
     * 
     * @param scanner Scanner object for user input
     */
    public static void reserveAnimal(Scanner scanner) {
        // Get animal type with validation
        String animalType;
        do {
            System.out.println("\nEnter animal type (dog/monkey):");
            animalType = scanner.nextLine().toLowerCase();
            if (!animalType.equals("dog") && !animalType.equals("monkey")) {
                System.out.println("Invalid animal type. Please enter 'dog' or 'monkey'.");
            }
        } while (!animalType.equals("dog") && !animalType.equals("monkey"));
        
        // Get in-service country
        System.out.println("\nEnter the country where the animal is in service:");
        String country = scanner.nextLine();
        
        boolean animalFound = false;
        
        // Search for dogs if animal type is dog
        if (animalType.equals("dog")) {
            for (Dog dog : dogList) {
                // Check if dog is in service, not reserved, and matches the country
                if (dog.getTrainingStatus().equalsIgnoreCase("in service") && 
                    !dog.getReserved() && 
                    dog.getInServiceCountry().equalsIgnoreCase(country)) {
                    
                    // Reserve the dog
                    dog.setReserved(true);
                    System.out.println("\nDog " + dog.getName() + " has been reserved.\n");
                    animalFound = true;
                    break; // Reserve only the first available dog
                }
            }
        }
        // Search for monkeys if animal type is monkey
        else if (animalType.equals("monkey")) {
            for (Monkey monkey : monkeyList) {
                // Check if monkey is in service, not reserved, and matches the country
                if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && 
                    !monkey.getReserved() && 
                    monkey.getInServiceCountry().equalsIgnoreCase(country)) {
                    
                    // Reserve the monkey
                    monkey.setReserved(true);
                    System.out.println("\nMonkey " + monkey.getName() + " has been reserved.\n");
                    animalFound = true;
                    break; // Reserve only the first available monkey
                }
            }
        }
        
        // If no animal was found, inform the user
        if (!animalFound) {
            System.out.println("\nSorry, no available " + animalType + "s in " + country + ".\n");
        }
    }

    /**
     * Implements the printAnimals method
     * Prints information about animals based on the listType parameter
     * 
     * @param listType Type of list to print ("dog", "monkey", or "available")
     */
    public static void printAnimals(String listType) {
        // Print header based on list type
        System.out.println("\n============================================");
        
        switch(listType) {
            case "dog":
                // Print list of all dogs
                System.out.println("All Dogs in the System:");
                System.out.println("============================================");
                
                if (dogList.isEmpty()) {
                    System.out.println("No dogs in the system.\n");
                } else {
                    // Print column headers
                    System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", 
                                    "Name", "Status", "Acquisition", "Reserved", "Service Country");
                    System.out.println("--------------------------------------------");
                    
                    // Print each dog's information
                    for (Dog dog : dogList) {
                        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", 
                                        dog.getName(), 
                                        dog.getTrainingStatus(), 
                                        dog.getAcquisitionCountry(), 
                                        dog.getReserved() ? "Yes" : "No", 
                                        dog.getInServiceCountry());
                    }
                }
                break;
                
            case "monkey":
                // Print list of all monkeys
                System.out.println("All Monkeys in the System:");
                System.out.println("============================================");
                
                if (monkeyList.isEmpty()) {
                    System.out.println("No monkeys in the system.\n");
                } else {
                    // Print column headers
                    System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", 
                                    "Name", "Species", "Status", "Acquisition", "Reserved", "Service Country");
                    System.out.println("--------------------------------------------");
                    
                    // Print each monkey's information
                    for (Monkey monkey : monkeyList) {
                        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", 
                                        monkey.getName(), 
                                        monkey.getSpecies(), 
                                        monkey.getTrainingStatus(), 
                                        monkey.getAcquisitionCountry(), 
                                        monkey.getReserved() ? "Yes" : "No", 
                                        monkey.getInServiceCountry());
                    }
                }
                break;
                
            case "available":
                // Print list of all available animals (in service but not reserved)
                System.out.println("All Available Service Animals:");
                System.out.println("============================================");
                
                boolean availableAnimalsFound = false;
                
                // Print column headers
                System.out.printf("%-15s %-15s %-15s %-15s\n", 
                                "Name", "Type", "Status", "Service Country");
                System.out.println("--------------------------------------------");
                
                // Check for available dogs
                for (Dog dog : dogList) {
                    if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                        System.out.printf("%-15s %-15s %-15s %-15s\n", 
                                        dog.getName(), 
                                        "Dog", 
                                        dog.getTrainingStatus(), 
                                        dog.getInServiceCountry());
                        availableAnimalsFound = true;
                    }
                }
                
                // Check for available monkeys
                for (Monkey monkey : monkeyList) {
                    if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                        System.out.printf("%-15s %-15s %-15s %-15s\n", 
                                        monkey.getName(), 
                                        "Monkey", 
                                        monkey.getTrainingStatus(), 
                                        monkey.getInServiceCountry());
                        availableAnimalsFound = true;
                    }
                }
                
                // If no available animals were found, inform the user
                if (!availableAnimalsFound) {
                    System.out.println("No available service animals found.\n");
                }
                break;
                
            default:
                System.out.println("Invalid list type specified.\n");
                break;
        }
        
        System.out.println("============================================\n");
    }
    
    /**
     * Helper method to validate training status
     * 
     * @param status Training status to validate
     * @return true if status is valid, false otherwise
     */
    private static boolean isValidTrainingStatus(String status) {
        String[] validStatuses = {"intake", "Phase I", "Phase II", "Phase III", 
                                 "Phase IV", "Phase V", "in service", "farm"};
        
        for (String validStatus : validStatuses) {
            if (validStatus.equalsIgnoreCase(status)) {
                return true;
            }
        }
        
        return false;
    }
}
