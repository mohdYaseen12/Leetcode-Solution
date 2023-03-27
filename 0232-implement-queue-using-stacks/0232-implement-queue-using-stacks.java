class MyQueue {

   
    Stack<Integer> stackA ;
    Stack<Integer> stackB ;
    public MyQueue() {
        // declare two stacks 
        // stackA : first
        // stackB : second
        stackA = new Stack<>();
        stackB = new Stack<>();
    }
    
    public void fullfillStack( Stack<Integer> stack ,Stack<Integer> target ){
        //TODO
        while( !stack.empty() ){
            target.push(stack.pop());
        }
    }

    public void push(int x) {
        // 1. first.add(int)
        // 2. update second stack
        if (stackA.empty()) fullfillStack(this.stackB,this.stackA);
        stackA.push(Integer.valueOf(x));
    }
    
    public int pop() {
        // 1. second.pop 
        // 2. update first
        if (stackB.empty()) fullfillStack(this.stackA,this.stackB);
        return stackB.pop();
    }
    
    public int peek() {
        // 1. second.peek
        if (stackB.empty()) fullfillStack(this.stackA,this.stackB);
        return stackB.peek();
    }
    
    public boolean empty() {
        // first.isEmpty
        return stackA.empty() && stackB.empty() ;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */