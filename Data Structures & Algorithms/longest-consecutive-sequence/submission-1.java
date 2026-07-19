class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        for(int i = 0; i < n; i++){
            st.add(nums[i]);
        }  
        int res = 0;  
        for(int i = 0; i < n; i++){
            if(st.contains(nums[i]) && !st.contains(nums[i] - 1)){
                int count = 0;
                while(st.contains(nums[i])){
                    st.remove(nums[i]);
                    nums[i]++;
                    count++;
                }
                res = Math.max(res , count);
            }
        }
        return res;
    }
}
