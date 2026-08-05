public class MultilevelInheritance {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();;
        d.legs = 4;

    }
}
//MULTILEVEL INHERITANCE

// BASE CLASS

class Animal{
    String color;
    void eat(){
        System.out.println("eat");
    }
    void breathe(){
        System.out.println("breathe");
    }
}

// DERIVED CLASS

class Memmal extends Animal {
    int legs;
}

// DERIVED CLASS

class Dog extends Memmal{
    String bread;
}
