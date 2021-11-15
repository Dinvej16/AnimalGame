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

    private Player player;
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
    public void removeAnimalFromList(Animal animal){
        animalsList.remove(animal);
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
            int feedAnimalChoice = console.nextInt();
            System.out.println("-".repeat(50));
            switch (feedAnimalChoice) {
                //Ko
                case 1:
                    System.out.println("Välj vilken ko du vill mata?");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Ko")) {
                            System.out.println(i  + ":" + " " + animalsList.get(i).getName());
                        }
                    }
                    System.out.print("Mata in en siffra för att välja en ko: ");
                    int cowChoice = console.nextInt();
                    Cow cowToFeed = (Cow) animalsList.get(cowChoice);
                    System.out.println("-".repeat(50));

                    System.out.println("Välj vad kon ska äta, se alternativen nedan.");
                    System.out.println("1.Gräs");
                    System.out.print("Mata in en siffra för att gör ett val: ");
                    int foodChoice = console.nextInt();
                    switch (foodChoice) {
                        case 1:
                            grass.removeKilos(1);
                            cowToFeed.eat(); // Den äter bara grös, annars skicka i eat-metoden ett argument
                            // för vad den ska eat("GRASS")
                            break;
                    }
                    break;

                //Häst
                case 2:
                    System.out.println("Välj vilken häst du vill mata?");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Häst")) {
                            System.out.println(i + ":" + " " + animalsList.get(i).getName());
                        }
                    }
                    System.out.print("Mata in en siffra för att välja en häst: ");
                    int horseChoice = console.nextInt();
                    Horse horseToFeed = (Horse) animalsList.get(horseChoice);
                    System.out.println("-".repeat(50));

                    System.out.println("Välj vad hästen ska äta, se alternativen nedan.");
                    System.out.println("1.Gräs, 2.Hö");
                    System.out.print("Mata in en siffra för att gör ett val: ");
                    int foodChoice2 = console.nextInt();
                    switch (foodChoice2) {
                        case 1:
                            grass.removeKilos(1);
                            horseToFeed.eat();
                            break;
                        case 2:
                            hay.removeKilos(1);
                            horseToFeed.eat();
                            break;
                    }
                    break;

                //Gris
                case 3:
                    System.out.println("Välj vilken gris du vill mata?");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Gris")) {
                            System.out.println(i + ":" + " " + animalsList.get(i).getName());
                        }
                    }
                    System.out.print("Mata in en siffra för att välja en gris: ");
                    int pigChoice = console.nextInt();
                    Pig pigToFeed = (Pig) animalsList.get(pigChoice);
                    System.out.println("-".repeat(50));

                    System.out.println("Välj vad grisen ska äta, se alternativen nedan.");
                    System.out.println("1.Foder");
                    System.out.print("Mata in en siffra för att gör ett val: ");
                    int foodChoice3 = console.nextInt();
                    switch (foodChoice3) {
                        case 1:
                            cattleFood.removeKilos(1);
                            pigToFeed.eat();
                            break;
                    }
                    break;
                //Get
                case 4:
                    System.out.println("Välj vilken get du vill mata?");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Get")) {
                            System.out.println(i + ":" + " " + animalsList.get(i).getName());
                        }
                    }
                    System.out.print("Mata in en siffra för att välja en get: ");
                    int goatChoice = console.nextInt();
                    Goat goatToFeed = (Goat) animalsList.get(goatChoice);
                    System.out.println("-".repeat(50));

                    System.out.println("Välj vad geten ska äta, se alternativen nedan.");
                    System.out.println("1.Gräs");
                    System.out.print("Mata in en siffra för att gör ett val: ");
                    int foodChoice4 = console.nextInt();
                    switch (foodChoice4) {
                        case 1:
                            grass.removeKilos(1);
                            goatToFeed.eat();
                            break;
                    }
                    break;

                //Kyckling
                case 5:
                    System.out.println("Välj vilken kyckling du vill mata?");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Kyckling")) {
                            System.out.println(i + ":" + " " + animalsList.get(i).getName());
                        }
                    }
                    System.out.print("Mata in en siffra för att välja en kyckling: ");
                    int chickenChoice = console.nextInt();
                    Chicken chickenToFeed = (Chicken) animalsList.get(chickenChoice);
                    System.out.println("-".repeat(50));

                    System.out.println("Välj vad kyckling ska äta, se alternativen nedan.");
                    System.out.println("1.Foder");
                    System.out.print("Mata in en siffra för att gör ett val: ");
                    int foodChoice5 = console.nextInt();
                    switch (foodChoice5) {
                        case 1:
                            cattleFood.removeKilos(1);
                            chickenToFeed.eat();
                            break;
                    }
                    break;
            }
        }
    }

    public void animalHealthDecrease() {
        for (Animal animal : animalsList) {
            if (this.animalsList.isEmpty()) {
                break;
            }
            animal.healthDecrease();
        }
    }

}


