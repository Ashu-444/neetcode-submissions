class Solution {
    void dfs(int[][] image, int i, int j, int newColor , int orgColor , int n , int m){
        if(i < 0 || j < 0 || i >= n || j >= m || image[i][j] != orgColor || image[i][j] == newColor){
            return;
        }

        image[i][j] = newColor;
        dfs(image , i-1 , j , newColor , orgColor , n , m); // top
        dfs(image , i+1 , j , newColor , orgColor, n , m); // bottom
        dfs(image , i , j-1 , newColor , orgColor, n , m);  // left 
        dfs(image , i , j+1 , newColor , orgColor, n , m);  // right
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        dfs(image , sr , sc , color , image[sr][sc] , n , m);
        return image;
    }
}