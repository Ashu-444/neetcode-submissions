class Solution {
    int min = Integer.MAX_VALUE;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
       int[] dp = new int[n];
        Arrays.fill(dp , -1);
        return Math.min(solve(0 , n , cost , dp) ,
                        solve(1 , n , cost , dp));
    }
    public int solve(int ind , int n , int[] cost , int[] dp){
        if(ind >= n) return 0;
        
        if(dp[ind] != -1) return dp[ind];
    
        int step1 = solve(ind + 1 , n , cost , dp);
        int step2 = solve(ind + 2 , n , cost , dp);
       
       
        return dp[ind] = cost[ind] + Math.min(step1 , step2);
    } 
}
