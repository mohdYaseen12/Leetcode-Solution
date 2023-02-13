class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
		int n = nums.length;
		Arrays.sort(nums);
		for(int i=0;i<n;i++){
			int left = i+1;
			int right = n-1;
			
			while(left < right){
                List<Integer> curr = new ArrayList<>();
				int sum = nums[i] + nums[left] + nums[right];
				if(sum == 0){
					curr.add(nums[i]);
					curr.add(nums[left]);
					curr.add(nums[right]);
					ans.add(curr);
					left++;
					while(left < right && nums[left] == nums[left-1]) left++;
					right--;
					while(right > left && nums[right] == nums[right+1]) right--;
					
				}
				else if(sum < 0){
					left++;
					while(left < right && nums[left] == nums[left-1]) left++;
				}
				else{
					right--;
					while(right > left && nums[right] == nums[right+1]) right--;
				}
				
			}
			while(i+1 < n && nums[i] == nums[i+1]) i++;
		}
		return ans;
    }
}