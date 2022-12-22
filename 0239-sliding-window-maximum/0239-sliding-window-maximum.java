class Solution {
    public int[] ngeRightIdx(int[] nums){
        int[] ans = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(st.size() > 0 && nums[i] > nums[st.peek()]){
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while(st.size() > 0){
            ans[st.peek()] = nums.length;
            st.pop();
        }

        return ans;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] nge = ngeRightIdx(nums);
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        for(int i=0;i<=nums.length - k; i++){
            if(j < i) j = i;

            while(nge[j] < i+k){
                j = nge[j];
            }
            ans[i] = nums[j];
        }
        return ans;
    }
}