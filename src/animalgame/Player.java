package animalgame;

import animalgame.Food.CattleFood;
import animalgame.Food.Grass;
import animalgame.Food.Hay;
import animalgame.animals.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Player Class where we have all the methods that a player needs.
 * @author Dino Vejzovic, Carl Lander, Perin Koriea
 */

public class Player implements Serializable {
    private String name;
    private int money = 1000;
    public ArrayList<Animal> animalsList;
    private MateAnimals mateAnimals;

    //Food
    private CattleFood cattleFood;
    private Grass grass;
    private Hay hay;


    public Player(String name) {
        this.name = name;
        this.animalsList = new ArrayList<>();
        this.mateAnimals = new MateAnimals();

        this.cattleFood = new CattleFood();
        this.hay = new Hay();
        this.grass = new Grass();
    }

    /**
     * Method for getting the players money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Method for setting the players money
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Method for getting the players name
     */
    public String getName() {
        return name;
    }

    /**
     * Method for adding animals to the players animals list.
     */
    public void addAnimalToList(Animal animal) {
        animalsList.add(animal);
    }

    /**
     * Method for removing animals from the players animals list.
     */
    public void removeAnimalFromList(Animal animal) {
        animalsList.remove(animal);
    }
    /**
     * Method for getting the animals from the players animals list.
     */
    public void getAnimals() {
        for (Animal animal : animalsList) {
            System.out.println("Typ: " + animal.getAnimalType() + " | " + " Kön: " + animal.getGender() +
                    " | " + " Namn: " + animal.getName() + " | " + "Liv: " + animal.getHealth() + "%" + " | " + "Förlorat liv: " + animal.getHealthDecrease());
        }
    }

    /**
     * Method that is used when buying food.
     */
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

    /**
     * Method that is used to feed the animals.
     */
    public void feedAnimals() {
        Scanner console = new Scanner(System.in);

        if (animalsList.isEmpty()) {
            System.out.println(this.name + " du har inte några djur att mata... ");
            System.out.print("Tryck enter för att låta nästa spelare spela: ");
            console.nextLine();
        } else {
            System.out.println("Välj vilket djur du vill mata, se alternativen nedan.");
            printAnimals();
            System.out.print("Mata in en siffra för att gör ett val: ");
            int feedAnimalChoice = Integer.parseInt(console.nextLine());
            System.out.println("-".repeat(50));
            feedSpecAnimal(animalsList.get(feedAnimalChoice));
        }
    }

    /**
     * A different method that is used for getting/printing the animals that
     * the player owns.
     */
    public void printAnimals() {
        int j = 0;
        for (Animal animal : animalsList) {
            System.out.println(j + ": " + "Typ: " + animal.getAnimalType() + " | " + "Kön: " + animal.getGender() + " | " + "Namn: " + animal.getName() + " | " +
                    "Liv: " + animal.getHealth() + "%");
            j++;
        }
    }

