package animalgame;

import animalgame.Food.CattleFood;
import animalgame.Food.Grass;
import animalgame.Food.Hay;
import animalgame.animals.*;


import java.io.Serializable;
import java.util.Scanner;

public class Store implements Serializable {
    private Scanner console;
    private Player player;
    private int price;
    private int reSalePrice;
    private int creditCard;
    private Menus menusOptions;
    //Animals
    private Horse horse;
    private Chicken chicken;
    private Cow cow;
    private Goat goat;
    private Pig pig;
    //Food
    private CattleFood cattleFood;
    private Hay hay;
    private Grass grass;

    public Store(Player player) {
        this.menusOptions = new Menus();
        this.player = player;
        this.console = new Scanner(System.in);
    }

    public void helpSellAllAnimals(int changedPrice) {
        int newAmountOfMoney3;
        if (player.animalsList.isEmpty()) {
            System.out.println("Du har inga djur att sälja");
        }
        creditCard = player.getMoney();
        newAmountOfMoney3 = creditCard + reSalePrice;
        player.setMoney(newAmountOfMoney3);
    }

    public void sellAllAnimals(String inputType, int chosenAnimal){
        int health = chosenAnimal;
        String animalType = inputType;

        switch (animalType){
            case "ko":
                reSalePrice = (200 * health / 100);
                helpSellAllAnimals(reSalePrice);
            case "Häst":
                reSalePrice = (150 * health / 100);
                helpSellAllAnimals(reSalePrice);
            case "Gris":
                reSalePrice = (100 * health / 100);
                helpSellAllAnimals(reSalePrice);
            case "Get":
                reSalePrice = (75 * health / 100);
                helpSellAllAnimals(reSalePrice);
            case "Kyckling":
                reSalePrice = (50 * health / 100);
                helpSellAllAnimals(reSalePrice);
        }
    }


