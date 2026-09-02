class Solution {
    Map<Integer , String> map = new HashMap<>();
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0) return ans;

        map.put(2 , "abc");
        map.put(3 , "def");
        map.put(4 , "ghi");
        map.put(5 , "jkl");
        map.put(6 , "mno");
        map.put(7 , "pqrs");
        map.put(8 , "tuv");
        map.put(9 , "wxyz");
        f(0 , digits , "");
        return ans;
    }
    void f(int ind , String digits , String s){
        if(ind == digits.length()){
            ans.add(s);
            return;
        }
        String letter = map.get(digits.charAt(ind) - '0');
        for(int i = 0;i < letter.length(); i++){
            f(ind + 1 , digits , s + letter.charAt(i));
        }
    }
}
