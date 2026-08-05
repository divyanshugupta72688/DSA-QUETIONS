public class MethodOverriding {
    public static void main(String[] args) {
        Animal d = new Dear();
        d.eat();

    }
}

class Animal{
    void eat(){
        System.out.println("eats anything");
    }
}

class Dear extends Animal{
   void eat(){
    System.out.println("eats grass");
   }
}
