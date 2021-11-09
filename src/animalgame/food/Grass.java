package animalgame.food;

public class Grass extends Food {
    private int kilos = 0;
    private int heal = 10;

    @Override
    public void giveHealth(){


    }
    public void addKilos(int kilos){
        this.kilos += kilos;
    }
    public void removeKilos(int kilos){
        this.kilos -= kilos;
    }
}


