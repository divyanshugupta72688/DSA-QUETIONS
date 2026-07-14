public class javamethode {
    public static void main(String[] args) {
        // trim methode

        String str  = "Divyanshu Gupta ";
        str= str.trim();
        System.out.println(str.length());

        // .toLowerCase

        System.out.println(str.toLowerCase());

        //  toUpperCase

        System.out.println(str.toUpperCase());

        // substring

         System.out.println(str.substring(9, 15));
         
         // contains

         System.out.println(str.contains("ivy"));

        //toCharArray methode   

        char[] crr = str.toCharArray();
         for (char ch : crr) {
             System.out.println("value of ch :" + ch);
         }

        // split methode 

        String input = "my,name,is,divyanshu gupta";

        String[] str1 = input.split(",");
        for (String str2 : str1) {
            System.out.println(str2);
        }


    }
}
