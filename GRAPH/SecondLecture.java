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
}