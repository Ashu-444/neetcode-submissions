class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        // boundary check for cols
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1){
                dfs(i , 0 , grid);
            }
            if(grid[i][m-1] == 1){
                dfs(i , m-1 , grid);
            }
        }
        // boundary check for rows
        for(int j = 0; j < m; j++){
            if(grid[0][j] == 1){
                dfs(0 , j , grid);
            }
            if(grid[n-1][j] == 1){
                dfs(n-1 , j , grid);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i , int j , int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 1){
            return;
        }
        grid[i][j] = 0;
        
        dfs(i-1 , j , grid);
        dfs(i+1 , j , grid);
        dfs(i , j-1 , grid);
        dfs(i , j+1 , grid);
    }
}