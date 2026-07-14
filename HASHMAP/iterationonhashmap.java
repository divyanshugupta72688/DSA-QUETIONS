import java.util.*;
public class iterationonhashmap {
    public static void main(String[] args) {
        HashMap<String,Integer>hm = new HashMap<>();
        hm.put("india", 150);
        hm.put("China", 100);
        hm.put("ShriLanka", 1226);
        Set<String> Keys = hm.keySet();
        for (String k : Keys) {
            System.out.println("Keys are :"+k + ",values are :"+hm.get(k));
        }
    }
}
