class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i , isConnected , vis , n);
                count++;
            }
        }
        return count;
    }
    void dfs(int node , int[][] isConnected , boolean[] vis , int n){
        vis[node] = true;
        for(int j = 0; j < n; j++){
            if(isConnected[node][j] == 1 && !vis[j]){
                dfs(j , isConnected , vis , n);
            }
        }
    }
}