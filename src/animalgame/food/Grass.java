package animalgame.Food;

import java.io.Serializable;

/**
 * This is the Grass Class that is a type of food that
 * the animals can eat. This class extends the Food Class.
 *
 * @author Dino Vejzovic, Carl Lander, Perin Koriea
 */

public class Grass extends Food implements Serializable {
    public int kilos = 0;
    private int heal = 0;


    /**
     * This method is used when buying this type of food.
     * each time a player buys this food the player gets
     * 1 Kilo of this food.
     */
    public void addKilos(int kilos){
        this.kilos += kilos;
    }

    /**
     * This method is used when feeding an animal with this
     * type of food. Each time the player feed the animal
     * 1 kilo or more, it depends on how many kilos the
     * player choose to use. The kilos gets removed from
     * the place where the food is stored.
     */
    public void removeKilos(int kilos){
        this.kilos -= kilos;
    }

    /**
     * Method for getting the amount of this food the player have.
     */
    public int getKilos() {
        return kilos;
    }
}


