package animalgame.animals;

import animalgame.Player;

import java.util.Random;
import java.util.Scanner;

public class Horse extends Animal {

    private String name;
    private String gender;
    private String animalType = "Häst";
    private int health = 100;
    int healthDecrease;
    private Horse newHorse;
    private Scanner console;

    private Player player;

    public Horse(String name){
        this.name = name;
        this.console = new Scanner(System.in);

    }

    public Horse() {

    }

    @Override
    public void eat(String foodChoice) {
        if (health == 100){
            System.out.println("Jag är inte hungrig just nu!");
            return;
        }

        switch (foodChoice) {
            case "Hay":
                System.out.println("Mmmm va gott med Hö, Tack!");
                health += 10;
                break;
            case "Grass":
                System.out.println("Mmmm va gott med Gräs, Tack!");
                health += 10;
                break;
        }
    }

    @Override
    public void mate() {
        Random random = new Random();
        int mateOption = random.nextInt(2) + 1;
        switch (mateOption){
            case 1:
                System.out.println("Parningen misslyckades... bättre lycka nästa gång!");
                break;
            case 2:
                System.out.print("Namn ge din häst: ");
                String newBornName = console.next();
                this.newHorse = new Horse(newBornName);
                this.player.addAnimalToList(newHorse);
                break;
        }
    }

    @Override
    public void health() {
        System.out.println( animalType + "" + name + " Hälsa: " + health + " Förlorat liv: " + getHealthDecrease());
    }

    @Override
    public void deadAnimal() {
        System.out.println("Din häst är död, Tyvärr...");
    }

    @Override
    public void healthDecrease() {
        Random random = new Random();
        int decreaseOptions = random.nextInt(3) + 1;
        switch(decreaseOptions) {
            case 1:
                this.healthDecrease = 10;
                break;
            case 2:
                this.healthDecrease = 20;
                break;
            case 3:
                this.healthDecrease = 30;
                break;
        }
    }

    @Override
    public String getHealthDecrease() {
        return "-" + this.healthDecrease;
    }

    @Override
    public String getHealth() {
        int realHealth = this.health - healthDecrease;
        return realHealth + "%";
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
}
