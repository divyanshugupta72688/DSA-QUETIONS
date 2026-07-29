package GRAPH;
import java.util.*;
class Introduction {
    
    // FIND STAR OF A GRAPH

    public int Star(int[][]nums){
        int totaledges = nums.length;
    HashMap<Integer,Integer>map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v1 = nums[i][0];
            int v2 = nums[i][1];
            map.put(v1, map.getOrDefault(v1, 0)+1);
             map.put(v2, map.getOrDefault(v2, 0)+1);
             if (map.get(v1)==totaledges) {
                return v1;
             }
             if (map.get(v2)==totaledges) {
                return v2;
             }
        }
        return -1;
    }
 
    
   
}
