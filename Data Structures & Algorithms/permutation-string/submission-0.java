class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;

        int[] hash1 = new int[26];
        for(int i = 0; i < n; i++){
            hash1[s1.charAt(i) - 'a']++;
        }   
        // check every substring of length s1.length()
        for(int i = 0; i <= m - n; i++){

            int[] hash2 = new int[26];
            for(int j = i; j < i + n; j++){
                hash2[s2.charAt(j) - 'a']++;
            }
            if(Arrays.equals(hash1 , hash2)){
                return true;
            }
        } 
        return false;
    }
}
