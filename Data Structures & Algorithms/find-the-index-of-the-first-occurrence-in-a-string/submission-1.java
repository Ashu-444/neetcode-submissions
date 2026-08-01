class Solution {
    public int strStr(String s1, String s2) {
        if(s1.length() < s2.length()) return -1;
        int l = 0 , r = 0 , i = 0;
        while(l < s1.length()){
            if(s1.charAt(l) == s2.charAt(r)){
                l++;
                r++;
                if(r == s2.length()) return i;
            } else {
                i++;
                l = i;
                r = 0;
            }
        }
        return -1;
    }
}