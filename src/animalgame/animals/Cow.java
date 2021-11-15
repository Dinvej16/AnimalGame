package animalgame.animals;

import AnimalGame.animals.Animal;

public class Cow extends Animal {

    public Cow(String name) {
        super( name);
        name = null;
        int age;


        Cow(String name, int age){
            this.name = name;
            this.age = age;
        }


        public String whatDoesTheAnimalDo() {
            system.out.prinln("The cow is eating");
        }


        public String whatDoesTheAnimalSay() {
            system.out.println( "The cow says Moo");
    }

}
