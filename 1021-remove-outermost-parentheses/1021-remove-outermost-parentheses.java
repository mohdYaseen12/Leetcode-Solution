class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        String ans = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' && count == 0)
                count++;
            else if(ch == '(' && count >= 1 ){
                ans+=ch;
                count++;
            }
            else if(ch == ')' && count > 1){
                ans+= ch;
                count--;
            }
            else if(ch == ')' && count == 1){
                count--;
            }
        }
        return ans;
    }
}