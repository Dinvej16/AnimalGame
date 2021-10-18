package Animal;

public abstract class Animals {

    public String name;
    public String gender;

}

        private boolean isAlive = true;
        private String name;

        public Animals(String name){
            this.name = name;
        }

        public void eat(){
            System.out.println("I am eating");
        }

        public void sayHi(){
            System.out.println("RAWR");
        }

        public void gotEaten(){
            isAlive = false;
        }

        public String myHealth(){
            return isAlive ? "My health is good, what about you?" : "I got eaten, not so funny";
        }

        public String getName(){
            return this.name;
        }
    }
>


