/**
 * Test class for the Animal Rescue Tracker application
 * This class tests the functionality of the RescueAnimal, Dog, and Monkey classes
 * 
 * @author Jadan Morrow
 * @version 1.0
 */
public class TestAnimalRescueTracker {
    
    /**
     * Main method - entry point of the test application
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Starting Animal Rescue Tracker Tests...");
        System.out.println("=======================================");
        
        // Test RescueAnimal class
        testRescueAnimal();
        
        // Test Dog class
        testDog();
        
        // Test Monkey class
        testMonkey();
        
        // Test method name consistency
        testMethodNameConsistency();
        
        System.out.println("=======================================");
        System.out.println("All tests completed successfully!");
    }
    
    /**
     * Test the RescueAnimal class functionality
     */
    private static void testRescueAnimal() {
        System.out.println("\nTesting RescueAnimal class...");
        
        // Create a RescueAnimal object
        RescueAnimal animal = new RescueAnimal();
        
        // Test setter methods
        animal.setName("Test Animal");
        animal.setAnimalType("Generic");
        animal.setGender("male");
        animal.setAge("5");
        animal.setWeight("50.5");
        animal.setAcquisitionDate("01-01-2023");
        animal.setAcquisitionCountry("United States");
        animal.setTrainingStatus("in service");
        animal.setReserved(false);
        animal.setInServiceCountry("Canada");
        
        // Test getter methods
        System.out.println("Name: " + animal.getName());
        System.out.println("Animal Type: " + animal.getAnimalType());
        System.out.println("Gender: " + animal.getGender());
        System.out.println("Age: " + animal.getAge());
        System.out.println("Weight: " + animal.getWeight());
        System.out.println("Acquisition Date: " + animal.getAcquisitionDate());
        System.out.println("Acquisition Country: " + animal.getAcquisitionCountry());
        System.out.println("Training Status: " + animal.getTrainingStatus());
        System.out.println("Reserved: " + animal.getReserved());
        System.out.println("In Service Country: " + animal.getInServiceCountry());
        
        // Verify values
        assert animal.getName().equals("Test Animal") : "Name getter/setter failed";
        assert animal.getAnimalType().equals("Generic") : "AnimalType getter/setter failed";
        assert animal.getGender().equals("male") : "Gender getter/setter failed";
        assert animal.getAge().equals("5") : "Age getter/setter failed";
        assert animal.getWeight().equals("50.5") : "Weight getter/setter failed";
        assert animal.getAcquisitionDate().equals("01-01-2023") : "AcquisitionDate getter/setter failed";
        assert animal.getAcquisitionCountry().equals("United States") : "AcquisitionCountry getter/setter failed";
        assert animal.getTrainingStatus().equals("in service") : "TrainingStatus getter/setter failed";
        assert animal.getReserved() == false : "Reserved getter/setter failed";
        assert animal.getInServiceCountry().equals("Canada") : "InServiceCountry getter/setter failed";
        
        System.out.println("RescueAnimal tests passed!");
    }
    
    /**
     * Test the Dog class functionality
     */
    private static void testDog() {
        System.out.println("\nTesting Dog class...");
        
        // Create a Dog object
        Dog dog = new Dog("Buddy", "Labrador", "male", "3", "65.2", 
                         "02-15-2022", "United States", "in service", false, "United States");
        
        // Test Dog-specific getter/setter
        System.out.println("Breed: " + dog.getBreed());
        dog.setBreed("Golden Retriever");
        System.out.println("Updated Breed: " + dog.getBreed());
        
        // Test inherited methods
        System.out.println("Name: " + dog.getName());
        System.out.println("Animal Type: " + dog.getAnimalType());
        System.out.println("Acquisition Country: " + dog.getAcquisitionCountry());
        System.out.println("In Service Country: " + dog.getInServiceCountry());
        
        // Verify values
        assert dog.getName().equals("Buddy") : "Name getter/setter failed";
        assert dog.getBreed().equals("Golden Retriever") : "Breed getter/setter failed";
        assert dog.getAnimalType().equals("dog") : "AnimalType not set correctly";
        assert dog.getAcquisitionCountry().equals("United States") : "AcquisitionCountry getter/setter failed";
        assert dog.getInServiceCountry().equals("United States") : "InServiceCountry getter/setter failed";
        
        System.out.println("Dog tests passed!");
    }
    
