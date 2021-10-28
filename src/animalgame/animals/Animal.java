package animalgame.animals;

public abstract class Animal {
    private String name;
    private String gender;
    private int health = 100;

    public Animal(String name){
        this.name = name;


    }
    public void eat(){

    }
    public void sayHi(){
        System.out.println("Hello");
    }

    public double getHealth() {
        return health;
    }
}


