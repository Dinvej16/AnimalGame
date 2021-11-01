package animalgame;

public class Menus {


    public void printMainMenu(){
        System.out.println("[Huvudmenyn]");
        System.out.println("1.Affären, 2.Gården, 3.Avsluta spel");
        System.out.println("Mata in en siffra för att göra ett val: ");
    }

    public void printStoreMenu(){
        System.out.println("[Affären]");
        System.out.println("1.Köp Djur, 2.Köp Mat, 3.Sälj Djur, 4.Gården, 5.Huvudmenyn ");
        System.out.println("Mata in en siffra för att göra ett val: ");
    }

    public void printAnimalMenu(){
        System.out.println("1.Ko, 2.Get, 3.Häst, 4.Gris, 5.Kyckling, 6.Tillbaka ");
        System.out.println("Mata in en siffra för att göra ett val: ");
    }

    public void printGenderMenu(){
        System.out.println("1.Hane, 2.Hona, 3.Tillbaka");
        System.out.println("Mata in en siffra för att göra ett val: ");
    }

    public void printFoodMenu(){
        System.out.println("1.Hö [10kr], 2.Gräs [20kr], 3.Foder [30kr], 4.Tillbaka");
        System.out.println("Mata in en siffra för att göra ett val: ");
    }

    public void printBarnMenu(){
        System.out.println("[Gården]");
        System.out.println("1.Mata Djur, 2.Para Djur, 3.Se dina Djur, 4.Affär, 5.Huvudmenyn ");
        System.out.println("Mata in en siffra för att göra ett val:");
    }

}
