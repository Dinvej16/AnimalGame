package animalgame;

import animalgame.Food.CattleFood;
import animalgame.Food.Grass;
import animalgame.Food.Hay;
import animalgame.animals.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner console = new Scanner(System.in);

        if (animalsList.isEmpty()) {
            System.out.println(this.name + " du har inte några djur att mata... ");
        } else {
            printAnimals();
            System.out.print("Mata in en siffra för att gör ett val: ");
            int feedAnimalChoice = Integer.parseInt(console.nextLine());
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
                                System.out.println("Du har för lite mat, försök igen");
                                //Låta spelaren försöka igen, fixa i den andra nedan också.
                            }
                            else {
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
                            amountOfFood = console.nextInt();
                            horse.eat("Hay", amountOfFood);
                            hay.removeKilos(amountOfFood);
                            break;
                        case 2:
                            System.out.println("Hur många kilo gräs vill du mata hästen med?");
                            System.out.println("Du har: " + getGrass() + "kg" + " gräs");
                            System.out.print("Ange antal kilo gräs: ");
                            amountOfFood = Integer.parseInt(console.nextLine());
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
                    foodChoice = Integer.parseInt(console.nextLine());
                    switch (foodChoice) {
                        case 1:
                            System.out.println("Hur många kilo foder vill du mata grisen med?");
                            System.out.println("Du har: " + getCattleFood() + "kg" + " foder");
                            System.out.print("Ange antal kilo foder: ");
                            amountOfFood = Integer.parseInt(console.nextLine());
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
                    foodChoice = Integer.parseInt(console.nextLine());
                    switch (foodChoice) {
                        case 1:
                            System.out.println("Hur många kilo gräs vill du mata geten med?");
                            System.out.println("Du har: " + getGrass() + "kg" + " gräs");
                            System.out.print("Ange antal kilo gräs: ");
                            amountOfFood = Integer.parseInt(console.nextLine());
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
                    foodChoice = Integer.parseInt(console.nextLine());
                    switch (foodChoice) {
                        case 1:
                            System.out.println("Hur många kilo foder vill du mata kycklingen med?");
                            System.out.println("Du har: " + getCattleFood() + "kg" + " foder");
                            System.out.print("Ange antal kilo foder: ");
                            amountOfFood = Integer.parseInt(console.nextLine());
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

    public void mateTheAnimals(){
        Scanner console = new Scanner(System.in);
        System.out.println("Välj vilken typ av djur du vill skapa");
        System.out.println("1.Ko, 2.Häst, 3.Gris, 4.Get, 5.Kyckling");
        int animalToMate = Integer.parseInt(console.nextLine());
        switch (animalToMate){
            case 1:
                for (int i = 0; i < animalsList.size(); i++){
                    if(animalsList.get(i).getAnimalType().equalsIgnoreCase("Ko")){
                        System.out.println(i+ ": " + animalsList.get(i).getAnimalType() + " Kön: " + animalsList.get(i).getGender());
                    }
                }
                System.out.println("Välj en ko av type hane");
                System.out.print("Mata in en siffra för att göra ett val: ");

                for (int i = 0; i < animalsList.size(); i++){
                    if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Ko")){
                        if (animalsList.get(i).getGender().equalsIgnoreCase("Hane")){
                            System.out.println(i+ ": " + animalsList.get(i).getName() + " Kön: " + animalsList.get(i).getGender());
                        }
                    }
                }
                int maleCow = Integer.parseInt(console.nextLine());
                System.out.println("Välj en ko av type hona ");
                System.out.print("Mata in en siffra för att göra ett val: ");

                for (int i = 0; i < animalsList.size(); i++){
                    if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Ko")){
                        if (animalsList.get(i).getGender().equalsIgnoreCase("Hona")){
                            System.out.println(i+ ": " + animalsList.get(i).getName() + "Kön: " + animalsList.get(i).getGender());
                        }
                    }
                }
                int femaleCow = Integer.parseInt(console.nextLine());
                mateAnimals.CreateNewAnimals(this, animalsList.get(maleCow), animalsList.get(femaleCow));
                break;

            case 2:
                for (int i = 0; i < animalsList.size(); i++){
                    if(animalsList.get(i).getAnimalType().equalsIgnoreCase("Häst")){
                        System.out.println(i+ ": " + animalsList.get(i).getAnimalType() + "Kön: " + animalsList.get(i).getGender());
                    }
                }
                System.out.println("Välj en häst av type hane");
                System.out.print("Mata in en siffra för att göra ett val: ");

                for (int i = 0; i < animalsList.size(); i++){
                    if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Häst")){
                        if (animalsList.get(i).getGender().equalsIgnoreCase("Hane")){
                            System.out.println(i+ ": " + animalsList.get(i).getName() + "Kön: " + animalsList.get(i).getGender());
                        }
                    }
                }
                int maleHorse = Integer.parseInt(console.nextLine());
                System.out.println("Välj en häst av type hona ");
                System.out.print("Mata in en siffra för att göra ett val: ");

                for (int i = 0; i < animalsList.size(); i++){
                    if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Häst")){
                        if (animalsList.get(i).getGender().equalsIgnoreCase("Hona")){
                            System.out.println(i+ ": " + animalsList.get(i).getName() + "Kön: " + animalsList.get(i).getGender());
                        }
                    }
                }
                int femaleHorse = Integer.parseInt(console.nextLine());
                mateAnimals.CreateNewAnimals(this, animalsList.get(maleHorse), animalsList.get(femaleHorse));
                break;

            case 3:
                for (int i = 0; i < animalsList.size(); i++){
                    if(animalsList.get(i).getAnimalType().equalsIgnoreCase("Gris")){
                        System.out.println(i+ ": " + animalsList.get(i).getAnimalType() + "Kön: " + animalsList.get(i).getGender());
                    }
                }
                System.out.println("Välj en gris av type hane");
                System.out.print("Mata in en siffra för att göra ett val: ");

                for (int i = 0; i < animalsList.size(); i++){
                    if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Gris")){
                        if (animalsList.get(i).getGender().equalsIgnoreCase("Hane")){
                            System.out.println(i+ ": " + animalsList.get(i).getName() + "Kön: " + animalsList.get(i).getGender());
                        }
                    }
                }
                int malePig = Integer.parseInt(console.nextLine());
                System.out.println("Välj en gris av type hona ");
                System.out.print("Mata in en siffra för att göra ett val: ");

                for (int i = 0; i < animalsList.size(); i++){
                    if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Gris")){
                        if (animalsList.get(i).getGender().equalsIgnoreCase("Hona")){
                            System.out.println(i+ ": " + animalsList.get(i).getName() + "Kön: " + animalsList.get(i).getGender());
                        }
                    }
                }
                int femalePig = Integer.parseInt(console.nextLine());
                mateAnimals.CreateNewAnimals(this, animalsList.get(malePig), animalsList.get(femalePig));
                break;
            case 4:
                for (int i = 0; i < animalsList.size(); i++){
                    if(animalsList.get(i).getAnimalType().equalsIgnoreCase("Get")){
                        System.out.println(i+ ": " + animalsList.get(i).getAnimalType() + "Kön: " + animalsList.get(i).getGender());
                    }
                }
                System.out.println("Välj en get av type hane");
                System.out.print("Mata in en siffra för att göra ett val: ");

                for (int i = 0; i < animalsList.size(); i++){
                    if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Get")){
                        if (animalsList.get(i).getGender().equalsIgnoreCase("Hane")){
                            System.out.println(i+ ": " + animalsList.get(i).getName() + "Kön: " + animalsList.get(i).getGender());
                        }
                    }
                }
                int maleGoat = Integer.parseInt(console.nextLine());
                System.out.println("Välj en get av type hona ");
                System.out.print("Mata in en siffra för att göra ett val: ");

                for (int i = 0; i < animalsList.size(); i++){
                    if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Get")){
                        if (animalsList.get(i).getGender().equalsIgnoreCase("Hona")){
                            System.out.println(i+ ": " + animalsList.get(i).getName() + "Kön: " + animalsList.get(i).getGender());
                        }
                    }
                }
                int femaleGoat = Integer.parseInt(console.nextLine());
                mateAnimals.CreateNewAnimals(this, animalsList.get(maleGoat), animalsList.get(femaleGoat));
                break;

            case 5:
                for (int i = 0; i < animalsList.size(); i++){
                    if(animalsList.get(i).getAnimalType().equalsIgnoreCase("Kyckling")){
                        System.out.println(i+ ": " + animalsList.get(i).getAnimalType() + "Kön: " + animalsList.get(i).getGender());
                    }
                }
                System.out.println("Välj en kyckling av type hane");
                System.out.print("Mata in en siffra för att göra ett val: ");

                for (int i = 0; i < animalsList.size(); i++){
                    if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Kyckling")){
                        if (animalsList.get(i).getGender().equalsIgnoreCase("Hane")){
                            System.out.println(i+ ": " + animalsList.get(i).getName() + "Kön: " + animalsList.get(i).getGender());
                        }
                    }
                }
                int maleChicken = Integer.parseInt(console.nextLine());
                System.out.println("Välj en kyckling av type hona ");
                System.out.print("Mata in en siffra för att göra ett val: ");

                for (int i = 0; i < animalsList.size(); i++){
                    if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Kyckling")){
                        if (animalsList.get(i).getGender().equalsIgnoreCase("Hona")){
                            System.out.println(i+ ": " + animalsList.get(i).getName() + "Kön: " + animalsList.get(i).getGender());
                        }
                    }
                }
                int femaleChicken = Integer.parseInt(console.nextLine());
                mateAnimals.CreateNewAnimals(this, animalsList.get(maleChicken), animalsList.get(femaleChicken));
                break;
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


