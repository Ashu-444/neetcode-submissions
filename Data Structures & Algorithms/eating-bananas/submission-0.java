class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int p : piles) high = Math.max(high , p);
        int ans = high;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(gethours(piles , mid) <= h){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private long gethours(int[] piles , int k){
        long hours = 0;
        for(int p : piles){
            hours += (p + k - 1) / k;
        }
        return hours;
    }
}
