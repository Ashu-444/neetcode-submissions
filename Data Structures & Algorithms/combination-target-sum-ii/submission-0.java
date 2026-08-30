class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums , 0 , target , ds , ans);
        return ans;
    }
    public void helper(int[] nums , int ind , int target ,  List<Integer> ds , List<List<Integer>> ans){
       
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = ind; i < nums.length; i++){
            if(i > ind && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) break;
            ds.add(nums[i]);
            helper(nums , i + 1, target - nums[i] , ds , ans);
            ds.remove(ds.size() - 1);
        }
    }
}
