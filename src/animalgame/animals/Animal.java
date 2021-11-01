package animalgame.animals;

public abstract class Animal {
    private String name;
    private String gender;
    private int startHealth = 100;

    public Animal(String name){
        this.name = name;


    }
    public void eat(){

    }
    public int getHealth() {
        return startHealth;
    }
}


