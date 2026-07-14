import java.util.*;
public class Iteratehashmap {


    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};
        HashMap<Integer,Integer>map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        // for key
        for (Integer key : map.keySet()) {
            System.out.println("Keys are ->"+key);
        }
        for (Integer value : map.values()) {
            System.out.println("Values are ->"+value);
        }
    }
}
