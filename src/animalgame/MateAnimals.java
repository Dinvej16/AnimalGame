package animalgame;

import animalgame.animals.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MateAnimals implements Serializable {

    private Cow cow;
    private Horse horse;
    private Pig pig;
    private Goat goat;
    private Chicken chicken;


    public void CreateNewAnimals(Player player, Animal maleAnimal, Animal femaleAnimal) {
        Scanner console = new Scanner(System.in);

        if (Objects.equals(maleAnimal.getAnimalType(), femaleAnimal.getAnimalType())) {
            if (femaleAnimal.getGender().equalsIgnoreCase("Hona")) {
                Random random = new Random();
                int choice = random.nextInt(2) + 1;
                switch (choice) {
                    case 1:
                        System.out.println("Tyvärr, inga nya djur...");
                        break;
                    case 2:
                        int choiceTwo = random.nextInt(2) + 1;
                        switch (choiceTwo) {
                            case 1:
                                String type = maleAnimal.getAnimalType();
                                switch (type) {
                                    case "Ko":
                                        System.out.println("Det blev en hane!");
                                        System.out.println("Vad ska han han heta?");
                                        String cowMale = console.nextLine();
                                        cow = new Cow(cowMale);
                                        cow.setGender("Hane");
                                        cow.setType(type);
                                        player.addAnimalToList(cow);
                                        break;

                                    case "Häst":
                                        System.out.println("Det blev en hane!");
                                        System.out.println("Vad ska han han heta?");
                                        String horseMale = console.nextLine();
                                        horse = new Horse(horseMale);
                                        horse.setGender("Hane");
                                        horse.setType(type);
                                        player.addAnimalToList(horse);
                                        break;

                                    case "Gris":
                                        System.out.println("Det blev en hane!");
                                        System.out.println("Vad ska han han heta?");
                                        String pigMale = console.nextLine();
                                        pig = new Pig(pigMale);
                                        pig.setGender("Hane");
                                        pig.setType(type);
                                        player.addAnimalToList(pig);
                                        break;

                                    case "Get":
                                        System.out.println("Det blev en hane!");
                                        System.out.println("Vad ska han han heta?");
                                        String goatMale = console.nextLine();
                                        goat = new Goat(goatMale);
                                        goat.setGender("Hane");
                                        goat.setType(type);
                                        player.addAnimalToList(goat);
                                        break;

                                    case "Kyckling":
                                        System.out.println("Det blev en hane!");
                                        System.out.println("Vad ska han han heta?");
                                        String chickenMale = console.nextLine();
                                        chicken = new Chicken(chickenMale);
                                        chicken.setGender("Hane");
                                        chicken.setType(type);
                                        player.addAnimalToList(chicken);
                                        break;
                                }
                                break;

                            case 2:
                                String type2 = femaleAnimal.getAnimalType();
                                switch (type2) {
                                    case "Ko":
                                        System.out.println("Det blev en hona!");
                                        System.out.println("Vad ska han hon heta?");
                                        String cowFemale = console.nextLine();
                                        cow = new Cow(cowFemale);
                                        cow.setGender("Hona");
                                        cow.setType(type2);
                                        player.addAnimalToList(cow);
                                        break;

                                    case "Häst":
                                        System.out.println("Det blev en hona!");
                                        System.out.println("Vad ska han hon heta?");
                                        String horseFemale = console.nextLine();
                                        horse = new Horse(horseFemale);
                                        horse.setGender("Hona");
                                        horse.setType(type2);
                                        player.addAnimalToList(horse);
                                        break;

                                    case "Gris":
                                        System.out.println("Det blev en hona!");
                                        System.out.println("Vad ska han hon heta?");
                                        String pigFemale = console.nextLine();
                                        pig = new Pig(pigFemale);
                                        pig.setGender("Hona");
                                        pig.setType(type2);
                                        player.addAnimalToList(pig);
                                        break;

                                    case "Get":
                                        System.out.println("Det blev en hona!");
                                        System.out.println("Vad ska han hon heta?");
                                        String goatFemale = console.nextLine();
                                        goat = new Goat(goatFemale);
                                        goat.setGender("Hona");
                                        goat.setType(type2);
                                        player.addAnimalToList(goat);
                                        break;

                                    case "Kyckling":
                                        System.out.println("Det blev en hona!");
                                        System.out.println("Vad ska han hon heta?");
                                        String chickenFemale = console.nextLine();
                                        chicken = new Chicken(chickenFemale);
                                        chicken.setGender("Hona");
                                        chicken.setType(type2);
                                        player.addAnimalToList(chicken);
                                        break;
                                        }
                                }
                                break;

                }
            }
        }

    }
}
