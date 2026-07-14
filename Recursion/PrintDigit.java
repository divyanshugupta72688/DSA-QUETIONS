public class PrintDigit {
    static void Print(int n){
        // BASE CASE
        if (n==0) {
            return;
        }
        // PROCESSSING WORK
        int digit  = n%10;
        
        Print(n/10);
          System.out.println(digit);
    }
    public static void main(String[] args) {
        int n = 137;
        Print(n);
    }
}
