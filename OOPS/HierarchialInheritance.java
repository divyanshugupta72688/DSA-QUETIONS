public class HierarchialInheritance {
    public static void main(String[] args) {
        
    }
}

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

// derived class

class Mammal extends Animal{
    void walk(){
        System.out.println("walks");
    }
}

// derived class 
class Fish extends Animal{
    void swim(){
        System.out.println("swims");
    }
}


// derived class

class Bird extends Animal{
    void fly(){
        System.out.println("flies");
    }
}