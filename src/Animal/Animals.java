package Animal;

public abstract class Animals {
    private String name;
    private String gender;
    private double health;

    public Animals(String name){
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


