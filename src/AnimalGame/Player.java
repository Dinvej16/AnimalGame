package AnimalGame;

public abstract class Player {
    private String name;

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


}


