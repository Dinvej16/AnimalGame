package animalgame;

import animalgame.animals.*;
import animalgame.food.CattleFood;
import animalgame.food.Food;
import animalgame.food.Grass;
import animalgame.food.Hay;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private int money = 1000;
    private ArrayList<Animal> animalsList;

    //Food
    private CattleFood cattleFood;
    private Hay hay;
    private Grass grass;

    private Menus menusOptions;
    private Scanner console;


    public Player(String name) {
        this.name = name;
        this.animalsList = new ArrayList<>();
        this.menusOptions = new Menus();
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

    public void getAnimals() {
        for (Animal animal : animalsList) {
            System.out.println("Typ: " + animal.getAnimalType() + " | " + " Kön: " + animal.getGender() +
                    " | " + " Namn: " + animal.getName() + " | " + "Liv: " + animal.getHealth() + " | " + "Förlorat liv: " + animal.getHealthDecrease());
        }

    }

    public void buyFood(String foodType, int kilos) {
        switch (foodType) {
            case "hö":
                hay.addKilos(kilos);
                break;
            case "gräs":
                grass.addKilos(kilos);
            case "foder":
                cattleFood.addKilos(kilos);
        }
    }

    public void feedAnimals() {
        if (animalsList.isEmpty()){
            System.out.println(this.name + " du har inte några djur att mata... ");

        }else {
            //Ska bara skriva ut djuren spelaren äger!
            printAnimals();
            int feedAnimalChoice = console.nextInt();
            System.out.println("-".repeat(50));
            feedSpecAnimal(animalsList.get(feedAnimalChoice));
        }
    }
    public void printAnimals(){
        int j = 0;
        for (Animal animal : animalsList){
            System.out.println(j + ": " + animal.getName() + ", " + animal.getGender() + ", " + animal.getAnimalType());
            j++;
        }
    }

    public void feedSpecAnimal(Animal animal){
        int foodChoice;
        switch (animal.getAnimalType()){
            case "Ko":
                Cow cow = (Cow) animal; //Downcast kon,
                System.out.println("Välj vad kon ska äta, se alternativen nedan.");
                System.out.println("1.Gräs");
                System.out.print("Mata in en siffra för att gör ett val: ");
                foodChoice = console.nextInt();
                switch (foodChoice) {
                    case 1:
                        grass.removeKilos(1); //reducing players food storage!!
                        cow.eat("Grass");
                        break;
                }

                break;
            case "Häst":
                Horse horse = (Horse) animal;
                System.out.println("Välj vad hästen ska äta, se alternativen nedan.");
                System.out.println("1.Hö, 2.Gräs");
                System.out.print("Mata in en siffra för att gör ett val: ");
                foodChoice = console.nextInt();
                switch (foodChoice) {
                    case 1:
                        hay.removeKilos(1);
                        horse.eat("Hay");
                        break;
                    case 2:
                        grass.removeKilos(1);
                        horse.eat("Grass");
                        break;
                }

                break;
            case "Gris":
                Pig pig = (Pig) animal;
                System.out.println("Välj vad grisen ska äta, se alternativen nedan.");
                System.out.println("1.Foder");
                System.out.print("Mata in en siffra för att gör ett val: ");
                foodChoice = console.nextInt();
                switch (foodChoice) {
                    case 1:
                        cattleFood.removeKilos(1);
                        pig.eat("CattleFood");
                        break;
                }

                break;
            case "Get":
                Goat goat = (Goat) animal;
                System.out.println("Välj vad geten ska äta, se alternativen nedan.");
                System.out.println("1.Gräs");
                System.out.print("Mata in en siffra för att gör ett val: ");
                foodChoice = console.nextInt();
                switch (foodChoice) {
                    case 1:
                        grass.removeKilos(1);
                        goat.eat("Grass"); // Den äter bara grös, annars skicka i eat-metoden ett argument
                        // för vad den ska eat("GRASS")
                        break;
                }

                break;
            case "Kyckling":
                Chicken chicken = (Chicken) animal;
                System.out.println("Välj vad kycklingen ska äta, se alternativen nedan.");
                System.out.println("1.foder");
                System.out.print("Mata in en siffra för att gör ett val: ");
                foodChoice = console.nextInt();
                switch (foodChoice){
                    case 1:
                        cattleFood.removeKilos(1);
                        chicken.eat("CattleFood");
                        break;
                }
                break;
        }
    }

    public void animalHealthDecrease() {
        for (Animal animal : animalsList){
            animal.healthDecrease();
        }
    }

}


