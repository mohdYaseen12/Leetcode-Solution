class Solution {
    public int findMin(int[] nums) {
     
        int start = 0;
        int end = nums.length-1;
        // arrays is already sorted( not rotated)
        if(nums[start] < nums[end]) return nums[start];
        while(start < end){
            int mid = (start + end )/2;
            if(nums[mid] > nums[end]) // min lies on right part
                start = mid+1;
            else if(nums[mid] < nums[end]) // min lies on left part
                end = mid;
            else end--;
        }
        return nums[end];
    }
}