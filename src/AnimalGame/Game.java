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

    }
}


