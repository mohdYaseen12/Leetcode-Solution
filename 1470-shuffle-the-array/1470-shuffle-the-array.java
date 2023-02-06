class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        // int mid = n/2;
        int k = 0;
        for(int i=0;i<nums.length;i++){
            if(i%2 == 0 && k < nums.length){
                ans[i] = nums[k++];
            }
            else if(i%2 != 0 && n < nums.length){
                ans[i] = nums[n];
                n++;
            }
        }
        return ans;
    }
}