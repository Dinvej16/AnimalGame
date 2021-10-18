package Animal;

public abstract class Animals {

        private boolean isAlive = true;
        private String name;
        private String gender;

        public Animals (String name, String gender){
            this.name = name;
            this.gender = gender;
        }

        public void eat(){
            System.out.println("I am eating");
        }

        public void sayHi(){
            System.out.println("Hello");
        }

        public void gotEaten(){
            isAlive = false;
        }

        public String getName() {
        return this.name;
        }


}
