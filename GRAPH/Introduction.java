

import java.util.*;

class Introduction {

    // FIND STAR OF A GRAPH

    public int Star(int[][] nums) {
        int totaledges = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v1 = nums[i][0];
            int v2 = nums[i][1];
            map.put(v1, map.getOrDefault(v1, 0) + 1);
            map.put(v2, map.getOrDefault(v2, 0) + 1);
            if (map.get(v1) == totaledges) {
                return v1;
            }
            if (map.get(v2) == totaledges) {
                return v2;
            }
        }
        return -1;
    }

    // following code shows how to store aadjacency list FOR UNDIRECTED GRAPH

    public ArrayList<ArrayList<Integer>> CreateGraph(int V, int[][] edges) {

        // Adjacency List banayi.
        // Bahar wali ArrayList vertices ko store karti hai.
        // Har vertex ke liye andar ek ArrayList hoti hai jo uske neighbours store karti
        // hai.
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

    static class Pair {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static ArrayList<ArrayList<Pair>> WeightedCreateGraph(int V, int[][] edges) {
        ArrayList<ArrayList<Pair>> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            res.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            res.get(u).add(new Pair(v, wt));
            res.get(v).add(new Pair(u, wt));
        }
        return res;
    }

// BFS KE LIYE IMPORTANT POINT =>

/* 1. SABSE PAHLE QUEUE BNATE AUR EK BOOLEAN VISIT ARRAY BNATE HAI USKE BAAD US QUEUE ME EK SOURCE ADD KRA DETE HAI 
2. USKE BAAD VISIT[SOURCE] = TRUE KRA LETE AFTER THAT WHILE LOOP CHALATE HAI JAB TAK Q EMPTY NAHI HO JATA 
3.USKE Q SE REMOVE KRTE HAI FRONT SE ELEMENT KO
4.US ELEMENT KO ADD KAR DETE HAI 
5. USKE BAAD NEIGHBOUR NIKALTE HAI USING adj.get(ELEMENT)
6. CHECH KARTE HAI KI PAAHLE TO VISIT NAHI KR CHUKA HAI VO NEIGHBOUR
7. AGAR NAHI KIYA HAI TO PAHLE VISIT KO TRUE KARTE HAI NEIGHBOUR KO ADD KARTE HAI QUEUE ME  
*/

// DFS KE LIYE IMPORTANT POINT => 

/*1.SABSE VIS[START] = TRUE KARTE HAI AFTER THAT
2.START KO PRINT KRAYENGE 
3.USKE BAAD NEIGHBOUR NIKALTE HAI USING adj.get(ELEMENT)
4. CHECH KARTE HAI KI PAAHLE TO VISIT NAHI KR CHUKA HAI VO NEIGHBOUR AGAR NAHI KIYA HAI TO RECURSIVE CALL LGA DENGE FUNCTION KO.
*/


    // BFS SEARCH

    public void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " "); // agar function bfs search print karwayega to  ek idx variable lekr use 0 se intiailize kr denge ans[idx++] = curr
            for (int neighbour : adj.get(curr)) {
                if (!vis[neighbour]) {
                    vis[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }

    }


    // DFS KA CODE

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

    vis[node] = true;

    System.out.print(node + " ");

    for (int neighbour : adj.get(node)) {

        if (!vis[neighbour]) {

            dfs(neighbour, adj, vis);
        }
    }
}

// HAS PATH EXISTS FROM SOURCE TO DESTINATION

class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        return dfs(graph, visited, source, destination);
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> graph,
                       boolean[] visited,
                       int node,
                       int destination) {

        if (node == destination)
            return true;

        visited[node] = true;

        for (int neighbour : graph.get(node)) {

            if (!visited[neighbour]) {

                if (dfs(graph, visited, neighbour, destination))
                    return true;
            }
        }

        return false;
    }
}



}
