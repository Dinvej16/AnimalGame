package animalgame.animals;

import animalgame.Player;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Goat extends Animal implements Serializable {

    private String name;
    private String gender;
    private String animalType = "Get";
    private int health = 100;
    int healthDecrease;
    private Goat newGoat;

    private Player player;

    public Goat(String name){
        this.name = name;


    }

    public Goat() {

    }

    @Override
    public void eat(String foodChoice, int kilo) {
        if (health == 100){
            System.out.println("Jag är inte hungrig just nu!");
            return;
        }

        switch (foodChoice) {
            case "Grass":
                System.out.println("Mmmm va gott med Gräs, Tack!");
                health += 10;
                break;
        }
    }

    @Override
    public void mate() {
        Scanner console = new Scanner(System.in);
        Random random = new Random();
        int mateOption = random.nextInt(2) + 1;
        switch (mateOption){
            case 1:
                System.out.println("Parningen misslyckades... bättre lycka nästa gång!");
                break;
            case 2:
                System.out.print("Namn ge din get: ");
                String newBornName = console.next();
                this.newGoat = new Goat(newBornName);
                this.player.addAnimalToList(newGoat);
                break;
        }
    }

    @Override
    public void health() {
        System.out.println( animalType + "" + name + " Hälsa: " + health + " Förlorat liv: " + getHealthDecrease());
    }

    @Override
    public void deadAnimal() {
        System.out.println("Din get är död, Tyvärr...");
    }

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

    @Override
    public String getHealthDecrease() {
        return "-" + this.healthDecrease;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAnimalType() {
        return animalType;
    }

    @Override
    public void setType(String type) {

    }
}
