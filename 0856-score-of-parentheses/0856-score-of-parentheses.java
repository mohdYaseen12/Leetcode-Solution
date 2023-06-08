class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int score = 0;
        
        for(char ch : s.toCharArray()){
            if(ch =='(') st.push(ch);
            else{
                // if peek is '(' -> means wee have found the corresponding pair
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                    st.push('1');
                }
                else{ // if peek element is number
                    int sum = 0;
                    while(!st.isEmpty() && st.peek() != '('){
                        sum += st.pop() - '0';
                    }
                    
                    // pop() the '('
                    st.pop();
                    st.push((char)(2 * sum + '0'));
                    
                }
            }
        }
        
        while(!st.isEmpty()){
            score += st.pop() - '0';
        }
        return score;
    }
}