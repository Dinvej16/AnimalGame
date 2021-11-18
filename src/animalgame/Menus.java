package animalgame;

/**
 * This is the Menus Class where we store different kind of menus to print.
 * @author Dino Vejzovic, Carl Lander, Perin Koriea
 */

public class Menus {

    /**
     * Shows the options a player can choose between while it's their turn.
     */
    public void printMainMenu(){
        System.out.println("1.Köp djur, 2.Köp mat, 3.Mata djur, 4.Para djur, 5.Sälj djur, 6.Spara spel ");
        System.out.print("Mata in en siffra för att göra ett val: ");
    }


    /**
     * Shows the animals and the price of them.
     */
    public void printAnimalPriceMenu(){
        System.out.println("1.Ko [200kr], 2.Häst [150kr], 3.Gris [100kr], 4.Get [80kr], 5.Kyckling [50kr] ");
        System.out.print("Mata in en siffra för att göra ett val: ");

    }

    /**
     * Shows the food and the price of each food.
     */
    public void printFoodPriceMenu(){
        System.out.println("1.Hö (Häst) [100kr/kg], 2.Gräs (Ko, Häst, Get) [80kr/kg], 3.Foder (Gris, Kyckling) [50kr/kg]");
        System.out.print("Mata in en siffra för att göra ett val: ");

    }
    /**
     * Shows some info about the game and some rules.
     */
    public void printRulesAndInfo(){
        System.out.println("""
                Info om AnimalGame: Spelet AnimalGame är ett sällskaps spel, (2-4) personer kan spela och 
                välja mellan (5-30) rundor. Varje spelare börjar med 1000kr som ska används till att köpa djur 
                och köpa mat till djuren. Spelarna kan även sälja sina djur men inte för samma summa som vid köp
                då priset är beroende av djurets liv. Efter varje runda så minskar djurens hälsa så glöm inte att mata dem.
                Spelarna kan även para sina djur om de har två olika kön av samma djurtyp, det är 50% chans att 
                parningen lyckas. När sista rundan är klar så säljs spelarnas djur automatiskt och spelaren med 
                mest pengar utses till vinnare. 
                
                Regler: Du som spelare måste vara noga med vilka val du gör i spelet. Väljer du på t.ex. "Mata djur" 
                och du inte har några tillgängliga djur så kommer spelet att låta nästa spelare att spela. Så tänk noga
                på valen du gör!!!""");
    }

}
