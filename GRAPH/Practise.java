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

        return DFS(adj, vis, source, dest);
    }

    public boolean DFS(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int start, int dest) {
        if (start == dest) {
            return true;
        }
        vis[start] = true;
        for (int neighbour : adj.get(start)) {
            if (!vis[neighbour]) {
                if (DFS(adj, vis, neighbour, dest)) {
                    return true;
                }
            }
        }
        return false;
    }

    // COUNT THE COMPONENT OF GRAPH

    public int Component(int V, ArrayList<ArrayList<Integer>> graph) {
        boolean[] vis = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                helper(i, graph, vis);
                count++;
            }
        }
        return count;
    }

    public void helper(int start, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        vis[start] = true;
        for (int neighbour : graph.get(start)) {
            if (!vis[neighbour]) {
                helper(neighbour, graph, vis);
            }
        }
    }

    // cycle detection using DFS for undirected graph

    public boolean cycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (helper2(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper2(int start, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {

        visited[start] = true;
        for (int neighbour : adj.get(start)) {
            if (!visited[neighbour]) {
                if (helper2(neighbour, start, visited, adj)) {
                    return true;
                }
            } else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }

    // CHECK GRAPH IS BIPRATE OR NOT

    public boolean IsBiptrate(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfs(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(int start, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            for (int neighbour : graph[node]) {
                if (color[neighbour] == -1) {
                    color[neighbour] = 1 - color[node];
                    q.add(neighbour);
                } else if (color[neighbour] == color[node]) {
                    return false;
                }
            }

        }
        return true;
    }


    public ArrayList<Integer>TopoSort(int V,ArrayList<ArrayList<Integer>>adj){
       Stack<Integer>s = new Stack<>();
        boolean[]visited = new boolean[V];
        for(int i = 0;i<V;i++){
            if (!visited[i]) {
                TopoSortUtil(i, adj,visited,s);
            }
        }
        ArrayList<Integer>ans = new ArrayList<>();
        while (!s.isEmpty()) {
            ans.add(s.pop());
        }
        return ans;
    }
    public void TopoSortUtil(int start,ArrayList<ArrayList<Integer>>adj,boolean[]visited,Stack<Integer>s){
        visited[start] = true;
        for(int neighbour:adj.get(start)){
            if (!visited[neighbour]) {
                TopoSortUtil(neighbour, adj, visited, s);
            }
        }
        s.push(start);
    }
}
