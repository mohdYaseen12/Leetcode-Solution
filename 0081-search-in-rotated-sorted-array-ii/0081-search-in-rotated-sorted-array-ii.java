class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            // if(nums[start] == target) return true;
            while(start+1 < nums.length-1 && nums[start] == nums[start + 1]) start++;
            // if(nums[end] == target) return true;
            while(end-1 >= 0 && nums[end] == nums[end-1]) end--;

            int mid = (start + end) /2;
            if(nums[mid] == target) return true;
            // check if left part is sorted
           else if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target < nums[mid] ){
                    end = mid-1;
                }
                else start = mid +1;
            }
            // right part is sorted
            else{
                if (target <= nums[end]  && nums[mid] < target){
                    start = mid+1;
                }
                else end = mid-1;
            }


        }
        return false;
    }
}