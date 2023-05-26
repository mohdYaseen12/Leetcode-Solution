class Solution {
    public void wiggleSort(int[] nums) {
        
        int[] copy = Arrays.copyOf(nums,nums.length);
        int n = nums.length-1;
        Arrays.sort(copy);
        
        for(int i=1;i<nums.length;i+=2){
            nums[i] = copy[n--];
        }
        for(int i=0;i<nums.length;i+=2){
            nums[i] = copy[n--];
        }
        
    }
}