    /**
     * Method for feeding a specific animal that the player owns.
     */
    public void feedSpecAnimal(Animal animal) {
        Scanner console = new Scanner(System.in);

        int amountOfFood;
        int foodChoice;
        switch (animal.getAnimalType()) {
            case "Ko":
                if (grass.kilos == 0) {
                    System.out.println("Du har inte någon mat för kon");
                } else {
                    Cow cow = (Cow) animal;
                    System.out.println("Välj vad kon ska äta, se alternativen nedan.");
                    System.out.println("1.Gräs");
                    System.out.print("Mata in en siffra för att gör ett val: ");
                    foodChoice = Integer.parseInt(console.nextLine());
                    System.out.println("-".repeat(50));
                    switch (foodChoice) {
                        case 1:
                            System.out.println("Hur många kilo gräs vill du mata kon med?");
                            System.out.println("Du har: " + getGrass() + "kg" + " gräs");
                            System.out.print("Ange antal kilo gräs: ");
                            amountOfFood = Integer.parseInt(console.nextLine());
                            if (amountOfFood > grass.kilos){
                                do {
                                    System.out.println("Du har för lite mat, försök igen");
                                    System.out.print("Ange antal kilo gräs: ");
                                    amountOfFood = Integer.parseInt(console.nextLine());
                                    if (amountOfFood == grass.kilos){
                                        cow.eat("Grass", amountOfFood);
                                        grass.removeKilos(amountOfFood);
                                        break;
                                    }
                                } while (amountOfFood != grass.kilos);

                            } else {
                                cow.eat("Grass", amountOfFood);
                                grass.removeKilos(amountOfFood);
                            }
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
                    foodChoice = Integer.parseInt(console.nextLine());
                    switch (foodChoice) {
                        case 1:
                            System.out.println("Hur många kilo hö vill du mata hästen med?");
                            System.out.println("Du har: " + getHay() + "kg" + " hö");
                            System.out.print("Ange antal kilo hö: ");
                            amountOfFood = Integer.parseInt(console.nextLine());
                            if (amountOfFood > hay.kilos){
                                do {
                                    System.out.println("Du har för lite mat, försök igen");
                                    System.out.print("Ange antal kilo hö: ");
                                    amountOfFood = Integer.parseInt(console.nextLine());
                                    if (amountOfFood == hay.kilos){
                                        horse.eat("Hay", amountOfFood);
                                        hay.removeKilos(amountOfFood);
                                        break;
                                    }
                                } while (amountOfFood != hay.kilos);

                            } else {
                                horse.eat("Hay", amountOfFood);
                                hay.removeKilos(amountOfFood);
                            }
                            break;
                        case 2:
                            System.out.println("Hur många kilo gräs vill du mata hästen med?");
                            System.out.println("Du har: " + getGrass() + "kg" + " gräs");
                            System.out.print("Ange antal kilo gräs: ");
                            amountOfFood = Integer.parseInt(console.nextLine());
                            if (amountOfFood > grass.kilos){
                                do {
                                    System.out.println("Du har för lite mat, försök igen");
                                    System.out.print("Ange antal kilo gräs: ");
                                    amountOfFood = Integer.parseInt(console.nextLine());
                                    if (amountOfFood == grass.kilos){
                                        horse.eat("Grass", amountOfFood);
                                        grass.removeKilos(amountOfFood);
                                        break;
                                    }
                                } while (amountOfFood != grass.kilos);

                            } else {
                                horse.eat("Grass", amountOfFood);
                                grass.removeKilos(amountOfFood);
                            }
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
                    foodChoice = Integer.parseInt(console.nextLine());
                    switch (foodChoice) {
                        case 1:
                            System.out.println("Hur många kilo foder vill du mata grisen med?");
                            System.out.println("Du har: " + getCattleFood() + "kg" + " foder");
                            System.out.print("Ange antal kilo foder: ");
                            amountOfFood = Integer.parseInt(console.nextLine());
                            if (amountOfFood > cattleFood.kilos){
                                do {
                                    System.out.println("Du har för lite mat, försök igen");
                                    System.out.print("Ange antal kilo foder: ");
                                    amountOfFood = Integer.parseInt(console.nextLine());
                                    if (amountOfFood == cattleFood.kilos){
                                        pig.eat("CattleFood", amountOfFood);
                                        cattleFood.removeKilos(amountOfFood);
                                        break;
                                    }
                                } while (amountOfFood != cattleFood.kilos);

                            } else {
                                pig.eat("CattleFood", amountOfFood);
                                cattleFood.removeKilos(amountOfFood);
                            }
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
                    foodChoice = Integer.parseInt(console.nextLine());
                    switch (foodChoice) {
                        case 1:
                            System.out.println("Hur många kilo gräs vill du mata geten med?");
                            System.out.println("Du har: " + getGrass() + "kg" + " gräs");
                            System.out.print("Ange antal kilo gräs: ");
                            amountOfFood = Integer.parseInt(console.nextLine());
                            if (amountOfFood > grass.kilos){
                                do {
                                    System.out.println("Du har för lite mat, försök igen");
                                    System.out.print("Ange antal kilo gräs: ");
                                    amountOfFood = Integer.parseInt(console.nextLine());
                                    if (amountOfFood == grass.kilos){
                                        goat.eat("Grass", amountOfFood);
                                        grass.removeKilos(amountOfFood);
                                        break;
                                    }
                                } while (amountOfFood != grass.kilos);

                            } else {
                                goat.eat("Grass", amountOfFood);
                                grass.removeKilos(amountOfFood);
                            }
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
                    foodChoice = Integer.parseInt(console.nextLine());
                    switch (foodChoice) {
                        case 1:
                            System.out.println("Hur många kilo foder vill du mata kycklingen med?");
                            System.out.println("Du har: " + getCattleFood() + "kg" + " foder");
                            System.out.print("Ange antal kilo foder: ");
                            amountOfFood = Integer.parseInt(console.nextLine());
                            if (amountOfFood > cattleFood.kilos){
                                do {
                                    System.out.println("Du har för lite mat, försök igen");
                                    System.out.print("Ange antal kilo foder: ");
                                    amountOfFood = Integer.parseInt(console.nextLine());
                                    if (amountOfFood == cattleFood.kilos){
                                        chicken.eat("CattleFood", amountOfFood);
                                        cattleFood.removeKilos(amountOfFood);
                                        break;
                                    }
                                } while (amountOfFood != cattleFood.kilos);

                            } else {
                                chicken.eat("CattleFood", amountOfFood);
                                cattleFood.removeKilos(amountOfFood);
                            }
                            break;
                    }
                }
                break;
        }
    }

    /**
     * Method that shows the healthDecrease of the animals after each round.
     */
    public void animalHealthDecrease() {
        for (Animal animal : animalsList) {
            animal.healthDecrease();
        }
    }

    /**
     * Another method that is used when the player mates animals.
     */
    public void mateTheAnimals() {
        Scanner console = new Scanner(System.in);
        if (animalsList.isEmpty()) {
            System.out.println(name + " du har inte några djur att para...");
            System.out.print("Tryck enter för att låta nästa spelare spela: ");
            console.nextLine();
        } else {
            System.out.println("Välj vilken typ av djur du vill para?");
            System.out.println("Tillgängliga djur:");
            printAnimals();
            System.out.println("-".repeat(50));
            System.out.println("1.Ko, 2.Häst, 3.Gris, 4.Get, 5.Kyckling");
            System.out.print("Mata in en siffra för att göra ett val: ");
            int animalToMate = Integer.parseInt(console.nextLine());
            switch (animalToMate) {
                case 1:
                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Ko")) {
                            System.out.println(i + ": " + animalsList.get(i).getAnimalType() + " Kön: " + animalsList.get(i).getGender());
                        }
                    }
                    System.out.println("Välj en ko av könet Hane");
                    System.out.print("Mata in en siffra för att göra ett val: ");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Ko")) {
                            if (animalsList.get(i).getGender().equalsIgnoreCase("Hane")) {
                            }
                        }
                    }
                    int maleCow = Integer.parseInt(console.nextLine());
                    System.out.println("Välj en ko av könet Hona ");
                    System.out.print("Mata in en siffra för att göra ett val: ");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Ko")) {
                            if (animalsList.get(i).getGender().equalsIgnoreCase("Hona")) {
                            }
                        }
                    }
                    int femaleCow = Integer.parseInt(console.nextLine());
                    mateAnimals.CreateNewAnimals(this, animalsList.get(maleCow), animalsList.get(femaleCow));
                    break;

                case 2:
                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Häst")) {
                            System.out.println(i + ": " + animalsList.get(i).getAnimalType() + " Kön: " + animalsList.get(i).getGender());

                        }
                    }
                    System.out.println("Välj en häst av könet Hane");
                    System.out.print("Mata in en siffra för att göra ett val: ");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Häst")) {
                            if (animalsList.get(i).getGender().equalsIgnoreCase("Hane")) {
                            }
                        }
                    }
                    int maleHorse = Integer.parseInt(console.nextLine());
                    System.out.println("Välj en häst av könet Hona ");
                    System.out.print("Mata in en siffra för att göra ett val: ");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Häst")) {
                            if (animalsList.get(i).getGender().equalsIgnoreCase("Hona")) {
                                System.out.println(i + ": " + animalsList.get(i).getName() + "Kön: " + animalsList.get(i).getGender());
                            }
                        }
                    }
                    int femaleHorse = Integer.parseInt(console.nextLine());
                    mateAnimals.CreateNewAnimals(this, animalsList.get(maleHorse), animalsList.get(femaleHorse));
                    break;

                case 3:
                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Gris")) {
                            System.out.println(i + ": " + animalsList.get(i).getAnimalType() + "Kön: " + animalsList.get(i).getGender());
                        }
                    }
                    System.out.println("Välj en gris av könet Hane");
                    System.out.print("Mata in en siffra för att göra ett val: ");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Gris")) {
                            if (animalsList.get(i).getGender().equalsIgnoreCase("Hane")) {
                            }
                        }
                    }
                    int malePig = Integer.parseInt(console.nextLine());
                    System.out.println("Välj en gris av könet Hona ");
                    System.out.print("Mata in en siffra för att göra ett val: ");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Gris")) {
                            if (animalsList.get(i).getGender().equalsIgnoreCase("Hona")) {
                            }
                        }
                    }
                    int femalePig = Integer.parseInt(console.nextLine());
                    mateAnimals.CreateNewAnimals(this, animalsList.get(malePig), animalsList.get(femalePig));
                    break;
                case 4:
                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Get")) {
                            System.out.println(i + ": " + animalsList.get(i).getAnimalType() + "Kön: " + animalsList.get(i).getGender());
                        }
                    }
                    System.out.println("Välj en get av könet Hane");
                    System.out.print("Mata in en siffra för att göra ett val: ");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Get")) {
                            if (animalsList.get(i).getGender().equalsIgnoreCase("Hane")) {
                            }
                        }
                    }
                    int maleGoat = Integer.parseInt(console.nextLine());
                    System.out.println("Välj en get av könet Hona ");
                    System.out.print("Mata in en siffra för att göra ett val: ");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Get")) {
                            if (animalsList.get(i).getGender().equalsIgnoreCase("Hona")) {
                            }
                        }
                    }
                    int femaleGoat = Integer.parseInt(console.nextLine());
                    mateAnimals.CreateNewAnimals(this, animalsList.get(maleGoat), animalsList.get(femaleGoat));
                    break;

                case 5:
                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Kyckling")) {
                        }
                    }
                    System.out.println("Välj en kyckling av könet Hane");
                    System.out.print("Mata in en siffra för att göra ett val: ");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Kyckling")) {
                            if (animalsList.get(i).getGender().equalsIgnoreCase("Hane")) {
                            }
                        }
                    }
                    int maleChicken = Integer.parseInt(console.nextLine());
                    System.out.println("Välj en kyckling av könet Hona ");
                    System.out.print("Mata in en siffra för att göra ett val: ");

                    for (int i = 0; i < animalsList.size(); i++) {
                        if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Kyckling")) {
                            if (animalsList.get(i).getGender().equalsIgnoreCase("Hona")) {
                            }
                        }
                    }
                    int femaleChicken = Integer.parseInt(console.nextLine());
                    mateAnimals.CreateNewAnimals(this, animalsList.get(maleChicken), animalsList.get(femaleChicken));
                    break;
            }
        }
    }

    /**
     * Method for getting the food type "CattleFood"
     */
    public int getCattleFood() {
        return cattleFood.getKilos();
    }

    /**
     * Method for getting the food type "Hay"
     */
    public int getHay() {
        return hay.getKilos();
    }

    /**
     * Method for getting the food type "Grass"
     */
    public int getGrass() {
        return grass.getKilos();
    }
}


