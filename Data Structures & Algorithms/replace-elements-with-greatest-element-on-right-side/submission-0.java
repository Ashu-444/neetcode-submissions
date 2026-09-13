class Solution {
    public int[] replaceElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            int maxi = -1;
            for(int j = i+1; j < n; j++){
                maxi = Math.max(maxi , nums[j]);
            }
            ans[i] = maxi;
        }
        return ans;
    }
}