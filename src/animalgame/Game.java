package animalgame;

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
    public Game() {
        this.console = new Scanner(System.in);
        this.menuOptions = new Menus();

        System.out.println("Välkommen till AnimalGame! Tryck enter för att starta...");
        console.nextLine();
        System.out.println("-".repeat(50));
        initPlayers();
        System.out.println("-".repeat(50));
        initRounds();
        System.out.println("-".repeat(50));
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
        System.out.print("Ange antalet spelrundor: ");
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
        System.out.print("Ange antalet spelare: ");
        int playersToCreate = console.nextInt();

        if (playersToCreate > maxPlayers) {
            System.out.println("Max antal spelare som kan spela är 4! Försök igen...");
            initPlayers();
        } else if (playersToCreate < minPlayers) {
            System.out.println("Minst antal spelare som kan spela är 2! Försök igen...");
            initPlayers();
        }
        else {
            for (int i = 0; i < playersToCreate; i++) {
                System.out.println("Ange namn för spelare " + (i + 1));
                String nameChoice = console.next();
                this.newPlayer = new Player(nameChoice);
                players.add(newPlayer);
            }
        }

    }

    public void printPlayerInfo() {
        System.out.println("Antal aktiva spelare: " + players.size());
        for (Player players : players) {
            System.out.println("Spelare: " + players.getName() + " | " + " Pengar: " + players.getMoney() + "kr");
        }
    }

    public void mainMenu() {
        Player player;
        for (int i = 0; i < rounds; i++) {
            for (Iterator var2 = players.iterator(); var2.hasNext(); player.animalHealthDecrease()) {
                player = (Player) var2.next();
                String activePlayer = player.getName();
                System.out.println("-".repeat(50));
                System.out.println(player.getName() + "s" + " djur: ");
                player.getAnimals();
                System.out.println("-".repeat(50));
                System.out.println(activePlayer + " det är din tur, gör ett val!" + "\n" + "Pengar: " + player.getMoney() + "Kr");
                menuOptions.printMainMenu();
                int mainOptions = console.nextInt();
                System.out.println("-".repeat(50));
                switch (mainOptions) {
                    case 1:
                        //Klar
                        this.store = new Store(player);
                        store.buyAnimalMenu();
                        break;
                    case 2:
                        //Klar
                        this.store = new Store(player);
                        store.buyAnimalFood();
                        break;
                    case 3:
                        //måste fixas
                        player.feedAnimals();
                        break;
                    case 4:
                        //Para djur
                        break;
                    case 5:
                        //Sälj djur
                        break;
                }
            }
        }
    }

}


