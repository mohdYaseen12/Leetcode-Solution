class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums){
            // add num into set
             set.add(num);
        }
        
        for(int num : set){
             // check if set has any element which is equal to original
            if(set.contains(original)){
                // update original
                original *= 2;   
            }
        }
        return original;
    }
}