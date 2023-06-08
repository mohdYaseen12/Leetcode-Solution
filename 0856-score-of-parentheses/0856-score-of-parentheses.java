class Solution {
    public int scoreOfParentheses(String s) {
        // Stack<Integer> st = new Stack<>();
        // int score = 0;
        // for(char ch : s.toCharArray()){
        //     if(ch == '('){
        //         st.push(score);
        //         score = 0;
        //     }
        //     else{
        //         score = st.pop() + Math.max(2 * score, 1);
        //     }
        // }
        // return score;
        
        
        
        // depth version
        // constant space complexity
        
        int depth = 0;
        int score = 0;
        int n = s.length();
        
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '(') depth++;
            else{
                depth--;
                if(s.charAt(i-1) == '('){
                    score += Math.pow(2,depth);
                }
            }
        }
        
        return score;
    }
}