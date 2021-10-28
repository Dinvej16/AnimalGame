package animalgame;

public class Player {
    private String name;
    private int money = 1000;

    public Player(){

    }

    public int getMoney(){
        return money;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}


