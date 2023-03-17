class Solution {
    public int largestPerimeter(int[] nums) {
        
        Arrays.sort(nums);
        
        for(int i= nums.length-1;i>1;i--){
            
            // sum of two sides of triangle must be greater than third side --> for valid triangle
            if(nums[i] < nums[i-1]+nums[i-2]){
                return nums[i]+nums[i-1]+nums[i-2];
            }
        }
        
        return 0;
    }
}