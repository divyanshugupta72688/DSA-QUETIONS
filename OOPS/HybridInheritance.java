public class HybridInheritance {
    public static void main(String[] args) {

    }
}

// Java does not support multiple inheritance through classes
// because it can cause the Diamond Problem.

// The Diamond Problem occurs when a class inherits
// the same method from two parent classes,
// creating ambiguity about which method should be used.

/*
                     A
                   /   \
                  B     C
                   \   /
                     D

             This is called the Diamond Problem.
*/

// Multiple inheritance is possible through interfaces
// using the 'implements' keyword.