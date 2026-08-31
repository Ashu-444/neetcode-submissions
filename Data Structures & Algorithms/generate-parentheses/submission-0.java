class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        f("" , n , n);
        return ans;
    }
    void f(String s , int open , int close){
        if(open == 0 && close == 0){
            ans.add(s);
            return;
        }
        if(open > 0){
            f(s + "(" , open - 1 , close);
        }
        if(close > open){
            f(s + ")" , open , close - 1);
        }
    }
}
