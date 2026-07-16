class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i]) == false){
                map.put(nums[i] , 1);
            } else {
                return true;
            }
        }    
        return false;
    }
}