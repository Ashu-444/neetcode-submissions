class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        nQueens(board , 0 , n , ans);
        return ans;
    }
    void nQueens(char[][] board , int row , int n , List<List<String>> ans){
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                list.add(new String(board[i]));
            }
            ans.add(list);
            return;
        }
        for(int j = 0; j < n; j++){
            if(isSafe(board , row , j , n)){
               board[row][j] = 'Q';
               nQueens(board , row + 1 , n , ans);
               board[row][j] = '.';
            }
        }   
    }
    boolean isSafe(char[][] board , int row , int col , int n){
        // same col
        for(int i = 0; i < n; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // uper-left diagonal 
        for(int i = row - 1 , j = col - 1; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // upper-right diagonal
        for(int i = row - 1 , j = col + 1; i >= 0 && j < n; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
