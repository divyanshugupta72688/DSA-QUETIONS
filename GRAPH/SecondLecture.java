import java.util.*;
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

    }