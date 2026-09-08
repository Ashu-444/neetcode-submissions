class Solution {
    public boolean canFinish(int V, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[V];
        
        for(int i = 0; i < V; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
        }
        
        boolean[] vis = new boolean[V];
        boolean[] recPath = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(i , adj , vis , recPath)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean dfs(int node , ArrayList<Integer>[] adj , boolean[] vis , boolean[] recPath){
    
        vis[node] = true;
        recPath[node] = true;
        
        for(int v : adj[node]){
            if(!vis[v]){
                if(dfs(v , adj , vis , recPath)){
                    return true;
                }
            } else if(recPath[v] == true){
                return true;
            }
        }
        recPath[node] = false;
        return false;
    }
    
}
