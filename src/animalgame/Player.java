package animalgame;

import animalgame.animals.Animal;
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

    private CattleFood cattleFood;
    private Hay hay;
    private Grass grass;

    private Player player;
    private Menus menusOptions;
    private Scanner console;


    public Player(String name){
        this.name = name;
        this.animalsList = new ArrayList<>();
        this.menusOptions = new Menus();
        this.console = new Scanner(System.in);

        this.cattleFood = new CattleFood();
        this.hay = new Hay();
        this.grass = new Grass();
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addAnimalToList(Animal animal){
        animalsList.add(animal);
    }



    public void buyFood(String foodType, int kilos) {
        switch (foodType){
            case "hö":
               hay.addKilos(kilos);
                break;
            case "gräs":
                grass.addKilos(kilos);
            case "foder":
                cattleFood.addKilos(kilos);
        }
    }
    public void feedAnimals(){
        System.out.println("Spelare: " + name);
        System.out.println("Vilket djur vill du mata?, se alternativen nedan.");
        menusOptions.printAnimalMenu();
        int feedAnimalChoice = console.nextInt();
        switch (feedAnimalChoice){
            case 1:
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


