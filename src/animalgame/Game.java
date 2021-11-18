package animalgame;

import animalgame.animals.Animal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Game class where the main logic of the game happens. At first it prints a startMenu
 * where the user can choose to start a new game or load a saved game. Other stuff that happens in this class are
 * functions like players and rounds gets initialized, lets the players to choose between
 * different options while playing the game. Options like "Buy animal", "Sell animal", "Save game",
 * and other options and functions.
 *
 * @author Dino Vejzovic, Carl Lander, Perin Koriea
 */

public class Game {
    private Scanner console;

    private ArrayList<Player> players;
    private Player newPlayer;
    private int maxPlayers = 4;
    private int minPlayers = 2;

    private int rounds;
    private int loadedRound = 1;
    private int maxRounds = 30;
    private int minRounds = 5;
    private int currentRound = 1;


    private Menus menuOptions;
    private Store store;


    // Constructor
    public Game() {
        this.console = new Scanner(System.in);
        this.menuOptions = new Menus();
        System.out.println("Välkommen till AnimalGame!");
        for (int i = 0; i < 10; i++) {
            System.out.println("1.Nytt spel, 2.Ladda spel, 3.Regler & Info");
            System.out.print("Mata in en siffra för att göra ett val: ");
            int startMenuChoice = Integer.parseInt(console.nextLine());
            switch (startMenuChoice) {
                case 1:
                    System.out.println("\n".repeat(20));
                    initPlayers();
                    System.out.println("\n".repeat(20));
                    initRounds();
                    System.out.println("\n".repeat(20));
                    this.mainMenu();
                    calculateEndresult();
                    displayWinner();
                    break;

                case 2:
                    loadGame();
                    this.mainMenu();
                    calculateEndresult();
                    displayWinner();
                    break;

                case 3:
                    System.out.println("\n");
                    menuOptions.printRulesAndInfo();
                    System.out.println("\n");
                    System.out.println("Tryck enter för att gå tillbaka...");
                    console.nextLine();
                    break;
            }
            i++;
        }

    }

    /**
     * Method that is used to display the winner
     */
    private void displayWinner() {
        int playerWinner = 0;
        String playerName = null;
        for (Player player : players) {
            String activePlayer = player.getName();
            int currentMoney = player.getMoney();

            if (currentMoney > playerWinner) {
                playerWinner = currentMoney;
                playerName = activePlayer;
            }
        }
        System.out.println("Vinnaren är: " + playerName);
    }

    /**
     * Method that is used to calculate the end result.
     */
    private void calculateEndresult() {
        System.out.println("Antal spelare: " + players.size());
        System.out.println("-".repeat(50));
        for (Player player : players) {
            String activePlayer = player.getName();
            System.out.println(activePlayer + " din totala summar blev " + player.getMoney() + "kr ");
            System.out.println("-".repeat(50));
        }
    }

    /**
     * Method that is used to load a saved game in the start menu
     * that shows when the game starts.
     */
    private void loadGame() {
        System.out.println("Choose file name to load: ");
        String fileName = console.nextLine();
        SavedGame savedGame = FileHandler.loadSavedGame(fileName);
        if (savedGame != null) {
            this.players = savedGame.getPlayers();
            this.loadedRound = savedGame.getLastRoundPlayed();
            this.rounds = savedGame.getRounds();
        } else {
            System.out.println("Lämnar spelet...");
            System.exit(0);
        }

    }

    /**
     * Method that is used to save the game progress if u don't have time to
     * finish the game.
     */
    private void saveGameAndExit(int currentRound) {
        System.out.println("Choose file name to save: ");
        String fileToSave = console.nextLine();

        SavedGame savedGame = new SavedGame(players, currentRound, rounds);
        FileHandler.saveGameRuntime(savedGame, fileToSave);

    }

