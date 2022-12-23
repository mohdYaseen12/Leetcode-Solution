class Solution {
    public String reverseParentheses(String s) {
          Stack<Character> st = new Stack<>();
	  Queue<Character> q = new LinkedList<>();
	  int count = 0;
	  for(int i=0; i<s.length();i++){
		  char ch = s.charAt(i);
		  if(ch == '(') count++;
		  if(st.size() > 0 && ch == ')'){
			  while(st.size() > 0 && st.peek() != '('){
				 q.add(st.pop());
			  }
			  st.pop();

			  while(q.size() > 0){
				  st.push(q.remove());
				  // q.remove();
			  }
		  }
		  else st.push(ch); 
	  }
	  char[] arr = new char[st.size()];
	  for(int i= st.size()-1;i>=0;i--){
		  
		  arr[i] = st.pop();
	  }
	 String ans = new String(arr);
	  return ans;
    }
}