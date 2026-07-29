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
 
    // following code shows how to store aadjacency list

    public ArrayList<ArrayList<Integer>> CreateGraph(int V, int[][] edges) {

    // Adjacency List banayi.
    // Bahar wali ArrayList vertices ko store karti hai.
    // Har vertex ke liye andar ek ArrayList hoti hai jo uske neighbours store karti hai.
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    // Har vertex ke liye ek empty neighbour list banao.
    for (int i = 0; i < V; i++) {
        adj.add(new ArrayList<>());
    }

    // Har edge ko traverse karo.
    for (int[] edge : edges) {

        // Edge ke dono vertices nikalo.
        int u = edge[0];
        int v = edge[1];

        // u ki neighbour list me v add karo.
        adj.get(u).add(v);

        // Agar graph undirected hai to v ki neighbour list me bhi u add karo.
        adj.get(v).add(u);
    }

    return adj;
}


// jab graph ka weight diye ho graph undirected ho 

static class Pair{
    int node;
    int weight;
    public Pair(int node,int weight){
        this.node = node;
        this.weight = weight;
    }
}
public  static ArrayList<ArrayList<Pair>> WeightedCreateGraph(int V,int[][]edges){
    ArrayList<ArrayList<Pair>>res = new ArrayList<>();
    for (int i = 0; i < V; i++) {
        res.add(new ArrayList<>());
    }
    for (int[]edge : edges) {
        int u = edge[0];
        int v = edge[1];
        int wt = edge[2];
        res.get(u).add(new Pair(v, wt));
        res.get(v).add(new Pair(u, wt));
    }
    return res;
}
}