    //Method for buying animals
    public void buyAnimalMenu() {
        System.out.println("-".repeat(50));
        System.out.println("Spelare: " + player.getName() + " | " + " Pengar: " + player.getMoney() + "kr");
        menusOptions.printAnimalPriceMenu();
        int animalChoice = console.nextInt();
        int newAmountOfMoney;
        int genderOption;
        int option;
        String animalName;
        switch (animalChoice) {
            case 1:
                System.out.println("Kon kostar 200kr");
                price = 200;
                creditCard = this.player.getMoney();
                if (price > creditCard) {
                    System.out.println("Köpet gick inte igenom");
                } else {
                    newAmountOfMoney = creditCard -= price;
                    this.player.setMoney(newAmountOfMoney);
                    System.out.print("Ge din ko ett namn: ");
                    animalName = console.next();
                    this.cow = new Cow(animalName);
                    System.out.println("Välj kön: 1.Hane, 2.Hona");
                    option = console.nextInt();
                    switch (option) {
                        case 1:
                            this.cow.setGender("Hane");
                            break;
                        case 2:
                            this.cow.setGender("Hona");
                            break;
                    }
                    this.player.addAnimalToList(this.cow);
                    System.out.println("Vill du köpa fler djur?");
                    System.out.println("1.Ja, 2.Nej");
                    System.out.print("Mata in en siffra för att göra ett val: ");
                    option = console.nextInt();
                    switch (option) {
                        case 1:
                            buyAnimalMenu();
                            break;
                        default:
                            break;
                    }
                }
                break;

            case 2:
                System.out.println("Hästen kostar 150kr");
                price = 150;
                creditCard = this.player.getMoney();
                if (price > creditCard) {
                    System.out.println("Köpet gick inte igenom");
                } else {
                    newAmountOfMoney = creditCard -= price;
                    this.player.setMoney(newAmountOfMoney);
                    System.out.print("Ge din häst ett namn: ");
                    animalName = console.next();
                    this.horse = new Horse(animalName);
                    System.out.println("Välj kön: 1.Hane, 2.Hona");
                    genderOption = console.nextInt();
                    switch (genderOption) {
                        case 1:
                            this.horse.setGender("Hane");
                            break;
                        case 2:
                            this.horse.setGender("Hona");
                            break;
                    }

                    this.player.addAnimalToList(this.horse);
                    System.out.println("Vill du köpa fler djur?");
                    System.out.println("1.Ja, 2.Nej");
                    System.out.print("Mata in en siffra för att göra ett val: ");
                    option = console.nextInt();
                    switch (option) {
                        case 1:
                            buyAnimalMenu();
                            break;
                        default:
                            break;
                    }
                }
                break;

            case 3:
                System.out.println("Grisen kostar 100kr");
                price = 100;
                creditCard = player.getMoney();
                if (price > creditCard) {
                    System.out.println("Köpet gick inte igenom");
                } else {
                    newAmountOfMoney = creditCard -= price;
                    player.setMoney(newAmountOfMoney);
                    System.out.print("Ge din gris ett namn: ");
                    animalName = console.next();
                    this.pig = new Pig(animalName);
                    System.out.println("Välj kön: 1.Hane, 2.Hona");
                    genderOption = console.nextInt();
                    switch (genderOption) {
                        case 1:
                            this.pig.setGender("Hane");
                            break;
                        case 2:
                            this.pig.setGender("Hona");
                            break;
                    }

                    this.player.addAnimalToList(this.pig);
                    System.out.println("Vill du köpa fler djur?");
                    System.out.println("1.Ja, 2.Nej");
                    System.out.print("Mata in en siffra för att göra ett val: ");
                    option = console.nextInt();
                    switch (option) {
                        case 1:
                            buyAnimalMenu();
                            break;
                        default:
                            break;
                    }
                }
                break;
            case 4:
                System.out.println("Geten kostar 80kr");
                price = 80;
                creditCard = player.getMoney();
                if (price > creditCard) {
                    System.out.println("Köpet gick inte igenom");
                } else {
                    newAmountOfMoney = creditCard -= price;
                    player.setMoney(newAmountOfMoney);
                    System.out.print("Ge din get ett namn: ");
                    animalName = console.next();
                    this.goat = new Goat(animalName);
                    System.out.println("Välj kön: 1.Hane, 2.Hona");
                    genderOption = console.nextInt();
                    switch (genderOption) {
                        case 1:
                            this.goat.setGender("Hane");
                            break;
                        case 2:
                            this.goat.setGender("Hona");
                            break;
                    }

                    this.player.addAnimalToList(this.goat);
                    System.out.println("Vill du köpa fler djur?");
                    System.out.println("1.Ja, 2.Nej");
                    System.out.print("Mata in en siffra för att göra ett val: ");
                    option = console.nextInt();
                    switch (option) {
                        case 1:
                            buyAnimalMenu();
                            break;
                        default:
                            break;
                    }
                }
                break;

            case 5:
                System.out.println("Kycklingen kostar 50kr");
                price = 50;
                creditCard = player.getMoney();
                if (price > creditCard) {
                    System.out.println("Köpet gick inte igenom");
                } else {
                    newAmountOfMoney = creditCard -= price;
                    player.setMoney(newAmountOfMoney);
                    System.out.print("Ge din kyckling ett namn: ");
                    animalName = console.next();
                    this.chicken = new Chicken(animalName);
                    System.out.println("Välj kön: 1.Hane, 2.Hona");
                    genderOption = console.nextInt();
                    switch (genderOption) {
                        case 1:
                            this.chicken.setGender("Hane");
                            break;
                        case 2:
                            this.chicken.setGender("Hona");
                            break;
                    }

                    this.player.addAnimalToList(this.chicken);
                    System.out.println("Vill du köpa fler djur?");
                    System.out.println("1.Ja, 2.Nej");
                    System.out.print("Mata in en siffra för att göra ett val: ");
                    option = console.nextInt();
                    switch (option) {
                        case 1:
                            buyAnimalMenu();
                            break;
                        default:
                            break;
                    }
                }
                break;
        }
    }

