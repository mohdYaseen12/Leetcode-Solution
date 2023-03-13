class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) set.add(num); // adding original numbers to set
        
        // reversing each number and adding to set
        
        for(int num : nums){
            int rev = 0;
            while(num > 0){
                rev = rev * 10 + num % 10;
                num = num / 10;
            }
            set.add(rev);
        }
        
        // return the size of set 
        return set.size();
    }
}