class Solution {
    public int minKBitFlips(int[] nums, int k) {
        // taking ccount variable to check how many times a bit has been flipped
        int count = 0;
        int ans = 0;
        
        
        // use a boolean array to track what aaray element i will flip it 
        boolean[] check = new boolean[nums.length];
        
        // traversing in array
        for(int i=0;i<nums.length;i++){
            // flip bit if nums[i] == 0 & it haven't flipped, i will flip checking even no (for cancellation)
            // if nums[i] == 1 flip it odd no times 
            
            if((nums[i] == 0 && count %2 == 0) || (nums[i] == 1 && count%2 != 0)){
                count++;
                ans++;
                
                if(i+k-1 >= nums.length){
                    // i have encountered an element which needs flip but there are not enough element to flip
                    // and all the prev element are 1
                    return -1;
                }
                else{
                    // flip current element use check to keep track till which element current flip has effect
                    check[i+k-1] = true;
                }
            }
            if(check[i] ){
                // i am passing a element till which certains flip was active
                count--;
            }
        }
        
        return ans;
        
        
    }
}