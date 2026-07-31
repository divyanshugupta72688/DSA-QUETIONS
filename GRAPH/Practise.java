import java.util.*;
import java.util.LinkedList;

public class Practise {

    // find star of a graph

    public int Star(int[][] edges) {
        int totaledges = edges.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < totaledges; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            map.put(v1, map.getOrDefault(v1, 0) + 1);
            map.put(v2, map.getOrDefault(v2, 0) + 1);
            if (totaledges == map.get(v1)) {
                return v1;
            }
            if (totaledges == map.get(v2)) {
                return v2;
            }
        }
        return -1;
    }

    // ADJACENECY LIST FOR WIGHTED UNDRECTED GRAPH

    static class Pair {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public List<List<Pair>> adjacenecy(int V, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        return adj;
    }

    // BFS

    public void Bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        while (!q.isEmpty()) {
            int node = q.remove();
            System.out.println(node);
            for (int n : adj.get(node))
                if (!vis[n]) {
                    vis[n] = true;
                    q.add(n);
                }
        }
    }

    // DFS

    public void Dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[start] = true;
        for (int n : adj.get(start)) {
            if (!vis[n]) {
                Dfs(n, adj, vis);
            }
        }
    }

    
    // TO CHECK PATH IS EXISTS FROM SOURCE TO DESTINATION !
    
    public boolean PathExistsOrNot(int n, int[][] edges, int source, int dest) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

       return DFS(adj,vis,source,dest);
    }

    public boolean DFS( ArrayList<ArrayList<Integer>> adj,boolean[] vis, int start, int dest){
        if (start==dest) {
            return true;
        }
        vis[start] = true;
        for(int neighbour : adj.get(start)){
            if (!vis[neighbour]) {
                if (DFS(adj, vis, neighbour, dest)) {
                    return true;
                }
            }
        }
         return false;
    }


// COUNT THE COMPONENT OF GRAPH

public int Component(int V,ArrayList<ArrayList<Integer>>graph){
     boolean[] vis = new boolean[V];
     int count = 0;
     for(int i = 0;i<V;i++){
        if (!vis[i]) {
            helper(i,graph,vis);
            count++;
        }
     }
     return count;
}
 public void helper(int start,ArrayList<ArrayList<Integer>>graph,boolean[] vis){
    vis[start] = true;
    for(int neighbour : graph.get(start)){
        if (!vis[neighbour]) {
            helper(neighbour, graph, vis);
        }
    }
 }
}
