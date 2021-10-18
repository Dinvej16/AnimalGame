package AnimalGame;

import java.util.Scanner;

public class Game {
    public boolean isRunning = true;
    private player;
    private Scanner scanner;

    public Game(){
        player = new User();
        scanner = new Scanner(System.in);
        start();
    }

    public void start(){
        isRunning = true;
        System.out.println("Välkommen till spelet");
        Player.setName(scanner.nextLine());
        menu();
    }


    private void menu() {
        Scanner choice = new Scanner(System.in);
        System.out.println("1. Hur många rundor vill du spela? 2. Hur många spelare? 3. Starta spelet!");
        int val = choice.nextInt();
        switch (val) {
            case 1:

                break;
            case 2:

                break;
            case 3:
                System.out.println("Spelet avslutat");
                System.exit(0);
                break;
        }
    }
}


