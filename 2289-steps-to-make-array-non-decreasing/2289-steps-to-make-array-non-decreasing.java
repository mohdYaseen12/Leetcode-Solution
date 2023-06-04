class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{nums[0],0});
        int step = 0;
        for(int i=1;i<nums.length;i++){
            int temp = 0;
            while(!st.isEmpty() && st.peek()[0] <= nums[i]){
                temp = Math.max(st.peek()[1],temp);
                st.pop();
            }
            if(!st.isEmpty()){
                temp++;
            }else{
                temp = 0;
            }
            step = Math.max(temp,step);
            st.push(new int[]{nums[i],temp});
        }
        return step;
    }
}