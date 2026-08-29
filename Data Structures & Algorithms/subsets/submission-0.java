class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(nums , 0 , list , ans);

        return ans;
    }
    public void helper(int[] nums , int ind ,  List<Integer> list , List<List<Integer>> ans){
        // base case
        if(ind == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        // take 
        list.add(nums[ind]);
        helper(nums , ind + 1 , list , ans);
        
        // remove
        list.remove(list.size() - 1);

        // notTake 
        helper(nums , ind + 1 , list , ans);
        
    }
}
