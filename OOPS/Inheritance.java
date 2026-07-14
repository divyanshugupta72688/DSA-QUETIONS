public class Inheritance {
    public static void main(String[] args) {
        Fish shark = new Fish();
        shark.eat();
    }
}

// BASE CLASS 
class Animal{
    String color;
    void eat(){
        System.out.println("eats");
    }
    void breathe(){
        System.out.println("breathes");
    }
}


//CHILD CLASS OR DERIVED CLASS

class Fish extends Animal{
    int fins;
   void swim(){
    System.out.println("swims");
   } 
}

