class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
		int sum = 0;
		int count = 0;
		hm.put(0,1);
        int n = nums.length;

		for(int i=0;i<n;i++){
			sum += nums[i];
			int rem = sum % k;
			if(rem < 0) rem += k;

			int val = hm.getOrDefault(rem,0);
			count += val;
			hm.put(rem, val+1);
		}
		return count;
    }
}