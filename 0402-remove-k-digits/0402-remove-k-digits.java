class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : num.toCharArray()){
            // maintaining k size stack
            while(!st.isEmpty() && k > 0 && ch < st.peek()){
                st.pop();
                k--;
            }
            
            // if stack is empty it will prevent leading zeroes to get added into stack
            // if stack is not empty it will add 
            if(!st.isEmpty() || ch != '0')
                st.push(ch);
        }
        
        // checking the if stack size is more than k then pop 
        while(!st.isEmpty() && k-- > 0){
            st.pop();
        }
        
        // base case
        // if stack is empty
        if(st.isEmpty()) return "0";
        
        // building ans 
        
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
    }
}