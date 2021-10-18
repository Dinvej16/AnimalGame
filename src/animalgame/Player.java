package animalgame;

public abstract class Player {
    private String name;
    private double money;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public double getMoney(){
        return this.money;

    }

}


