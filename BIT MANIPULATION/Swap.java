public class Swap {
    public static void Swapping(int a, int b){
       System.out.println("before swapping a : " + a + "b :" +b); 
        a = a ^b;
        b = a^b;
        a = a^b;



         System.out.println("After swapping a : " + a + "b :" +b); 
    }
    public static void main(String[] args) {
        int a  = 6;
        int b = 5;
        Swapping(a, b);
    }
}
