class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> hm = new HashMap<>(); // (sum, freq)
        hm.put(0,1);
        for(int i=0;i<n;i++){
            sum = sum + nums[i];
            if(hm.containsKey(sum - k)){
                count = count + hm.get(sum - k);
            }

            int oldVal = hm.getOrDefault(sum, 0);
            hm.put(sum, oldVal + 1);
        }
        return count;
    }

}