    //Method for buying food
    public void buyAnimalFood() {
        System.out.println("-".repeat(50));
        System.out.println("Spelare: " + player.getName() + " | " + " Pengar: " + player.getMoney() + "kr");
        menusOptions.printFoodPriceMenu();
        int foodChoice = console.nextInt();
        int option;
        int newAmountOfMoney2;
        switch (foodChoice) {
            case 1:
                System.out.println("Höet kostar 100kr");
                price = 100;
                creditCard = player.getMoney();
                if (price > creditCard) {
                    System.out.println("Köpet gick inte igenom");
                } else {
                    newAmountOfMoney2 = creditCard -= price;
                    player.setMoney(newAmountOfMoney2);
                    this.hay = new Hay();
                    System.out.println("Du har köpt 1kg hö!");

                    this.player.buyFood("hö", 1);
                    System.out.println("Vill du köpa mer mat?");
                    System.out.println("1.Ja, 2.Nej");
                    System.out.print("Mata in en siffra för att göra ett val: ");
                    option = console.nextInt();
                    switch (option) {
                        case 1:
                            buyAnimalFood();
                            break;
                        default:
                            break;
                    };
                }
                break;

            case 2:
                System.out.println("Gräset kostar 80kr");
                price = 80;
                creditCard = player.getMoney();
                if (price > creditCard) {
                    System.out.println("Köpet gick inte igenom");
                } else {
                    newAmountOfMoney2 = creditCard -= price;
                    player.setMoney(newAmountOfMoney2);
                    this.grass = new Grass();
                    System.out.println("Du har köpt 1kg gräs!");

                    this.player.buyFood("gräs", 1);
                    System.out.println("Vill du köpa mer mat?");
                    System.out.println("1.Ja, 2.Nej");
                    System.out.print("Mata in en siffra för att göra ett val: ");
                    option = console.nextInt();
                    switch (option) {
                        case 1:
                            buyAnimalFood();
                            break;
                        default:
                            break;
                    };
                }
                break;

            case 3:
                System.out.println("Fodret kostar 50kr");
                price = 50;
                creditCard = player.getMoney();
                if (price > creditCard) {
                    System.out.println("Köpet gick inte igenom");
                } else {
                    newAmountOfMoney2 = creditCard -= price;
                    player.setMoney(newAmountOfMoney2);
                    this.cattleFood = new CattleFood();
                    System.out.println("Du har köpt 1kg foder!");

                    this.player.buyFood("foder", 1);
                    System.out.println("Vill du köpa mer mat?");
                    System.out.println("1.Ja, 2.Nej");
                    System.out.print("Mata in en siffra för att göra ett val: ");
                    option = console.nextInt();
                    switch (option) {
                        case 1:
                            buyAnimalFood();
                            break;
                        default:
                            break;
                    }
                }
                break;
        }
    }

