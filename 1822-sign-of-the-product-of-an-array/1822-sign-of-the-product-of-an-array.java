class Solution {
    public int arraySign(int[] nums) {
        // int pos = 0;
        int neg = 0;
        int zeros = 0;
        for(int num : nums){
            if(num == 0) zeros++;
            // else if(num > 0) pos++;
            else if(num < 0) neg++;
        }
        if(zeros != 0) return 0;
        else if(neg%2 == 0) return 1;
        else return -1;
    }
}