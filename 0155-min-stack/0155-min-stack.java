class MinStack {

    Stack<int[]> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new int[]{val,val});
            return;
        }
        st.push(new int[]{val,Math.min(st.peek()[1],val)});
    }
    
    public void pop() {
        if(st.isEmpty())
            return;
        st.pop();
        
    }
    
    public int top() {
        // if(st.isEmpty())
        //     return;
        return st.peek()[0];
        
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */