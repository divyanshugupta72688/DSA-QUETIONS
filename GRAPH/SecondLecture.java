import java.util.*;
import java.util.LinkedList;
class SecondLecture{
    
    
    // number of connected component
    
    
        public int ConnectedComponent(int V,ArrayList<ArrayList<Integer>>graph){
    boolean[] visited = new boolean[V];
    int count = 0;
    for(int i = 0;i<V;i++){
        if (!visited[i]) {
            dfs(i,graph,visited);
            count++;
        }
    }
    return count;
}
        public void dfs(int node,ArrayList<ArrayList<Integer>>graph,boolean[] visited){
            visited[node] = true;
            for (int neighbour : graph.get(node)) {
                if (!visited[neighbour]) {
                    dfs(neighbour, graph, visited);
                }
            }
        }



            // cycyle detection in graph using DFS

            public boolean CycleDetection(int V,ArrayList<ArrayList<Integer>>adj){
                boolean[]visited = new boolean[V];
                for (int i = 0; i < V; i++) {
                    if (!visited[i]) {
                        if (helper(i,-1,adj,visited)) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public boolean helper(int  node ,int parant,ArrayList<ArrayList<Integer>>adj,boolean[]visited){
                visited[node] = true;
                for (int neighbour : adj.get(node)) {
                    if (!visited[neighbour]) {
                        if (helper(neighbour, node, adj, visited)) {
                            return true;
                        }
                    }else if (neighbour != parant) {
                        return true;
                    }
                }
                return false;
            }

    
            // biprate graph


            public boolean isBipartite(int[][]graph){
                int n = graph.length;
                int[]color = new int[n];
                for(int i = 0;i<color.length;i++){
                    color[i] = -1;
                }
                for(int i = 0;i<n;i++){
                    if (color[i]==-1) {
                        if (!bfs(i,graph,color)) {
                            return false;
                        }
                    }
                }
                return true;
            }
                public boolean bfs(int start,int[][]graph,int[]color){
                    Queue<Integer>q = new LinkedList<>();
                    q.add(start);
                    color[start] = 1;
                    while (!q.isEmpty()) {
                        int node = q.remove();
                        for(int neighbour: graph[node]){
                            if (color[neighbour]==-1) {
                                color[neighbour] = 1- color[node];
                                q.add(neighbour);
                            }else if (color[neighbour]==color[node]) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
    
        }