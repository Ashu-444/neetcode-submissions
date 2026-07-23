class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
               profit = prices[j] - prices[i]; 
               max = Math.max(max , profit);   
            }
        }
        return max;
    }
}
