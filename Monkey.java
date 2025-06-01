/**
 * Monkey class that inherits from RescueAnimal
 * This class represents monkeys used for search and rescue operations
 * by Grazioso Salvare.
 * 
 * @author Jadan Morrow
 * @version 1.0
 */
public class Monkey extends RescueAnimal {
    
    // Instance variables specific to Monkey class
    private String species;
    private String tailLength;
    private String height;
    private String bodyLength;
    
    // Valid monkey species array for validation
    private static final String[] VALID_SPECIES = {
        "Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin"
    };
    
    /**
     * Default constructor
     */
    public Monkey() {
        // Call the parent constructor
        super();
        
        // Initialize monkey-specific attributes
        this.species = "";
        this.tailLength = "";
        this.height = "";
        this.bodyLength = "";
        
        // Set animal type to "monkey"
        setAnimalType("monkey");
    }
    
    /**
     * Parameterized constructor
     * 
     * @param name The name of the monkey
     * @param species The species of the monkey
     * @param gender The gender of the monkey
     * @param age The age of the monkey
     * @param weight The weight of the monkey
     * @param tailLength The tail length of the monkey
     * @param height The height of the monkey
     * @param bodyLength The body length of the monkey
     * @param acquisitionDate The date the monkey was acquired
     * @param acquisitionCountry The country where the monkey was acquired
     * @param trainingStatus The training status of the monkey
     * @param reserved Whether the monkey is reserved
     * @param inServiceCountry The country where the monkey is in service
     */
    public Monkey(String name, String species, String gender, String age, String weight,
                 String tailLength, String height, String bodyLength, String acquisitionDate,
                 String acquisitionCountry, String trainingStatus, boolean reserved,
                 String inServiceCountry) {
        
        // Set RescueAnimal attributes using parent class setters
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        
        // Set monkey-specific attributes
        this.tailLength = tailLength;
        this.height = height;
        this.bodyLength = bodyLength;
        
        // Set animal type to "monkey"
        setAnimalType("monkey");
    }
    
    /**
     * Validates if the species is one of the eligible monkey species
     * 
     * @param species The species to validate
     * @return true if the species is valid, false otherwise
     */
    public static boolean isValidSpecies(String species) {
        for (String validSpecies : VALID_SPECIES) {
            if (validSpecies.equalsIgnoreCase(species)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Get the list of valid monkey species
     * 
     * @return Array of valid monkey species
     */
    public static String[] getValidSpecies() {
        return VALID_SPECIES;
    }
    
    // Accessor methods
    
    /**
     * Get the species of the monkey
     * 
     * @return The species
     */
    public String getSpecies() {
        return species;
    }
    
    /**
     * Get the tail length of the monkey
     * 
     * @return The tail length
     */
    public String getTailLength() {
        return tailLength;
    }
    
    /**
     * Get the height of the monkey
     * 
     * @return The height
     */
    public String getHeight() {
        return height;
    }
    
    /**
     * Get the body length of the monkey
     * 
     * @return The body length
     */
    public String getBodyLength() {
        return bodyLength;
    }
    
    // Mutator methods
    
    /**
     * Set the species of the monkey
     * Validates that the species is one of the eligible monkey species
     * 
     * @param species The species to set
     */
    public void setSpecies(String species) {
        // Validate species before setting
        if (isValidSpecies(species)) {
            this.species = species;
        } else {
            // For invalid species, we could throw an exception or handle differently
            // For now, we'll just set it to empty string
            this.species = "";
            System.out.println("Warning: Invalid monkey species provided.");
        }
    }
    
    /**
     * Set the tail length of the monkey
     * 
     * @param tailLength The tail length to set
     */
    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }
    
    /**
     * Set the height of the monkey
     * 
     * @param height The height to set
     */
    public void setHeight(String height) {
        this.height = height;
    }
    
    /**
     * Set the body length of the monkey
     * 
     * @param bodyLength The body length to set
     */
    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }
}
