import java.util.*;

public class Xyz {

    public static void mod(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int maxFreq = 0;
        int maxElement = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxElement = entry.getKey();
            }
        }

        System.out.println("Element: " + maxElement);
        System.out.println("Frequency: " + maxFreq);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,1,1,2,3,4,5,6};
        mod(arr);
    }
}