package AnimalGame;

public abstract class Player {
    private String name;

    public Player() {
        System.out.println("Hej");
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


}


