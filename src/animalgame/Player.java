package animalgame;

import animalgame.Food.CattleFood;
import animalgame.Food.Grass;
import animalgame.Food.Hay;
import animalgame.animals.*;


import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private int money = 1000;
    public ArrayList<Animal> animalsList;

    //Food
    private CattleFood cattleFood;
    private Grass grass;
    private Hay hay;


    private Scanner console;


    public Player(String name) {
        this.name = name;
        this.animalsList = new ArrayList<>();
        this.console = new Scanner(System.in);

        this.cattleFood = new CattleFood();
        this.hay = new Hay();
        this.grass = new Grass();
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void addAnimalToList(Animal animal) {
        animalsList.add(animal);
    }

    public void removeAnimalFromList(Animal animal) {
        animalsList.remove(animal);
    }

    public void getAnimals() {
        for (Animal animal : animalsList) {
            System.out.println("Typ: " + animal.getAnimalType() + " | " + " Kön: " + animal.getGender() +
                    " | " + " Namn: " + animal.getName() + " | " + "Liv: " + animal.getHealth() + "%" + " | " + "Förlorat liv: " + animal.getHealthDecrease());
        }
    }

    public void buyFood(String foodType, int kilos) {
        switch (foodType) {
            case "hö":
                hay.addKilos(kilos);
                break;
            case "gräs":
                grass.addKilos(kilos);
                break;
            case "foder":
                cattleFood.addKilos(kilos);
                break;
        }
    }

    public void feedAnimals() {
        if (animalsList.isEmpty()) {
            System.out.println(this.name + " du har inte några djur att mata... ");
        } else {
            printAnimals();
            int feedAnimalChoice = console.nextInt();
            System.out.println("-".repeat(50));
            feedSpecAnimal(animalsList.get(feedAnimalChoice));
        }
    }

    public void printAnimals() {
        int j = 0;
        for (Animal animal : animalsList) {
            System.out.println(j + ": " + "Typ: " + animal.getAnimalType() + " | " + "Kön: " + animal.getGender() + " | " + "Namn: " + animal.getName() + " | " +
                    "Liv: " + animal.getHealth() + "%");
            j++;
        }
    }

    public void feedSpecAnimal(Animal animal) {
        int amountOfFood;
        int foodChoice;
        switch (animal.getAnimalType()) {
            case "Ko":
                if (grass.kilos == 0) {
                    System.out.println("Du har inte någon mat för kon ");
                } else {
                    Cow cow = (Cow) animal; //Downcast kon
                    System.out.println("Välj vad kon ska äta, se alternativen nedan.");
                    System.out.println("1.Gräs");
                    System.out.print("Mata in en siffra för att gör ett val: ");
                    foodChoice = console.nextInt();
                    System.out.println("-".repeat(50));
                    switch (foodChoice) {
                        case 1:
                            System.out.println("Hur många kilo gräs vill du mata kon med?");
                            System.out.println("Du har: " + getGrass() + "kg" + " gräs");
                            System.out.print("Ange antal kilo gräs: ");
                            amountOfFood = console.nextInt();
                            cow.eat("Grass", amountOfFood);
                            grass.removeKilos(amountOfFood); //reducing players food storage!!
                            break;
                    }
                }
                break;

            case "Häst":
                if (grass.kilos == 0 || hay.kilos == 0) {
                    System.out.println("Du har inte någon mat för hästen");
                } else {
                    Horse horse = (Horse) animal;
                    System.out.println("Välj vad hästen ska äta, se alternativen nedan.");
                    System.out.println("1.Hö, 2.Gräs");
                    System.out.print("Mata in en siffra för att gör ett val: ");
                    foodChoice = console.nextInt();
                    switch (foodChoice) {
                        case 1:
                            System.out.println("Hur många kilo hö vill du mata hästen med?");
                            System.out.println("Du har: " + getHay() + "kg" + " hö");

                            System.out.print("Ange antal kilo hö: ");
                            amountOfFood = console.nextInt();
                            horse.eat("Hay", amountOfFood);
                            hay.removeKilos(amountOfFood);
                            break;
                        case 2:
                            System.out.println("Hur många kilo gräs vill du mata hästen med?");
                            System.out.println("Du har: " + getGrass() + "kg" + " gräs");
                            System.out.print("Ange antal kilo gräs: ");
                            amountOfFood = console.nextInt();
                            horse.eat("Grass", amountOfFood);
                            grass.removeKilos(amountOfFood);
                            break;
                    }
                }
                break;

            case "Gris":
                if (cattleFood.kilos == 0) {
                    System.out.println("Du har inte någon mat för grisen");
                } else {
                    Pig pig = (Pig) animal;
                    System.out.println("Välj vad grisen ska äta, se alternativen nedan.");
                    System.out.println("1.Foder");
                    System.out.print("Mata in en siffra för att gör ett val: ");
                    foodChoice = console.nextInt();
                    switch (foodChoice) {
                        case 1:
                            System.out.println("Hur många kilo foder vill du mata grisen med?");
                            System.out.println("Du har: " + getCattleFood() + "kg" + " foder");
                            System.out.print("Ange antal kilo foder: ");
                            amountOfFood = console.nextInt();
                            pig.eat("CattleFood", amountOfFood);
                            cattleFood.removeKilos(amountOfFood);
                            break;
                    }
                }
                break;

            case "Get":
                if (grass.kilos == 0) {
                    System.out.println("Du har inte någon mat för geten");
                } else {
                    Goat goat = (Goat) animal;
                    System.out.println("Välj vad geten ska äta, se alternativen nedan.");
                    System.out.println("1.Gräs");
                    System.out.print("Mata in en siffra för att gör ett val: ");
                    foodChoice = console.nextInt();
                    switch (foodChoice) {
                        case 1:
                            System.out.println("Hur många kilo gräs vill du mata geten med?");
                            System.out.println("Du har: " + getGrass() + "kg" + " gräs");
                            System.out.print("Ange antal kilo gräs: ");
                            amountOfFood = console.nextInt();
                            goat.eat("Grass", amountOfFood);
                            grass.removeKilos(amountOfFood);
                            break;
                    }
                }
                break;

            case "Kyckling":
                if (cattleFood.kilos == 0) {
                    System.out.println("Du har inte någon mat för kycklingen");

                } else {
                    Chicken chicken = (Chicken) animal;
                    System.out.println("Välj vad kycklingen ska äta, se alternativen nedan.");
                    System.out.println("1.foder");
                    System.out.print("Mata in en siffra för att gör ett val: ");
                    foodChoice = console.nextInt();
                    switch (foodChoice) {
                        case 1:
                            System.out.println("Hur många kilo foder vill du mata kycklingen med?");
                            System.out.println("Du har: " + getCattleFood() + "kg" + " foder");
                            System.out.print("Ange antal kilo foder: ");
                            amountOfFood = console.nextInt();
                            chicken.eat("CattleFood", amountOfFood);
                            cattleFood.removeKilos(amountOfFood);
                            break;
                    }
                }
                break;
        }
    }

    public void animalHealthDecrease() {
        for (Animal animal : animalsList) {
            animal.healthDecrease();
        }
    }

    public int getCattleFood() {
        return cattleFood.getKilos();
    }

    public int getHay() {
        return hay.getKilos();
    }

    public int getGrass() {
        return grass.getKilos();
    }
}


