package animalgame;


import animalgame.animals.Animal;
import animalgame.animals.Cow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Game {
    private Scanner console;

    private ArrayList<Player> players;
    private Player newPlayer;
    private int maxPlayers = 4;
    private int minPlayers = 2;

    private int rounds;
    private int currentRound = 1;
    private int maxRounds = 30;
    private int minRounds = 5;

    private Menus menuOptions;
    private Store store;


    // Konstruktor
    public Game(){
        this.console = new Scanner(System.in);
        this.menuOptions = new Menus();

        System.out.println("Välkommen till AnimalGame! Tryck enter för att starta...");
        console.nextLine();
        System.out.println("-".repeat(50));
        initPlayers();
        System.out.println("-".repeat(50));
        initRounds();
        printPlayerInfo();
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
        this.rounds = console.nextInt();
        if (rounds > maxRounds) {
            System.out.println("Max antal rundor är 30! Försök igen... ");
            initRounds();
        } else if (rounds < minRounds) {
            System.out.println("Minst antal rundor är 5! Försök igen...");
            initRounds();
        }
    }
    public void initPlayers() {
        this.players = new ArrayList<>();
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
            String nameChoice = console.next();
            this.newPlayer = new Player(nameChoice);
            players.add(newPlayer);
            // Vi ska fylla vår players arraylist med nya player objekt, baserat
            // på vad användaren väljer o döpa dem.
        }

    }
    public void printPlayerInfo(){
        System.out.println("Antal aktiva spelare: " + players.size());
        for (Player players: players){
            System.out.println("-".repeat(50));
            System.out.println(players.getName() + " | " +" Pengar: " +players.getMoney() + "kr");
        }
    }

    public void mainMenu(){
            System.out.println("-".repeat(50));
            menuOptions.printMainMenu();
            int mainOptions = console.nextInt();
            switch (mainOptions){
                case 1:
                    this.store = new Store();
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


