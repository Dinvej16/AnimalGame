package AnimalGame;


import java.util.Scanner;

public class Game {
    private Scanner console;



    public Game(){
        this.console = new Scanner(System.in);
        startGame();
    }
    public void startGame(){
        System.out.println("Välkommen till AnimalGame! Tryck enter för att starta...");
        console.nextLine();
        System.out.println("(5-30)");
        System.out.println("Ange antalet spelrundor:");
        console.nextInt();
        System.out.println("(2-4)");
        System.out.println("Ange antalet spelare:");
        console.nextInt();
        System.out.println("Ange namn för spelare 1:");



    }
}


