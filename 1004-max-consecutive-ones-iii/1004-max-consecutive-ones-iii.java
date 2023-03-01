class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int ans = 0;
        int windowSize = 0;
        
        while( j < nums.length){
           if(nums[j] == 1) j++;
            
            if(j < nums.length && windowSize <= k && nums[j] == 0){
                windowSize++;
                j++;
            }
            
            
            if(windowSize > k){
                if(i < nums.length && nums[i] == 0){
                    windowSize--;
                    i++;
                }
                else i++;
            }
            ans = Math.max(ans, j-i);
        }
        return ans;
    }
}