class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = 0;
        int globalMax = nums[0];
        int currMin = 0;
        int globalMin = nums[0];
        int totalSum = 0;
        
        for(int num : nums){
            totalSum += num;
            currMax = Math.max(currMax+num, num);
            globalMax = Math.max(currMax,globalMax);
            
            currMin = Math.min(currMin + num, num);
            globalMin = Math.min(currMin,globalMin);
        }
        
        return globalMax > 0 ? Math.max(globalMax, totalSum - globalMin) : globalMax;
    }
}