package animalgame;

import animalgame.animals.Animal;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Scanner console;

    private ArrayList<Player> players;
    private Player newPlayer;
    private int maxPlayers = 4;
    private int minPlayers = 2;

    private int rounds;
    private int loadedRound = 1; //
    private int maxRounds = 30;
    private int minRounds = 5;


    private Menus menuOptions;
    private Store store;


    // Konstruktor
    public Game() {
        this.console = new Scanner(System.in);
        this.menuOptions = new Menus();

        System.out.println("Välkommen till AnimalGame!");
        System.out.println("1.Nytt spel, 2.Ladda spel");
        System.out.print("Mata in en siffra för att göra ett val: ");
        int startMenuChoice = Integer.parseInt(console.nextLine());
        switch (startMenuChoice){
            case 1:
                System.out.println("\n".repeat(20));
                initPlayers();
                System.out.println("\n".repeat(20));
                initRounds();
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
        }
    }

    private void displayWinner(){
        int playerWinner = 0;
        String playerName = null;
        for (Player player : players){
            String activePlayer = player.getName();
            int currentMoney = player.getMoney();

            if (currentMoney > playerWinner){
                playerWinner = currentMoney;
                playerName = activePlayer;
            }
        }
        System.out.println("Vinnaren är: " + playerName);
    }
    private void calculateEndresult(){
        System.out.println("Antal spelare: " + players.size());
        System.out.println("-".repeat(50));
        for (Player player : players){
            String activePlayer = player.getName();
            System.out.println(activePlayer + " din totala summar blev " + player.getMoney() + "kr ");
            System.out.println("-".repeat(50));
        }
    }

    private void loadGame() {
        System.out.println("Choose file name to load: ");
        String fileName = console.nextLine();
        SavedGame savedGame = FileHandler.loadSavedGame(fileName);
        if (savedGame != null){
            this.players = savedGame.getPlayers();
            this.loadedRound = savedGame.getLastRoundPlayed();
            this.rounds = savedGame.getRounds();
        }
        else {
            System.out.println("Lämnar spelet...");
            System.exit(0);
        }

    }
    private void saveGameAndExit(int currentRound){
        System.out.println("Choose file name to save: ");
        String fileToSave = console.nextLine();

        SavedGame savedGame = new SavedGame(players, currentRound, rounds);
        FileHandler.saveGameRuntime(savedGame, fileToSave);

    }

    /**
     * Let user choose amount of rounds to play &
     * number of players in the game.
     * Also, let all players created have a chosen name
     */
    public void initRounds() {
        System.out.println("(5-30)");
        System.out.print("Ange antalet spelrundor: ");
        this.rounds = Integer.parseInt(console.nextLine());
        if (rounds > maxRounds) {
            System.out.println("Max antal rundor är 30! Försök igen... ");
            initRounds();
        } else if (rounds < minRounds) {
            System.out.println("Minst antal rundor är 5! Försök igen...");
            initRounds();
        }
    }

    public void initPlayers() {
        System.out.println("(2-4)");
        System.out.print("Ange antalet spelare: ");
        this.players = new ArrayList<>();
        int playersToCreate = Integer.parseInt(console.nextLine());

        if (playersToCreate > maxPlayers) {
            System.out.println("Max antal spelare som kan spela är 4! Försök igen...");
            initPlayers();

        } else if (playersToCreate < minPlayers) {
            System.out.println("Minst antal spelare som kan spela är 2! Försök igen...");
            initPlayers();
        }
        else {
            for (int i = 0; i < playersToCreate; i++) {
                System.out.println("-".repeat(50));
                System.out.println("Ange namn för spelare " + (i + 1));
                String nameChoice = console.nextLine();
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
        for (int i = loadedRound; i <= rounds; i++) {
            for (Player player : players) {
                String activePlayer = player.getName();
                System.out.println("-".repeat(50));
                System.out.println(player.getName() + "s" + " djur: ");

                player.getAnimals();
                System.out.println("-".repeat(50));
                System.out.println(activePlayer + " det är din tur!" + "\n" + "Pengar: " + player.getMoney() + "Kr"
                        + " | " + "Gräs: " + player.getGrass() + "kg" +" | " + "Hö: "+ player.getHay()+ "kg" + " | " + "Foder: "+ player.getCattleFood() + "kg" + "\n");
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
                        player.mateTheAnimals();
                        break;
                    case 5:
                        //Sälj djur
                        System.out.println("Välkommen till djuraffären! ");
                        System.out.println("I denna delen säljer du djur, se alternativen nedan.");
                        this.store = new Store(player);
                        store.sellAnimal();
                        break;
                    case 6:
                        //Spara spel
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


