class Solution {
    private int maxIdx(int[] nums){
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(mid+1 < nums.length && nums[mid] > nums[mid+1] ) return mid;
            else if(nums[start] <= nums[mid]) start = mid+1;
            else end = mid - 1;
        }
        return nums.length-1;
    }

    private int binarySearch(int[] nums, int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] <= target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        // int idx = maxIdx(nums);
        // if(nums[idx] == target) return idx;
        // else if(nums[0] <= target && nums[idx] > target) return binarySearch(nums,target,0,idx);
        // else return binarySearch(nums,target,idx+1,nums.length-1);

        // Approach 2

        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target) return mid;
            // 1st line
            else if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target < nums[mid]) end = mid-1;
                else start = mid+1;
            }
            // 2nd line
            else{
                if(nums[mid] < target && target <= nums[end]) start = mid+1;
                else end = mid -1;
            }
        }
        return -1;
    }
}