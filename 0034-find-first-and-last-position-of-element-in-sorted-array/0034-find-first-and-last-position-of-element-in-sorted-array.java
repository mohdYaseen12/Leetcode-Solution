class Solution {
    int first(int[] nums, int target){
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
            end = mid - 1;
        }else{
            start = mid + 1;
        }
        if(nums[mid] == target) ans = mid;
        }
        return ans;
    }
    int last(int[] nums, int target){
         int n = nums.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
            start = mid + 1;
        }else{
            end = mid - 1;
        }
        if(nums[mid] == target) ans = mid;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = first(nums,target);
        ans[1] = last(nums,target);
        return ans;
    }
}