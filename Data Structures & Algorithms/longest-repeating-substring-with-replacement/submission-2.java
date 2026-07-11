class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxlen = 0 , maxfre = 0 , l = 0 , r = 0;
        int[] hash = new int[26];
        while(r < n){
            hash[s.charAt(r) - 'A']++;
            maxfre = Math.max(maxfre , hash[s.charAt(r) - 'A']);
            if((r - l + 1) - maxfre > k){
                hash[s.charAt(l) - 'A']--;
                l++;
            }
            if((r - l + 1) - maxfre <= k){
                maxlen = Math.max(maxlen , r - l + 1);
            }
            r++;
        }

        return maxlen;
    }    
}
