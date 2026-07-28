class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && temp[i] > temp[st.peek()]){
                int j = st.pop();
                result[j] = i - j;
            }
            st.push(i);
        }
        return result;
    }
}
