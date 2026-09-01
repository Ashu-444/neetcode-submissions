class Solution {
    public boolean exist(char[][] mat, String word) { 
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(f(mat , word , i , j , 0)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean f(char[][] mat , String word , int i , int j , int ind){
        if(ind == word.length()){
            return true;
        }
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] != word.charAt(ind)){
            return false;
        }
        char ch = mat[i][j];
        mat[i][j] = '#'; // visited
        boolean ans = f(mat , word , i+1 , j , ind + 1)||
                      f(mat , word , i-1 , j , ind + 1)||
                      f(mat , word , i , j+1 , ind + 1)||
                      f(mat , word , i , j-1 , ind + 1);

        mat[i][j] = ch;

        return ans;              
    }
}
