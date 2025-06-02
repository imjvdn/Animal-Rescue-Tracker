package main.java.com.graziosalvare.animalrescue;

/**
 * Dog class represents rescue dogs in the system.
 * It extends the RescueAnimal base class and adds dog-specific attributes.
 */
public class Dog extends RescueAnimal {

    // Instance variable
    private String breed;

    /**
     * Constructor for creating a new Dog instance with all attributes
     * 
     * @param name              The name of the dog
     * @param breed             The breed of the dog
     * @param gender            The gender of the dog
     * @param age               The age of the dog
     * @param weight            The weight of the dog
     * @param acquisitionDate   The date the dog was acquired
     * @param acquisitionCountry The country where the dog was acquired
     * @param trainingStatus    The current training status of the dog
     * @param reserved          Whether the dog is reserved for service
     * @param inServiceCountry  The country where the dog is in service
     */
    public Dog(String name, String breed, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
    String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setBreed(breed);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionCountry(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setAnimalType("dog"); // This line ensures animalType is set.
    }

    /**
     * Gets the breed of the dog
     * 
     * @return The dog's breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Sets the breed of the dog
     * 
     * @param dogBreed The dog's breed
     */
    public void setBreed(String dogBreed) {
        breed = dogBreed;
    }
}
