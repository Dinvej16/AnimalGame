package animalgame;


import animalgame.animals.Animal;
import animalgame.animals.Cow;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Scanner console;
    private int gameRounds;
    private int currentRound;
    private int maxRounds = 30;
    private int minRounds = 5;
    private ArrayList<Player> players;
    private Player newPlayer;
    private int maxPlayers = 4;
    private int minPlayers = 2;
    private Menus menuOptions;
    private 


    // Konstruktor
    public Game(){
        this.console = new Scanner(System.in);
        this.menuOptions = new Menus();
        this.players = new ArrayList<>();
        this.newPlayer = new Player();

        System.out.println("Välkommen till AnimalGame! Tryck enter för att starta...");
        console.nextLine();
        System.out.println("-".repeat(50));
        initRounds();
        System.out.println("-".repeat(50));
        initPlayers();
        this.currentRound = 1;
        this.mainMenu();

        //
        //while( currentRound <= gameRounds ){
            //playRound();
        //calculateEndResult();
        }

    /**
     * Let user choose amount of rounds to play &
     * number of players in the game.
     * Also, let all players created have a chosen name
     */
    public void initRounds() {
        System.out.println("(5-30)");
        System.out.println("Ange antalet spelrundor:");
        this.gameRounds = console.nextInt();
        if (gameRounds > maxRounds) {
            System.out.println("Max antal rundor är 30! Försök igen... ");
            initRounds();
        } else if (gameRounds < minRounds) {
            System.out.println("Minst antal rundor är 5! Försök igen...");
            initRounds();
        }
    }
    public void initPlayers() {
        System.out.println("(2-4)");
        System.out.println("Ange antalet spelare:");
        int playersToCreate = console.nextInt();

        if (playersToCreate > maxPlayers) {
            System.out.println("Max antal spelare som kan spela är 4! Försök igen...");
            initPlayers();
        } else if (playersToCreate < minPlayers) {
            System.out.println("Minst antal spelare som kan spela är 2! Försök igen...");
            initPlayers();
        }
        for (int i = 0; i < playersToCreate; i++) {
            System.out.println("Ange namn för spelare " + (i + 1));
            newPlayer.setName(console.next());
            players.add(newPlayer);
            // Vi ska fylla vår players arraylist med nya player objekt, baserat
            // på vad användaren väljer o döpa dem.
        }
    }


    public void mainMenu(){
        System.out.println("-".repeat(50));
            menuOptions.printMainMenu();
            int mainOptions = console.nextInt();
            switch (mainOptions){
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;

        }
    }

}


