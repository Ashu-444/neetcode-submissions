class Solution {
    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++){
            if(grid[i][0] == 'O'){
                dfs(i , 0 , grid);
            }
            if(grid[i][m-1] == 'O'){
                dfs(i , m-1 , grid);
            }
        }
        for(int j = 0; j < m; j++){
           if(grid[0][j] == 'O'){
                dfs(0 , j , grid);
            }
            if(grid[n-1][j] == 'O'){
                dfs(n-1 , j , grid);
            } 
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                }
                else if(grid[i][j] == '#'){
                    grid[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(int i , int j , char[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 'O'){
            return;
        }

        grid[i][j] = '#';

        dfs(i-1 , j , grid);
        dfs(i+1 , j , grid);
        dfs(i , j-1 , grid);
        dfs(i , j+1 , grid);
    }
}
