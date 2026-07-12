class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxlen = 0 , l = 0 , r = 0;
        Map<Character , Integer> map = new HashMap<>();
        while(r < n){
            if(map.containsKey(s.charAt(r))){
                if(map.get(s.charAt(r)) >= l){     
                    l = map.get(s.charAt(r)) + 1;
                } 
            }
            int len = r - l + 1;
            maxlen = Math.max(maxlen , len);
            
            map.put(s.charAt(r) , r);
            r++;
        }
        return maxlen;
    }
}