    /**
     * Test the Monkey class functionality
     */
    private static void testMonkey() {
        System.out.println("\nTesting Monkey class...");
        
        // Test species validation
        System.out.println("Valid species test:");
        String[] testSpecies = {"Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin", "Invalid"};
        for (String species : testSpecies) {
            System.out.println(species + " is " + (Monkey.isValidSpecies(species) ? "valid" : "invalid"));
        }
        
        // Create a Monkey object
        Monkey monkey = new Monkey("George", "Capuchin", "male", "4", "12.5", 
                                  "25", "45", "40", "03-20-2021", 
                                  "Brazil", "Phase IV", false, "United States");
        
        // Test Monkey-specific getters
        System.out.println("Species: " + monkey.getSpecies());
        System.out.println("Tail Length: " + monkey.getTailLength());
        System.out.println("Height: " + monkey.getHeight());
        System.out.println("Body Length: " + monkey.getBodyLength());
        
        // Test inherited methods
        System.out.println("Name: " + monkey.getName());
        System.out.println("Animal Type: " + monkey.getAnimalType());
        System.out.println("Acquisition Country: " + monkey.getAcquisitionCountry());
        System.out.println("In Service Country: " + monkey.getInServiceCountry());
        
        // Verify values
        assert monkey.getName().equals("George") : "Name getter/setter failed";
        assert monkey.getSpecies().equals("Capuchin") : "Species getter/setter failed";
        assert monkey.getTailLength().equals("25") : "TailLength getter/setter failed";
        assert monkey.getHeight().equals("45") : "Height getter/setter failed";
        assert monkey.getBodyLength().equals("40") : "BodyLength getter/setter failed";
        assert monkey.getAnimalType().equals("monkey") : "AnimalType not set correctly";
        assert monkey.getAcquisitionCountry().equals("Brazil") : "AcquisitionCountry getter/setter failed";
        assert monkey.getInServiceCountry().equals("United States") : "InServiceCountry getter/setter failed";
        
        // Test invalid species handling
        Monkey invalidMonkey = new Monkey();
        invalidMonkey.setSpecies("Invalid");
        assert invalidMonkey.getSpecies().equals("") : "Invalid species validation failed";
        
        System.out.println("Monkey tests passed!");
    }
    
    /**
     * Test method name consistency across classes
     */
    private static void testMethodNameConsistency() {
        System.out.println("\nTesting method name consistency...");
        
        // Create objects
        RescueAnimal animal = new RescueAnimal();
        Dog dog = new Dog("Rex", "German Shepherd", "male", "2", "70.0", 
                         "01-01-2022", "Germany", "Phase III", false, "United States");
        Monkey monkey = new Monkey("Curious", "Tamarin", "male", "3", "10.0", 
                                  "20", "35", "30", "02-02-2022", 
                                  "Peru", "Phase II", false, "United States");
        
        // Test acquisition country methods
        animal.setAcquisitionCountry("Test Country");
        dog.setAcquisitionCountry("Test Country");
        monkey.setAcquisitionCountry("Test Country");
        
        assert animal.getAcquisitionCountry().equals("Test Country") : "RescueAnimal getAcquisitionCountry failed";
        assert dog.getAcquisitionCountry().equals("Test Country") : "Dog getAcquisitionCountry failed";
        assert monkey.getAcquisitionCountry().equals("Test Country") : "Monkey getAcquisitionCountry failed";
        
        // Test in-service country methods
        animal.setInServiceCountry("Service Country");
        dog.setInServiceCountry("Service Country");
        monkey.setInServiceCountry("Service Country");
        
        assert animal.getInServiceCountry().equals("Service Country") : "RescueAnimal getInServiceCountry failed";
        assert dog.getInServiceCountry().equals("Service Country") : "Dog getInServiceCountry failed";
        assert monkey.getInServiceCountry().equals("Service Country") : "Monkey getInServiceCountry failed";
        
        System.out.println("Method name consistency tests passed!");
    }
}
