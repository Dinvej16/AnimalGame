package animalgame.animals;

import animalgame.Player;

import java.util.Random;
import java.util.Scanner;

public class Cow extends Animal {

    public String getHealth;
    private String name;
    private String gender;
    private String animalType = "Ko";
    private int health = 100;
    int healthDecrease;
    private Cow newCow;
    private Scanner console;

    private Player player;

    public Cow(String name) {
        this.name = name;
        this.console = new Scanner(System.in);

    }

    @Override
    public void eat() {
        if (this.health == 100) {
            System.out.println("Jag är inte hungrig just nu!");

        } else {
            System.out.println("Mmmm va gott med föda, Tack!");
            this.health += 10;
        }
    }

    @Override
    public void mate() {
        Random random = new Random();
        int mateOption = random.nextInt(2) + 1;
        switch (mateOption) {
            case 1:
                System.out.println("Parningen misslyckades... bättre lycka nästa gång!");
                break;
            case 2:
                System.out.print("Namn ge din ko: ");
                String newBornName = console.next();
                this.newCow = new Cow(newBornName);
                this.player.addAnimalToList(newCow);
                break;
        }
    }

    @Override
    public void health() {
    }

    @Override
    public void deadAnimal() {
        System.out.println("Din ko är död, Tyvärr...");
    }

    @Override
    public void healthDecrease() {
        Random random = new Random();
        int decreaseOptions = random.nextInt(3) + 1;
        switch (decreaseOptions) {
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
