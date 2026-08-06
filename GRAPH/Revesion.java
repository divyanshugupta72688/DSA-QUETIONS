import java.util.*;
import java.util.LinkedList;

public class Revesion {

    // AJDACENCY LIST GRAPH KE LIYE

    public ArrayList<ArrayList<Integer>> list(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        return adj;
    }

    // DFS

    public void dfs(int start, ArrayList<ArrayList<Integer>> adj, int V, boolean[] visited) {

        visited[start] = true;
        for (int neighbour : adj.get(start)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adj, V, visited);
            }
        }
    }

    // BFS

    public void bfs(int start, ArrayList<ArrayList<Integer>> adj, int V) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int node = q.remove();
            System.out.println(node);
            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }

    // path exists or not

    class PathExists {
        public boolean Path(int V, int source, int destination, ArrayList<ArrayList<Integer>> adj) {
            boolean[] visited = new boolean[V];
            return PathUtil(source, destination, adj, visited);
        }

        public boolean PathUtil(int start, int destination, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
            if (start == destination) {
                return true;
            }
            visited[start] = true;
            for (int neighbour : adj.get(start)) {
                if (!visited[neighbour]) {
                    if (PathUtil(neighbour, destination, adj, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

    }

    // count component of graph

    class CountGraphComponent {

        public int Count(ArrayList<ArrayList<Integer>> adj, int V) {
            int count = 0;
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    CountUtil(adj, i, visited);
                    count++;
                }
            }
            return count;
        }

        public void CountUtil(ArrayList<ArrayList<Integer>> adj, int start, boolean[] visited) {
            visited[start] = true;
            for (int neighbour : adj.get(start)) {
                if (!visited[neighbour]) {
                    CountUtil(adj, neighbour, visited);
                }
            }
        }
    }

    // DETECT CYCLE OF GRAPH USING DFS for undirected graph

    class Detect {
        public boolean CycleOrNot(int V, ArrayList<ArrayList<Integer>> adj) {
            boolean[] vis = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!vis[i]) {
                    if (CycleOrNotUtil(i, -1, adj, vis)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean CycleOrNotUtil(int start, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
            vis[start] = true;
            for (int neighbour : adj.get(start)) {
                if (!vis[neighbour]) {
                    if (CycleOrNotUtil(neighbour, start, adj, vis)) {
                        return true;
                    }
                } else if (neighbour != parent) {
                    return true;
                }
            }
            return false;
        }
    }

    // GRAPH IS BIPARTITE OR NOT

    class Bipartite {

        public boolean CheckBipartite(int[][] graph) {
            int n = graph.length;
            int[] color = new int[n];
            for (int i = 0; i < n; i++) {
                color[i] = -1;
            }
            for (int i = 0; i < n; i++) {
                if (color[i] == -1) {
                    if (!ChechBipartiteUtil(i, graph, color)) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean ChechBipartiteUtil(int start, int[][] graph, int[] color) {
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
    }

    // TOPOSORTING USING DFS

    class TopoSort {
        public ArrayList<Integer> TopoSorting(ArrayList<ArrayList<Integer>> adj, int V) {
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    TopoSortingUtil(i, adj, visited, stack);
                }
            }
            ArrayList<Integer> ans = new ArrayList<>();
            while (!stack.isEmpty()) {
                ans.add(stack.pop());
            }
            return ans;
        }

        public void TopoSortingUtil(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
                Stack<Integer> stack) {
            visited[start] = true;
            for (int neighbour : adj.get(start)) {
                if (!visited[neighbour]) {
                    TopoSortingUtil(neighbour, adj, visited, stack);
                }
            }
            stack.push(start);
        }
    }

    // FLOOD FILL (33)

    class floodFill {

        int rows;
        int colns;

        public int[][] Flood(int[][] image, int sr, int sc, int color) {
            rows = image.length;
            colns = image[0].length;
            int currcolor = image[sr][sc];
            if (currcolor == color) {
                return image;
            }
            boolean[][] visited = new boolean[rows][colns];
            FloodUtil(sr, sc, image, color, currcolor, visited);
            return image;
        }

        public void FloodUtil(int row, int coln, int[][] image, int color, int currcolor, boolean[][] visited) {
            if (row < 0 || row >= rows || coln < 0 || coln >= colns) {
                return;
            }
            if (image[row][coln] != currcolor) {
                return;
            }
            if (visited[row][coln] == true) {
                return;
            }
            visited[row][coln] = true;
            image[row][coln] = color;
            FloodUtil(row - 1, coln, image, color, currcolor, visited);
            FloodUtil(row + 1, coln, image, color, currcolor, visited);
            FloodUtil(row, coln - 1, image, color, currcolor, visited);
            FloodUtil(row, coln + 1, image, color, currcolor, visited);
        }
    }

}
