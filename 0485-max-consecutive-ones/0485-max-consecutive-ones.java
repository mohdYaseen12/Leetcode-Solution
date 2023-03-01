class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int i=0;
        int j = 0;
        while(j<nums.length){
            while(i<nums.length && nums[i] != 1) i++;
            j = i;
            while( j < nums.length && nums[j] == 1) j++;
             // j++;
            ans = Math.max(ans, (j-i));
            i = j;
        }
        return ans;
    }
}