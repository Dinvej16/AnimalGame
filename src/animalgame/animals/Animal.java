package animalgame.animals;

public abstract class Animal {
    private String name;

    private String gender;
    private int startHealth = 100;

    public Animal(String name, String gender){
        this.name = name;
        this.gender = gender;

    }

    public int getHealth() {
        return startHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}


