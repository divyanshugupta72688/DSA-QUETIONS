public class AbstractionClass {
    public static void main(String[] args) {
        Horse H = new Horse();
        H.eat();
        H.walk();
        Chiken  murga = new Chiken();
        murga.eat();
        murga.walk(); 
    }
}

abstract class Animal { // we can not create an objects for abstraction
    void eat() { // NON ABSTRACT METHOD
        System.out.println("Animal eats");
    }

    abstract void walk(); // it is ABSTRACT METHOD in this method we can not implement
}

class Horse extends Animal {
    void walk() {
        System.out.println("walk on 4 legs.");
    }
}

class Chiken extends Animal{
    void walk(){
        System.out.println("walks on 2 legs");
    }
}