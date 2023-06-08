class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        
        for(int i = n-1;i >= 0; i--){
            // pop until we find next greater element to the right
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            // if stack not empty, then we have some next greater element, 
			// so we take distance between next greater and current temperature
			// as we are storing indexes in the stack
            if(!st.isEmpty()){
                ans[i] = st.peek()-i;
            }
            st.push(i);
        }
        return ans;
    }
}