class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(nums , 0 , target , ds , ans);
        return ans;
    }
    public void helper(int[] nums , int ind , int target ,  List<Integer> ds , List<List<Integer>> ans){
        int n = nums.length;
        // base case 
        if(ind == n){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        // take
        if(nums[ind] <= target){
            ds.add(nums[ind]);
            helper(nums , ind , target - nums[ind] , ds , ans);
            ds.remove(ds.size() - 1);
        }
        // notTake
        helper(nums , ind + 1 , target , ds , ans);
    }
}
