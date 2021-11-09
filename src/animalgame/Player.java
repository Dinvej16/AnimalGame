package animalgame;

import animalgame.animals.Animal;
import animalgame.animals.Cow;
import animalgame.animals.Horse;
import animalgame.food.CattleFood;
import animalgame.food.Food;
import animalgame.food.Grass;
import animalgame.food.Hay;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private int money = 1000;
    private ArrayList<Animal> animalsList;

    //Food
    private CattleFood cattleFood;
    private Hay hay;
    private Grass grass;

    private Player player;
    private Menus menusOptions;
    private Scanner console;


    public Player(String name){
        this.name = name;
        this.animalsList = new ArrayList<>();
        this.menusOptions = new Menus();
        this.console = new Scanner(System.in);

        this.cattleFood = new CattleFood();
        this.hay = new Hay();
        this.grass = new Grass();

    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addAnimalToList(Animal animal){
        animalsList.add(animal);
    }

    public void buyFood(String foodType, int kilos) {
        switch (foodType){
            case "hö":
               hay.addKilos(kilos);
                break;
            case "gräs":
                grass.addKilos(kilos);
            case "foder":
                cattleFood.addKilos(kilos);
        }
    }
    public void feedAnimals(){
        System.out.println("Spelare: " + name);
        System.out.println("Vilket djur vill du mata?, se alternativen nedan.");
        menusOptions.printAnimalMenu();
        int feedAnimalChoice = console.nextInt();
        System.out.println("-".repeat(50));
        switch (feedAnimalChoice){
            //Ko
            case 1:
                System.out.println("Välj vilken ko du vill mata?");

                for (int i = 0; i < animalsList.size(); i++){
                    if (animalsList.get(i).getAnimalType().equalsIgnoreCase("Ko")){
                        System.out.println(i +  ":" + " " + animalsList.get(i).getName());
                    }
                }
                System.out.print("Mata in en siffra för att välja en ko: ");
                int cowChoice = console.nextInt();
                animalsList.get(cowChoice);
                System.out.println("-".repeat(50));
                System.out.println("Välj vad kon ska äta, se alternativen nedan.");
                System.out.println("1.Gräs");
                System.out.print("Mata in en siffra för att gör ett val: ");
                int foodChoice = console.nextInt();
                switch (foodChoice){
                    case 1:
                        grass.giveHealth();
                        break;
                }

                break;

            //Häst
            case 2:

                break;
            //Gris
            case 3:

                break;
            //Get
            case 4:

                break;
            //Kyckling
            case 5:

                break;
        }

    }

}


