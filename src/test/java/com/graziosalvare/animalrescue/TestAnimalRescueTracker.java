package com.graziosalvare.animalrescue;

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
        animal.setTrainingStatus("Phase I");
        animal.setReserved(false);
        animal.setInServiceCountry("Canada");
        
        // Test getter methods
        assert animal.getName().equals("Test Animal") : "getName() failed";
        assert animal.getAnimalType().equals("Generic") : "getAnimalType() failed";
        assert animal.getGender().equals("male") : "getGender() failed";
        assert animal.getAge().equals("5") : "getAge() failed";
        assert animal.getWeight().equals("50.5") : "getWeight() failed";
        assert animal.getAcquisitionDate().equals("01-01-2023") : "getAcquisitionDate() failed";
        assert animal.getAcquisitionCountry().equals("United States") : "getAcquisitionCountry() failed";
        assert animal.getTrainingStatus().equals("Phase I") : "getTrainingStatus() failed";
        assert animal.getReserved() == false : "getReserved() failed";
        assert animal.getInServiceCountry().equals("Canada") : "getInServiceCountry() failed";
        
        System.out.println("RescueAnimal tests passed!");
    }
    
    /**
     * Test the Dog class functionality
     */
    private static void testDog() {
        System.out.println("\nTesting Dog class...");
        
        // Create a Dog object
        Dog dog = new Dog("Rex", "German Shepherd", "male", "3", "70.5", 
                         "02-15-2022", "Germany", "in service", true, "United States");
        
        // Test inherited methods
        assert dog.getName().equals("Rex") : "getName() failed";
        assert dog.getAnimalType().equals("dog") : "getAnimalType() failed";
        assert dog.getGender().equals("male") : "getGender() failed";
        assert dog.getAge().equals("3") : "getAge() failed";
        assert dog.getWeight().equals("70.5") : "getWeight() failed";
        assert dog.getAcquisitionDate().equals("02-15-2022") : "getAcquisitionDate() failed";
        assert dog.getAcquisitionCountry().equals("Germany") : "getAcquisitionCountry() failed";
        assert dog.getTrainingStatus().equals("in service") : "getTrainingStatus() failed";
        assert dog.getReserved() == true : "getReserved() failed";
        assert dog.getInServiceCountry().equals("United States") : "getInServiceCountry() failed";
        
        // Test Dog-specific methods
        assert dog.getBreed().equals("German Shepherd") : "getBreed() failed";
        
        // Test setter method
        dog.setBreed("Labrador");
        assert dog.getBreed().equals("Labrador") : "setBreed() failed";
        
        System.out.println("Dog tests passed!");
    }
    
    /**
     * Test the Monkey class functionality
     */
    private static void testMonkey() {
        System.out.println("\nTesting Monkey class...");
        
        // Test species validation
        System.out.println("Testing monkey species validation...");
        assert Monkey.isValidSpecies("Capuchin") : "Capuchin should be valid";
        assert Monkey.isValidSpecies("Guenon") : "Guenon should be valid";
        assert Monkey.isValidSpecies("Macaque") : "Macaque should be valid";
        assert Monkey.isValidSpecies("Marmoset") : "Marmoset should be valid";
        assert Monkey.isValidSpecies("Squirrel monkey") : "Squirrel monkey should be valid";
        assert Monkey.isValidSpecies("Tamarin") : "Tamarin should be valid";
        assert !Monkey.isValidSpecies("Gorilla") : "Gorilla should be invalid";
        assert !Monkey.isValidSpecies("Chimpanzee") : "Chimpanzee should be invalid";
        
        // Create a Monkey object
        Monkey monkey = new Monkey("George", "Capuchin", "male", "5", "15.2", 
                                  "20.5", "30.0", "25.0", "03-10-2021", 
                                  "Brazil", "Phase II", false, "United States");
        
        // Test inherited methods
        assert monkey.getName().equals("George") : "getName() failed";
        assert monkey.getAnimalType().equals("monkey") : "getAnimalType() failed";
        assert monkey.getGender().equals("male") : "getGender() failed";
        assert monkey.getAge().equals("5") : "getAge() failed";
        assert monkey.getWeight().equals("15.2") : "getWeight() failed";
        assert monkey.getAcquisitionDate().equals("03-10-2021") : "getAcquisitionDate() failed";
        assert monkey.getAcquisitionCountry().equals("Brazil") : "getAcquisitionCountry() failed";
        assert monkey.getTrainingStatus().equals("Phase II") : "getTrainingStatus() failed";
        assert monkey.getReserved() == false : "getReserved() failed";
        assert monkey.getInServiceCountry().equals("United States") : "getInServiceCountry() failed";
        
        // Test Monkey-specific methods
        assert monkey.getSpecies().equals("Capuchin") : "getSpecies() failed";
        assert monkey.getTailLength().equals("20.5") : "getTailLength() failed";
        assert monkey.getHeight().equals("30.0") : "getHeight() failed";
        assert monkey.getBodyLength().equals("25.0") : "getBodyLength() failed";
        
        // Test setter methods
        monkey.setSpecies("Tamarin");
        assert monkey.getSpecies().equals("Tamarin") : "setSpecies() failed";
        
        monkey.setTailLength("22.0");
        assert monkey.getTailLength().equals("22.0") : "setTailLength() failed";
        
        monkey.setHeight("32.0");
        assert monkey.getHeight().equals("32.0") : "setHeight() failed";
        
        monkey.setBodyLength("27.0");
        assert monkey.getBodyLength().equals("27.0") : "setBodyLength() failed";
        
        System.out.println("Monkey tests passed!");
    }
    
    /**
     * Test method name consistency across classes
     */
    private static void testMethodNameConsistency() {
        System.out.println("\nTesting method name consistency...");
        
        // Create objects
        RescueAnimal animal = new RescueAnimal();
        Dog dog = new Dog("Test", "Test", "male", "1", "10", "01-01-2023", "US", "intake", false, "US");
        Monkey monkey = new Monkey("Test", "Capuchin", "male", "1", "10", "10", "10", "10", "01-01-2023", "US", "intake", false, "US");
        
        // Test acquisition country methods
        animal.setAcquisitionCountry("Test Country");
        dog.setAcquisitionCountry("Test Country");
        monkey.setAcquisitionCountry("Test Country");
        
        assert animal.getAcquisitionCountry().equals("Test Country") : "getAcquisitionCountry() in RescueAnimal failed";
        assert dog.getAcquisitionCountry().equals("Test Country") : "getAcquisitionCountry() in Dog failed";
        assert monkey.getAcquisitionCountry().equals("Test Country") : "getAcquisitionCountry() in Monkey failed";
        
        // Test in-service country methods
        animal.setInServiceCountry("Test Service");
        dog.setInServiceCountry("Test Service");
        monkey.setInServiceCountry("Test Service");
        
        assert animal.getInServiceCountry().equals("Test Service") : "getInServiceCountry() in RescueAnimal failed";
        assert dog.getInServiceCountry().equals("Test Service") : "getInServiceCountry() in Dog failed";
        assert monkey.getInServiceCountry().equals("Test Service") : "getInServiceCountry() in Monkey failed";
        
        System.out.println("Method name consistency tests passed!");
    }
}
