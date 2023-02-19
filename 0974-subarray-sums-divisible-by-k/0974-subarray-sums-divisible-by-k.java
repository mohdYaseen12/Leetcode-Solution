class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<>(); // rem, freq
        
        hm.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            int rem = sum % k;
            if(rem < 0) rem = rem + k;
            
            int val = hm.getOrDefault(rem,0);
            count += val;
            hm.put(rem,val+1);
        }
        return count;
    }
}