class Solution {
    public String decodeString(String s) {
        String ans = "";
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            
            if(ch == ']'){
                String temp = "";
                while(!st.isEmpty() && st.peek() != '['){
                    temp += st.pop();
                }
                st.pop(); // pop '['
                
                // get the number
                int k = 0;
                int base = 1;
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    k = (st.pop()-'0') * base + k;
                    base = base * 10;
                }
                
                // put back the string into stack k times to explore more
                
                while(k-- > 0){
                    for(int i = temp.length()-1; i >= 0; i--){
                        st.push(temp.charAt(i));
                    }
                }
                
            }
            else {
                st.push(ch);
            }
        }
        
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
    }
}