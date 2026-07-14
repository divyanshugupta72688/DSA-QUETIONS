import java.util.*;

public class Operation {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        hs.add(3);
        hs.add(5);
        hs.add(1);
        hs.add(3);
        System.out.println(hs);
        System.out.println(hs.size());
        hs.clear();
        System.out.println(hs.size());
        System.out.println(hs.isEmpty());
    }
}