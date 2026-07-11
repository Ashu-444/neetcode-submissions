class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            int[] hash = new int[26];
            int maxfreq = 0; 
            for(int j = i; j < n; j++){
                hash[s.charAt(j) - 'A']++;

                maxfreq = Math.max(maxfreq , hash[s.charAt(j) - 'A']);

                int len = j - i + 1;
                int change = len - maxfreq;

                if(change <= k){
                    maxLen = Math.max(maxLen , len);
                }
            }
        }
        return maxLen;
    }
}
