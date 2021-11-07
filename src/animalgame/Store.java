package animalgame;

import animalgame.animals.*;
import animalgame.food.CattleFood;
import animalgame.food.Grass;
import animalgame.food.Hay;

import java.util.Scanner;

public class Store {
    private Scanner console;
    private Player player;
    private int price;
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
    private Grass grass;
    private Hay hay;

    public Store(){
        this.console = new Scanner(System.in);
        this.menusOptions = new Menus();

    }
    public void buyAnimalMenu(){
        System.out.println("Välkommen till affären! ");
        System.out.println("I denna delen av affären köper du djur, se alternativen nedan.");
        System.out.println("-".repeat(50));
        menusOptions.printAnimalPriceMenu();
        int animalChoice = console.nextInt();
        int newAmountOfMoney;
        int genderOption;
        String animalName;
        switch (animalChoice){
            case 1:
                System.out.println("Kon kostar 200kr");
                price = 200;
                creditCard = player.getMoney();
                if (price > creditCard) {
                    System.out.println("Köpet gick inte igenom");
                } else {
                    newAmountOfMoney = creditCard -= price;
                    player.setMoney(newAmountOfMoney);
                    System.out.print("Ge din ko ett namn: ");
                    animalName = console.next();
                    this.cow = new Cow(animalName);
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

                    this.player.addAnimalToList(this.cow);
                    System.out.println("Pengar: " + this.creditCard);
                }
                break;

            case 2:
                System.out.println("Hästen kostar 150kr");
                price = 150;
                creditCard = player.getMoney();
                if (price > creditCard) {
                    System.out.println("Köpet gick inte igenom");
                } else {
                    newAmountOfMoney = creditCard -= price;
                    player.setMoney(newAmountOfMoney);
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
                    System.out.println("Pengar: " + this.creditCard);
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
                            this.horse.setGender("Hane");
                            break;
                        case 2:
                            this.horse.setGender("Hona");
                            break;
                    }

                    this.player.addAnimalToList(this.pig);
                    System.out.println("Pengar: " + this.creditCard);
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
                            this.horse.setGender("Hane");
                            break;
                        case 2:
                            this.horse.setGender("Hona");
                            break;
                    }

                    this.player.addAnimalToList(this.goat);
                    System.out.println("Pengar: " + this.creditCard);
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
                            this.horse.setGender("Hane");
                            break;
                        case 2:
                            this.horse.setGender("Hona");
                            break;
                    }

                    this.player.addAnimalToList(this.chicken);
                    System.out.println("Pengar: " + this.creditCard);
                }
                break;
        }
    }

}
