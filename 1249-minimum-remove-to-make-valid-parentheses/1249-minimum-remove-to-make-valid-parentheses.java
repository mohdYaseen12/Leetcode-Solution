class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(') // add open brackets
                st.push(i);
            else if(ch == ')'){ // if close bracket appear see for its pair in stack
                if(!st.isEmpty()) st.pop(); // if stack  is not empty -> ) has its pair
                else set.add(i); // if stack is empty -> pair does not exist means it has to deleted
            }
        }
        // see if stack is empty
        // if stack is not empty it means these are to be deletd as well
        while(!st.isEmpty()){
            set.add(st.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}