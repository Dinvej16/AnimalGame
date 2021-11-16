package animalgame.food;

public class Hay extends Food {
    public int kilos = 0;
    private int minKilos = 0;
    private int heal = 0;


    @Override
    public void giveHealth() {
        this.heal += 10;

    }
    public void addKilos(int kilos){
        this.kilos += kilos;
    }
    public void removeKilos(int kilos){
        this.kilos -= kilos;
    }

    public int getKilos() {
        return kilos;
    }
}
