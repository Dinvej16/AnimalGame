package animalgame.animals;

import animalgame.Player;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

/**
 * This is one of the classes that extends the Animal class.
 * This one is called Pig. It stores info like the name,
 * gender, animalType, health, and have all the methods
 * that exists in the Animal class.
 *
 * @author Dino Vejzovic, Carl Lander, Perin Koriea
 */

public class Pig extends Animal implements Serializable {

    private String name;
    private String gender;
    private String animalType = "Gris";
    private int health = 100;
    int healthDecrease;
    private Pig newPig;


    private Player player;

    public Pig(String name){
        this.name = name;


    }

    /**
     * Method for eating and increase health.
     */
    @Override
    public void eat(String foodChoice, int kilo) {
        if (health == 100){
            System.out.println("Jag är inte hungrig just nu!");
            return;
        }
        switch (foodChoice) {
            case "CattleFood":
                System.out.println("Mmmm va gott med Foder, Tack!");
                health = health + kilo * 10;
                break;
        }
    }

    /**
     * Method that randomly decreases the health with a
     * value of 10,20, or 30.
     */
    @Override
    public void healthDecrease() {
        Random random = new Random();
        int decreaseOptions = random.nextInt(3) + 1;
        switch(decreaseOptions) {
            case 1: // -10
                this.healthDecrease = 10;
                this.health = this.health - 10;
                break;
            case 2: // -20
                this.healthDecrease = 20;
                this.health = this.health - 20;
                break;
            case 3: // -30
                this.healthDecrease = 30;
                this.health = this.health - 30;
                break;
        }
    }

    /**
     * Method that gets the health decrease.
     *
     */
    @Override
    public String getHealthDecrease() {
        return "-" + this.healthDecrease;
    }

    /**
     * Method that gets the health.
     *
     */
    @Override
    public int getHealth() {
        return this.health;
    }

    /**
     * Method for setting the gender of the animal.
     *
     */
    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Method that gets the gender of the animal.
     */
    @Override
    public String getGender() {
        return this.gender;
    }

    /**
     * Method that gets the name of the animal.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Method that gets the type of the animal.
     */
    @Override
    public String getAnimalType() {
        return animalType;
    }

    /**
     * Method that setting the type of the animal.
     */
    @Override
    public void setType(String type) {

    }
}
