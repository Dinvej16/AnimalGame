package animalgame;

import animalgame.animals.Animal;
import animalgame.food.Food;

import java.util.ArrayList;

public class Player {
    private String name;
    private int money = 1000;
    private ArrayList<Animal> animalsList;
    private ArrayList<Food> foodList;

    public Player(){
        this.animalsList = new ArrayList<>();
        this.foodList = new ArrayList<>();

    }
    public void buyAnimal(){

    }
    public void buyFood(){

    }
    public void sellAnimal(){

    }
    public void feedAnimal(){

    }
    public void mateAnimal(){

    }
    public int getMoney(){
        return money;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}


