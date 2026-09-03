class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        return solve(0 , n , dp);
    }
    public int solve(int ind , int n , int[] dp){
        if(ind == n) return 1;
        if(ind > n) return 0;
        if(dp[ind] != -1) return dp[ind];
        return dp[ind] = solve(ind + 1 , n , dp) +
        solve(ind + 2 , n , dp);
    }
}
