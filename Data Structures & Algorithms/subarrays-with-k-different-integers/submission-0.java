class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int count = 0; 
        for(int i = 0; i < n; i++){
            Map<Integer , Integer> map = new HashMap<>();
            for(int j = i; j < n; j++){
                map.put(nums[j] , map.getOrDefault(nums[j] , 0 ) + 1);
                if(map.size() == k){
                    count++;
                } else if(map.size() > k){
                    break;
                }
            }
        }    
        return count;
    }
}