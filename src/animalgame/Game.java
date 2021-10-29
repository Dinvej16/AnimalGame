package animalgame;


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


    // Konstruktor
    public Game(){
        this.console = new Scanner(System.in);
        this.menuOptions = new Menus();
        this.players = new ArrayList<>();
        this.newPlayer = new Player();
        System.out.println("Välkommen till AnimalGame! Tryck enter för att starta...");
        console.nextLine();
        initRounds();
        initPlayers();
        this.mainMenu();

        //
        //this.currentRound = 1;
        //while( currentRound <= gameRounds ){
            //playRound();
        }
    {
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
        menuOptions.printMainMenu();
        int mainMenuOptions = console.nextInt();
        switch (mainMenuOptions){
            case 1:
                this.storeMenu();
                break;
            case 2:
                this.barnMenu();
                break;
            default:
                System.out.println("Spelet avslutas...");
                break;
        }
    }
    public void storeMenu(){
        menuOptions.printStoreMenu();
        int storeOptions = console.nextInt();
        switch (storeOptions){
            case 1:
                System.out.println("Välj ett djur som du vill köpa:");
                this.animalMenu();
                break;
            case 2:
                System.out.println("Välj vilken mat du vill köpa:");
                this.foodMenu();
                break;
            case 3:
                System.out.println("Välj ett djur som du vill sälja:");
                this.animalMenu();
                break;
            case 4:
                System.out.println("Välj vilken mat du vill sälja:");
                break;
            case 5:
                this.barnMenu();
                break;
            case 6:
                this.mainMenu();
                break;
        }
    }
    public void barnMenu(){
        menuOptions.printBarnMenu();
        int barnOptions = console.nextInt();
        switch (barnOptions){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                this.storeMenu();
                break;
            case 5:
                this.mainMenu();
                break;
        }
    }

    public void animalMenu(){
        menuOptions.printAnimalMenu();
        int animalOptions = console.nextInt();
        switch (animalOptions){
            case 1:
                this.genderMenu();
                break;
            case 2:
                this.genderMenu();
                break;
            case 3:
                this.genderMenu();
                break;
            case 4:
                this.genderMenu();
                break;
            case 5:
                this.genderMenu();
                break;
            case 6:
                this.storeMenu();
                break;
        }
    }
    public void genderMenu(){
        menuOptions.printGenderMenu();
        int genderOptions = console.nextInt();
        switch (genderOptions){
            case 1:
                this.storeMenu();
                break;
            case 2:
                this.storeMenu();
                break;
            case 3:
                this.animalMenu();
                break;
        }
    }
    public void foodMenu(){
        menuOptions.printFoodMenu();
        int foodOptions = console.nextInt();
        switch (foodOptions){
            case 1:
                this.storeMenu();
                break;
            case 2:
                this.storeMenu();
                break;
            case 3:
                this.storeMenu();
                break;
            case 4:
                this.storeMenu();
                break;
        }
    }

}


