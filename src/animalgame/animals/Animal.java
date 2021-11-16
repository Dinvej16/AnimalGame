package animalgame.animals;

public abstract class Animal {

    public Animal(String name){
        this.name = name;
    }
    public void eat(){

    public abstract void eat(String foodChoice, int kilo);

    public abstract void mate();

    public abstract void health();


    public abstract void deadAnimal();

    public abstract void healthDecrease();

    public abstract String getHealthDecrease();

    public abstract int getHealth();

    public abstract void setGender(String gender);

    public abstract String getGender();

    public abstract String getName();

    public abstract String getAnimalType();

}



