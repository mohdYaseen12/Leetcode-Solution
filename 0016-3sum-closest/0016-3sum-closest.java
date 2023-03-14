class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            
            int start = i+1;
            int end = nums.length-1;
            
            while(start < end){
                int currSum = nums[i] + nums[start] + nums[end];
                if(Math.abs(currSum - target) < Math.abs(diff)){
                    diff = target - currSum;
                }
                else if(currSum < target) start++;
                else end--;
            }
        }
        return target - diff;
    }
}