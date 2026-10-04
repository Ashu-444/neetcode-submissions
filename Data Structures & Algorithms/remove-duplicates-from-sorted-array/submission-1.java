class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 0;
        for(int i = 0; i < n; i++){
            boolean d = false;
            for(int j = i +1; j < n; j++){
                if(nums[i] == nums[j]){
                    d = true;
                    break;
                }
            }
            if(!d){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}