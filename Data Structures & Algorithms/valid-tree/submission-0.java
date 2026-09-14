class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];

        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean[] vis = new boolean[n];

        if(dfs(0 , -1 , adj , vis)){
            return false; // cycle
        }
        // check connection
        for(boolean v : vis){
            if(!v) return false;
        }
        return true;
    }
    public boolean dfs(int node , int parent , List<Integer>[] adj , boolean[] vis){
        vis[node] = true;

        for(int neighbor : adj[node]){
            if(neighbor == parent) continue;

            if(vis[neighbor]) return true;

            if(dfs(neighbor , node , adj , vis)){
                return true;
            }
        }
        return false;
    }
}
