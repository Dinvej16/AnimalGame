package animalgame.animals;

import java.io.Serializable;

public abstract class Animal implements Serializable {

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

    public abstract void setType(String type);
}



