package animalgame;

import animalgame.animals.Animal;
import animalgame.food.Food;

import java.util.ArrayList;

public class Player {
    private String name;
    private int money = 1000;
    private ArrayList<Animal> animalsList;
    private ArrayList<Food> foodList;


    public Player(String name){
        this.name = name;
        this.animalsList = new ArrayList<>();
        this.foodList = new ArrayList<>();

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
    public void addFoodToList(Food food){
        foodList.add(food);
    }

}


