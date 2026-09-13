class Solution {
    public int[] replaceElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int maxi = -1;
        for(int i = n-1; i >= 0; i--){
    
            ans[i] = maxi;
            maxi = Math.max(maxi , nums[i]);
        }
        return ans;
    }
}