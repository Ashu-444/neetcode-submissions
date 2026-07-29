class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            int minh = h[i];
            for(int j = i; j < n; j++){
                minh = Math.min(minh , h[j]);
                int width = j - i + 1;
                int area = minh * width;
                max = Math.max(max , area);
            }
        }
        return max;
    }
}
