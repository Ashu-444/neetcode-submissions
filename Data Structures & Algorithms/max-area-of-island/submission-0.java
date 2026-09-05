class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int area = dfs(i , j , grid , n , m);
                    maxArea = Math.max(maxArea , area);
                }
            }
        }
        return maxArea;
    }
    int dfs(int i , int j , int[][] grid , int n , int m){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;

        int area = 1;

        area += dfs(i+1 , j , grid , n , m); // bottom
        area += dfs(i-1 , j , grid , n , m); // top
        area += dfs(i , j+1, grid , n , m); // right
        area += dfs(i , j-1, grid , n , m); // left
        
        return area;
    }
}
