import java.util.Scanner;

public class Introduction{
    public static void main(String[] args) {
     
        String str1 = "AyUsh Gupta";
        String str2 = "Ayush Gupta";
     //ACCESS
        System.out.println(str1.charAt(3));   

        // COMPARING STRING
        // first option .equals()

        System.out.println(str1.equals(str2));

        // second option .equalsIgnoreCase()

         System.out.println(str1.equalsIgnoreCase(str2));


         // STRING INPUT - TWO OPTION
        // FIRST IS NEXT()

         Scanner sc = new Scanner(System.in);

         String firstName = sc.next();
         System.out.println(firstName);

        // Second IS nextLine()

        String lastName = sc.nextLine();
        System.out.println(lastName);



    }
}