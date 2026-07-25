class MinStack {
    int[] st;
    int[] minSt;
    int top;

    public MinStack() {
        st = new int[10000];
        minSt = new int[10000];
        top = -1;
    }                             
    
    public void push(int val) {
        top = top+1;
        st[top] = val;

        if(top == 0){
            minSt[top] = val;
        } else {
            minSt[top] = Math.min(val , minSt[top - 1]);
        }
    }
    
    public void pop() {
        if(top == -1) return;
        top = top - 1;
    }
    
    public int top() {
        if(top == -1) return -1;
        return st[top];
    }
    
    public int getMin() {
        if(top == -1) return -1;
        return minSt[top];
    }
}
