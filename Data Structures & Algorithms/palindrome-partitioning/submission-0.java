class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        f(0 , s , ans , ds);
        return ans;
    }
    void f(int ind , String s , List<List<String>> ans , List<String> ds){
        if(ind == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = ind; i < s.length(); i++){
            if(isPalindrome(s , ind , i)){
                ds.add(s.substring(ind , i + 1));
                f(i + 1 , s , ans , ds);
                ds.remove(ds.size() - 1);
            }
        }
    }
    boolean isPalindrome(String s , int l , int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
