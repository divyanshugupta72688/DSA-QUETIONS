public class Inheritance {
    public static void main(String[] args) {
        Fish shark = new Fish();
        shark.eat();
    }
}

// SINGLE LEVEL INHERITANCE

// BASE CLASS // PARENT CLASS

class Animal{
    String color;
    void eat(){
        System.out.println("eat");
    }
    void breathe(){
        System.out.println("breathes");
    }
}

// DERIVED CLASS // subclass

class Fish extends Animal{
    int fins;
    void swim(){
        System.out.println("Swiming");
    }
}