class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums , k) - helper(nums , k - 1);
    }
    private int helper(int[] nums , int k){
        if(k < 0) return 0;
        int n = nums.length;
        int l = 0 , r = 0 , count = 0;
        Map<Integer , Integer> map = new HashMap<>();
        while(r < n){
            map.put(nums[r] , map.getOrDefault(nums[r] , 0) + 1);

            while(map.size() > k){
                map.put(nums[l] , map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                }
                l++;
            }
            if(map.size() <= k){
                count += r - l + 1;
                r++;
            }
        } 
        return count;
    }
}