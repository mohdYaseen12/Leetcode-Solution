class Solution {
    public int findFinalValue(int[] nums, int original) {
        // APPROACH USING HASHSET
        
        
//         Set<Integer> set = new HashSet<>();
        
//         for(int num : nums){
//             // add num into set
//              set.add(num);
//         }
        
//         for(int num : set){
//              // check if set has any element which is equal to original
//             if(set.contains(original)){
//                 // update original
//                 original *= 2;   
//             }
//         }
//         return original;
        
        // APPROACH 2: USING SORTING AND NORMAL ITERATION THROUGH LOOP IN GIVEN ARRAY NUMS
        
        
        Arrays.sort(nums);
        for(int num : nums){
            if(num == original) original = original * 2;
        }
        return original;
    }
}