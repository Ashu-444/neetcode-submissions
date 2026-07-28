class Solution {
    public int carFleet(int t, int[] pos, int[] spd) {
        int n = pos.length;
        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++){
            pairs[i][0] = pos[i];
            pairs[i][1] = spd[i];
        }
        Arrays.sort(pairs , (a , b) -> b[0] - a[0]);
        int carfleet = 0;
        double prev = -1;
        
        for(int i = 0; i < n; i++){
            int p = pairs[i][0];
            int s = pairs[i][1];
            double curr = (double)(t - p)/s;

            if(curr > prev){
                carfleet++;
                prev = curr;
            }
        }
        return carfleet;
    }
}
