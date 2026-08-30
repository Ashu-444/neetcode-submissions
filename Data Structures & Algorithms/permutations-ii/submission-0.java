class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums , 0 , ans);
        return ans;
    }
    public void helper(int[] nums , int ind , List<List<Integer>> ans){
        if(ind == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = ind; i < nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            swap(i , ind , nums);
            helper(nums , ind + 1 , ans);
            swap(i , ind , nums);
        }
    }
    public void swap(int i , int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}