    public void sellAnimal() {
        if (player.animalsList.isEmpty()){
            System.out.println( player.getName() + " du har inte några djur att sälja...");
            System.out.print("Tryck enter för att låta nästa spelare spela: ");
            console.nextLine();
        }
        else {
            System.out.println("Välkommen till djuraffären! ");
            System.out.println("I denna delen säljer du djur, se alternativen nedan.");
            System.out.println("-".repeat(50));
            System.out.println("Spelare: " + player.getName() + " | " + " Pengar: " + player.getMoney() + "kr");
            System.out.println("-".repeat(50));
            System.out.println("Dina djur: ");

            for (int i = 0; i < player.animalsList.size(); i++){
                System.out.println(i + ": " + "Typ: " + player.animalsList.get(i).getAnimalType() + " | " + "Kön: " + player.animalsList.get(i).getGender() + " | " + "Namn: " + player.animalsList.get(i).getName() + " | "
                        + "Liv: " + player.animalsList.get(i).getHealth() + "%");
            }
            System.out.print("Mata in en siffra för att göra ett val: ");
            int newAmountOfMoney3;
            int option;
            int animalSellChoice = console.nextInt();
            String animalType = player.animalsList.get(animalSellChoice).getAnimalType();
            switch (animalType) {
                case "Ko":
                    reSalePrice = (200 * (player.animalsList.get(animalSellChoice).getHealth()) / 100);
                    System.out.println("Priset för din ko är: " + reSalePrice + "kr");
                    System.out.println("Vill du sälja din ko?");
                    System.out.println("1.Ja, 2.Sälj ett annat djur");
                    option = console.nextInt();
                    switch (option){
                        case 1:
                            player.animalsList.remove(animalSellChoice);
                            creditCard = player.getMoney();
                            newAmountOfMoney3 = creditCard + reSalePrice;
                            player.setMoney(newAmountOfMoney3);
                            System.out.println("Du sålde din ko för: " + reSalePrice + "kr");
                            System.out.println("Vill du sälja fler djur?");
                            System.out.println("1.Ja, 2.Nej");
                            System.out.print("Mata in en siffra för att göra ett val: ");
                            option = console.nextInt();
                            switch (option) {
                                case 1:
                                    if (player.animalsList.isEmpty()){
                                        System.out.println("Du har inte några djur att sälja");
                                    }
                                    else {
                                        sellAnimal();
                                        break;
                                    }
                            }
                            break;
                        case 2:
                            sellAnimal();
                            break;
                    }
                    break;

                case "Häst":
                    reSalePrice = (150 * (player.animalsList.get(animalSellChoice).getHealth()) / 100);
                    System.out.println("Priset för din häst är: " + reSalePrice + "kr");
                    System.out.println("Vill du sälja din häst?");
                    System.out.println("1.Ja, 2.Sälj ett annat djur");
                    System.out.print("Mata in en siffra för att göra ett val: ");
                    option = console.nextInt();
                    switch (option) {
                        case 1:
                            player.animalsList.remove(animalSellChoice);
                            creditCard = player.getMoney();
                            newAmountOfMoney3 = creditCard + reSalePrice;
                            player.setMoney(newAmountOfMoney3);
                            System.out.println("Du sålde din häst för: " + reSalePrice + "kr");
                            System.out.println("Vill du sälja fler djur?");
                            System.out.println("1.Ja, 2.Nej");
                            System.out.print("Mata in en siffra för att göra ett val: ");
                            option = console.nextInt();
                            switch (option) {
                                case 1:
                                    if (player.animalsList.isEmpty()){
                                        System.out.println("Du har inte några djur att sälja");
                                    }
                                    else {
                                        sellAnimal();
                                        break;
                                    }
                            }
                            break;
                        case 2:
                            sellAnimal();
                            break;
                    }
                    break;
                case "Gris":
                    reSalePrice = (100 * (player.animalsList.get(animalSellChoice).getHealth()) / 100);
                    System.out.println("Priset för din gris är: " + reSalePrice + "kr");
                    System.out.println("Vill du sälja din gris?");
                    System.out.println("1.Ja, 2.Sälj ett annat djur");
                    System.out.print("Mata in en siffra för att göra ett val: ");
                    option = console.nextInt();
                    switch (option) {
                        case 1:
                            player.animalsList.remove(animalSellChoice);
                            creditCard = player.getMoney();
                            newAmountOfMoney3 = creditCard + reSalePrice;
                            player.setMoney(newAmountOfMoney3);
                            System.out.println("Du sålde din gris för: " + reSalePrice + "kr");
                            System.out.println("Vill du sälja fler djur?");
                            System.out.println("1.Ja, 2.Nej");
                            System.out.print("Mata in en siffra för att göra ett val: ");
                            option = console.nextInt();
                            switch (option) {
                                case 1:
                                    if (player.animalsList.isEmpty()){
                                        System.out.println("Du har inte några djur att sälja");
                                    }
                                    else {
                                        sellAnimal();
                                        break;
                                    }
                            }
                            break;
                        case 2:
                            sellAnimal();
                            break;
                    }
                    break;
                case "Get":
                    reSalePrice = (80 * (player.animalsList.get(animalSellChoice).getHealth()) / 100);
                    System.out.println("Priset för din get är: " + reSalePrice + "kr");
                    System.out.println("Vill du sälja din get?");
                    System.out.println("1.Ja, 2.Sälj ett annat djur");
                    System.out.print("Mata in en siffra för att göra ett val: ");
                    option = console.nextInt();
                    switch (option) {
                        case 1:
                            player.animalsList.remove(animalSellChoice);
                            creditCard = player.getMoney();
                            newAmountOfMoney3 = creditCard + reSalePrice;
                            player.setMoney(newAmountOfMoney3);
                            System.out.println("Du sålde din get för: " + reSalePrice + "kr");
                            System.out.println("Vill du sälja fler djur?");
                            System.out.println("1.Ja, 2.Nej");
                            System.out.print("Mata in en siffra för att göra ett val: ");
                            option = console.nextInt();
                            switch (option) {
                                case 1:
                                    if (player.animalsList.isEmpty()){
                                        System.out.println("Du har inte några djur att sälja");
                                    }
                                    else {
                                        sellAnimal();
                                        break;
                                    }
                            }
                            break;
                        case 2:
                            sellAnimal();
                            break;
                    }
                    break;
                case "Kyckling":
                    reSalePrice = (50 * (player.animalsList.get(animalSellChoice).getHealth()) / 100);
                    System.out.println("Priset för din kyckling är: " + reSalePrice + "kr");
                    System.out.println("Vill du sälja din kyckling?");
                    System.out.println("1.Ja, 2.Sälj ett annat djur");
                    System.out.print("Mata in en siffra för att göra ett val: ");
                    option = console.nextInt();
                    switch (option) {
                        case 1:
                            player.animalsList.remove(animalSellChoice);
                            creditCard = player.getMoney();
                            newAmountOfMoney3 = creditCard + reSalePrice;
                            player.setMoney(newAmountOfMoney3);
                            System.out.println("Du sålde din kyckling för: " + reSalePrice + "kr");
                            System.out.println("Vill du sälja fler djur?");
                            System.out.println("1.Ja, 2.Nej");
                            System.out.print("Mata in en siffra för att göra ett val: ");
                            option = console.nextInt();
                            switch (option) {
                                case 1:
                                    if (player.animalsList.isEmpty()){
                                        System.out.println("Du har inte några djur att sälja");
                                    }
                                    else {
                                        sellAnimal();
                                        break;
                                    }
                            }
                            break;
                        case 2:
                            sellAnimal();
                            break;
                    }
                    break;
            }
        }
    }

}
