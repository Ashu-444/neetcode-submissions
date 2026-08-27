class Solution {
    public int lastStoneWeight(int[] nums) {
        int n = nums.length;

        PriorityQueue<Integer> pq = 
        new PriorityQueue<>((a , b) -> Integer.compare(b , a));

        for(int i = 0; i < n; i++){
            pq.add(nums[i]);
        }    
        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();
            if(x != y) pq.add(x - y);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
