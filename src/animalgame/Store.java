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
        int gender;
        String animalName;
        switch (animalChoice){
            case 1:
                System.out.println("Hästen kostar 200kr");
                price = 200;
                creditCard = player.getMoney();
                if (price > creditCard){
                    System.out.println("Köpet gick inte igenom");
                }else {
                    newAmountOfMoney = creditCard -= price;
                    player.setMoney(newAmountOfMoney);
                    System.out.print("Ge din häst ett namn: ");
                    animalName = console.next();


                }


                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }





}
