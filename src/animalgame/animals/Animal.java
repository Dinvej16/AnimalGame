package animalgame.animals;

public abstract class Animal {

<<<<<<< HEAD
    public Animal(String name){
        this.name = name;
    }
    public void eat(){
=======
    public abstract void eat();

    public abstract void mate();

    public abstract void health();
>>>>>>> Dino

    public abstract void deadAnimal();

    public abstract void healthDecrease();

    public abstract String getHealthDecrease();

    public abstract String getHealth();

    public abstract void setGender(String gender);

    public abstract String getGender();

    public abstract String getName();

    public abstract String getAnimalType();

}



