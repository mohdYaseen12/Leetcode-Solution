class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character,Integer> map = new HashMap<>();
        
        // building freq map
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            
            if(st.contains(ch)){
                map.put(ch,map.get(ch)-1);
                continue;
            }
            // maintaining monotonicity of stack 
            while(!st.isEmpty() && (Character.compare(st.peek(),ch) > 0) && map.get(st.peek()) > 0){
                st.pop();
            }
            st.push(ch);
            map.put(ch,map.get(ch)-1);
            // System.out.println(st.peek());
            
        }
        
        
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
    }
}