class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> de = new ArrayDeque<>();
        int ind = 0;
        for(int i = 0; i < n; i++){
            // 1. Window se chote elements remove karo
            while(!de.isEmpty() && nums[de.peekLast()] <= nums[i]){
                de.removeLast();
            }
            // 2. Current index add karo
            de.addLast(i);

            // 3. Window ke bahar wale index remove karo
            if(de.peekFirst() <= i - k){
                de.removeFirst();
            }

            // 4. Window complete hone ke baad answer store karo
            if(i >= k - 1){
                ans[ind++] = nums[de.peekFirst()];
            }
        }    
        return ans;
    }
}
