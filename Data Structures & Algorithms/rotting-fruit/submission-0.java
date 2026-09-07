class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i , j , 0});
                    vis[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();

            int i = curr[0];
            int j = curr[1];
            int time = curr[2];

            ans = Math.max(ans , time);

            if(i-1 >= 0 && !vis[i-1][j] && grid[i-1][j] == 1){ // top
                q.add(new int[]{i-1 , j , time+1});
                vis[i-1][j] = true;
            }

            if(i+1 < n && !vis[i+1][j] && grid[i+1][j] == 1){ // bottom
                q.add(new int[]{i+1 , j , time+1});
                vis[i+1][j] = true;
            }

            if(j-1 >= 0 && !vis[i][j-1] && grid[i][j-1] == 1){ // left
                q.add(new int[]{i , j-1 , time+1});
                vis[i][j-1] = true;
            }

            if(j+1 < m && !vis[i][j+1] && grid[i][j+1] == 1){ // right
                q.add(new int[]{i , j+1 , time+1});
                vis[i][j+1] = true;
            }
        }
        // for checking if any fresh(1) Oranges is here return -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    return -1;
                }
            }
        }
        return ans;
    }
}
