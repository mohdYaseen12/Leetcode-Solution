class Solution {
    public boolean find132pattern(int[] nums) {
        //nums[i] contains first(1) ele from 1 3 2 pattern
        int n = nums.length;
        int second = Integer.MIN_VALUE; // contains second highest(2) number from 1 3 2 pattern
        Stack<Integer> st = new Stack<>();// st.peek() contains third(3) ele from 1 3 2 pattern
        for(int i=n-1;i>=0;i--){
            if(nums[i] < second){
                return true; // if pattern exist 
            }
            while(!st.isEmpty() && nums[i] > st.peek()){
                second = st.pop(); // updating second pattern
            }
            st.push(nums[i]);
        }
        return false;
    }
}