    /**
     * Let the user choose amount of rounds to play
     */
    public void initRounds() {
        System.out.println("(5-30)");
        System.out.print("Ange antalet spelrundor: ");
        try {
            this.rounds = Integer.parseInt(console.nextLine());
            if (rounds > maxRounds) {
                System.out.println("Max antal rundor är 30! Försök igen... ");
                initRounds();
            } else if (rounds < minRounds) {
                System.out.println("Minst antal rundor är 5! Försök igen...");
                initRounds();
            }

        } catch (Exception e) {
            System.out.println("Fel inmatning..., försök igen!");
            initRounds();
        }
    }

    /**
     * Let user choose amount of players to play.
     * Also, let all players created have a chosen name
     */
    public void initPlayers() {
        System.out.println("(2-4)");
        System.out.print("Ange antalet spelare: ");
        this.players = new ArrayList<>();

        try {
            int playersToCreate = Integer.parseInt(console.nextLine());
            if (playersToCreate > maxPlayers) {
                System.out.println("Max antal spelare som kan spela är 4! Försök igen...");
                initPlayers();

            } else if (playersToCreate < minPlayers) {
                System.out.println("Minst antal spelare som kan spela är 2! Försök igen...");
                initPlayers();
            } else {
                for (int i = 0; i < playersToCreate; i++) {
                    System.out.println("-".repeat(50));
                    System.out.println("Ange namn för spelare " + (i + 1));
                    String nameChoice = console.nextLine();
                    this.newPlayer = new Player(nameChoice);
                    players.add(newPlayer);
                }
            }
        } catch (Exception e) {
            System.out.println("Fel inmatning..., försök igen!");
            initPlayers();
        }
    }

    /**
     * This is the method where most of the game happens.
     * It shows who's turn it is to play, witch round it is, shows the options the players have,
     * prints the animals every player own and info about them, prints how much food the player owns, and at the end
     * it calculates the end result and displays the winner.
     */
    public void mainMenu() {
        for (int i = loadedRound; i <= rounds; i++) {
            System.out.println("\n".repeat(20));
            System.out.println("Runda: " + currentRound++);
            for (Player player : players) {
                String activePlayer = player.getName();
                System.out.println("-".repeat(50));
                System.out.println(player.getName() + "s" + " djur: ");
                player.getAnimals();
                System.out.println("-".repeat(50));
                System.out.println(activePlayer + " det är din tur!" + "\n" + "Pengar: " + player.getMoney() + "Kr"
                        + " | " + "Gräs: " + player.getGrass() + "kg" + " | " + "Hö: " + player.getHay() + "kg" + " | " + "Foder: " + player.getCattleFood() + "kg" + "\n");
                menuOptions.printMainMenu();
                int mainOptions = Integer.parseInt(console.nextLine());
                System.out.println("-".repeat(50));
                switch (mainOptions) {
                    case 1:
                        //Köp djur
                        //Klar
                        this.store = new Store(player);
                        System.out.println("Välkommen till djuraffären! ");
                        System.out.println("Här köper du djur, se alternativen nedan.");
                        store.buyAnimalMenu();
                        break;
                    case 2:
                        //Köp mat
                        //Klar
                        System.out.println("Välkommen till djuraffären! ");
                        System.out.println("Här köper du mat till djuren, se alternativen nedan.");
                        this.store = new Store(player);
                        store.buyAnimalFood();
                        break;
                    case 3:
                        //Mata djur
                        //Klar
                        player.feedAnimals();
                        break;
                    case 4:
                        //Para djur
                        //klar
                        player.mateTheAnimals();
                        break;
                    case 5:
                        //Sälj djur
                        //Klar
                        this.store = new Store(player);
                        store.sellAnimal();
                        break;
                    case 6:
                        //Spara spel
                        //klar
                        saveGameAndExit(i);
                        System.out.println("Spelet avslutas... ");
                        System.exit(0);
                        break;
                }
                player.animalHealthDecrease();
                if (i == (rounds - 1)) {
                    for (Animal animal : player.animalsList) {
                        System.out.println(animal.getAnimalType());
                        store.sellAllAnimals(animal.getAnimalType(), animal.getHealth());
                    }
                }
            }
        }
    }

}


