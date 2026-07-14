public class practise {

// print digit of a number

    public static void printdigit(int num){
        while (num!=0) {
            int digit = num%10;
            System.out.println(digit);
            num = num/10;
        }
    }

    // print count of a digit

    public static int count(int num){
        int count = 0;
        while (num!=0) {
            count++;
            num = num /10;
        }
        return count;
    }

    // PRINT REVERSE OF A NUMBER

    public static int reverse(int num){
        int ans = 0;
        while (num!=0) {
            int digit = num%10;
            ans = ans*10 +digit;
            num = num/10;
        }
        return ans;
    }

    // TO CHECK GIVEN NUMBER IS A PALINROME OR NOT.

    public static boolean palindrome(int num){
        int originalNumber = num;
        int reverseNumber = reverse(num);
        if (originalNumber == reverseNumber) {
            return true;
        }
        return false;
    }


    // TO CHECK GIVEN NUMBER IS A PRIME NUMBER OR NOT.

    public static boolean prime(int num){
        for(int i =2;i<num-1;i++){
            if (num%i==0) {
                return false;
            }
        }
        return true;
    }

    // THIS FUNCTION IS USED TO FINDOUT GCD OF A GIVEN NUMBER .

    public static int getgcd(int a, int b){
        while (b!=0) {
            int oldValueOfb = b;
            b = a%b;
            a=oldValueOfb;
        }
        int ans = a;
        return ans;
    }

        // THIS FUNCTION IS USED TO FINDOUT LCM OF A GIVEN NUMBER .

    public static int lcm(int a, int b){
        int gcd = getgcd(a, b);
        int product = a*b;
        int l = product/gcd;
        return l;
    }
}
