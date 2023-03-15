class Solution {
    public int firstMissingPositive(int[] nums) {
        // int max = Integer.MIN_VALUE;
        // int ans=0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            // max = Math.max(max,num);
             set.add(num);
        }
        
        for(int i=1; i<=nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length +1;
    }
}