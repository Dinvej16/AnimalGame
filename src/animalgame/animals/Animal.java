package animalgame.animals;

import java.io.Serializable;

/**
 * This is the Animal Class that store some abstract methods
 * that each animal inherit.
 *
 * @author Dino Vejzovic, Carl Lander, Perin Koriea
 */

public abstract class Animal implements Serializable {

    public abstract void eat(String foodChoice, int kilo);

    public abstract void healthDecrease();

    public abstract String getHealthDecrease();

    public abstract int getHealth();

    public abstract void setGender(String gender);

    public abstract String getGender();

    public abstract String getName();

    public abstract String getAnimalType();

    public abstract void setType(String type);
}



