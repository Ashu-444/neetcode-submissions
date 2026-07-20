class Solution {
    public int[] twoSum(int[] nums, int tar) {
        int n = nums.length;
        int l = 0 , r = n - 1;
        while(r < n){
            int sum = nums[l] + nums[r];
            if(sum == tar){
                return new int[]{l + 1 , r + 1};
            }
            else if(sum < tar){
                l++;
            } else {
                r--;
            }
        }
        return new int[]{};
    }
}
