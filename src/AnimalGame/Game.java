package AnimalGame;

import java.util.Scanner;

public class Game {
    private boolean isRunning;
    private Scanner console;

    public Game(){
        this.console = new Scanner(System.in);
    }
    public void startGame(){
        isRunning = true;
        System.out.println("Välkommen till AnimalGame! Tryck enter för att starta...");
        console.nextLine();
        

    }



}
