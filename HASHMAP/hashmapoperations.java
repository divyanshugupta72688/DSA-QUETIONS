import java.util.*;
public class hashmapoperations{
    public static void main(String[] args) {
        HashMap<String,Integer>hm = new HashMap<>();
       // put operations

        hm.put("india", 150);
        hm.put("China", 100);
        System.out.println(hm);

        // GET OPERATION

        Integer population = hm.get("india");
        System.out.println(population);// gives 150 as a output.
        System.out.println(hm.get("indonasia"));// it gives null as a output.

        /*PUT OPERATIONS */


            System.out.println(hm.containsKey("india"));// gives true as a output

            /*remove operations */
            System.out.println(hm.remove("China"));
            System.out.println(hm);
    
        }

}