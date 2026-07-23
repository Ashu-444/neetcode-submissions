class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;

        int[] h1 = new int[26];    
        int[] h2 = new int[26]; 
        for(int i = 0; i < n; i++){
            h1[s1.charAt(i) - 'a']++;
            h2[s2.charAt(i) - 'a']++;
        }
        int l = 0 , r = n;
        while(r < m){
            if(Arrays.equals(h1 , h2)){
                return true;
            }
            //sliding the window 
            h2[s2.charAt(l) - 'a']--;
            h2[s2.charAt(r) - 'a']++;
            l++;
            r++;
        }
        return Arrays.equals(h1 , h2);
    }
}
