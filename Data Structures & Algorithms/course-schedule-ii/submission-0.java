class Solution {
    public int[] findOrder(int V, int[][] edges) {
        
        ArrayList<Integer>[] adj = new ArrayList[V];
        
        for(int i = 0; i < V; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            adj[edge[1]].add(edge[0]);
        }
        
        boolean[] vis = new boolean[V];
        boolean[] recPath = new boolean[V];
        int[] ans = new int[V];
        // cycle detection 
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(isCycle(i , adj , vis , recPath)){
                    return new int[0];
                }
            }
        }

        Arrays.fill(vis , false);

        //topological sorted order 
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                topoSort(i , adj , vis , st);
            }
        }
        int ind = 0;
        while(!st.isEmpty()){
            ans[ind++] = st.pop();
        }
        return ans;
    }
    boolean isCycle(int node , ArrayList<Integer>[] adj , boolean[] vis , boolean[] recPath){
    
        vis[node] = true;
        recPath[node] = true;
        
        for(int v : adj[node]){
            if(!vis[v]){
                if(isCycle(v , adj , vis , recPath)){
                    return true;
                }
            } else if(recPath[v] == true){
                return true;
            }
        }
        recPath[node] = false;
        return false;
    }

    void topoSort(int node , ArrayList<Integer>[] adj , boolean[] vis , Stack<Integer> st){
        vis[node] = true;
        
        for(int v : adj[node]){
            if(!vis[v]){
                topoSort(v , adj , vis , st);
            }
        }
        st.push(node);
    }
}