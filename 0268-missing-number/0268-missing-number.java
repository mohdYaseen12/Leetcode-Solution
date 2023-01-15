class Solution {
    public int missingNumber(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
		// int[] ans = new int[2];
		for(int i=0;i<nums.length;i++){
			if(hm.containsKey(nums[i])){
				hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
			}
			else hm.put(nums[i],1);
		}
        // for repeating number
		// for(int key : hm.keySet()){
		// 	if(hm.get(key) == 2){
		// 		ans[0] = key;
		// 		break;
		// 	}
		// }
		for(int i=0;i<nums.length;i++){
			if(!hm.containsKey(i)){
				// ans[1] = i;
				// break;
                return i;
			}
		}
		// if(ans[1] == 0) ans[1] = nums.length;

		// return ans;
        return nums.length;
    }
}