package animalgame;


import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Scanner console;
    private int gameRounds;
    private int currentRound;
    private ArrayList<Player> players;

    // Konstruktor
    public Game(){
        this.console = new Scanner(System.in);
        this.players = new ArrayList<>();
        System.out.println("Välkommen till AnimalGame! Tryck enter för att starta...");
        console.nextLine();
        initStartData();
        this.currentRound = 1;
        while( currentRound <= gameRounds ){
            playRound();
        }
        calculateEndResult();
    }

    /**
     * Let user choose amount of rounds to play &
     * number of players in the game.
     * Also, let all players created have a chosen name
     */
    public void initStartData(){
        System.out.println("(5-30)");
        System.out.println("Ange antalet spelrundor:");
        this.gameRounds = console.nextInt();

        System.out.println("(2-4)");
        System.out.println("Ange antalet spelare:");
        int playersToCreate = console.nextInt();
        for( int i=0; i<playersToCreate; i++ ){
            System.out.println("Ange namn för spelare "+(i+1) );
            // Vi ska fylla vår players arraylist med nya player objekt, baserat
            // på vad användaren väljer o döpa dem.
        }
    }



}


