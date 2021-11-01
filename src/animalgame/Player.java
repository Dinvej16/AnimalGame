package animalgame;

import animalgame.animals.Animal;

import java.util.ArrayList;

public class Player {
    private String name;
    private int money = 1000;
    private ArrayList<Animal> myAnimals;

    public Player(){
        this.myAnimals = new ArrayList<>();

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


