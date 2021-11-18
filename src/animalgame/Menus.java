package animalgame;

/**
 * This is the Menus Class where we store different kind of menus to print.
 * @author Dino Vejzovic, Carl Lander, Perin Koriea
 */

public class Menus {


    public void printMainMenu(){
        System.out.println("1.Köp djur, 2.Köp mat, 3.Mata djur, 4.Para djur, 5.Sälj djur, 6.Spara spel ");
        System.out.print("Mata in en siffra för att göra ett val: ");
    }
    public void printAnimalMenu(){
        System.out.println("1.Ko, 2.Häst, 3.Gris, 4.Get, 5.Kyckling ");
        System.out.print("Mata in en siffra för att göra ett val: ");
    }
    public void printAnimalPriceMenu(){
        System.out.println("1.Ko [200kr], 2.Häst [150kr], 3.Gris [100kr], 4.Get [80kr], 5.Kyckling [50kr] ");
        System.out.print("Mata in en siffra för att göra ett val: ");

    }

    public void printFoodMenu(){
        System.out.println("1.Hö, 2.Gräs, 3.Foder ");
        System.out.print("Mata in en siffra för att göra ett val: ");
    }
    public void printFoodPriceMenu(){
        System.out.println("1.Hö [100kr/kg], 2.Gräs [80kr/kg], 3.Foder [50kr/kg]");
        System.out.print("Mata in en siffra för att göra ett val: ");

    }
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
