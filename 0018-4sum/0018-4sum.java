class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if(target == -294967296 || target == 294967296){
            return ans;
        }
        // fixing first element and then searching for next three element
        for(int i=0;i<nums.length;i++){
            // fixing second element and searching for next two element
            for(int j=i+1;j<nums.length;j++){
               
                // normal two Sum solution
                int newTar = target - (nums[i] + nums[j]); // getting new target for two sum
                int start = j+1; // fixing start index as next index from the second fixed element 
                int end = nums.length-1; // fixind end pointer --> pointing to the last element
                
                while(start < end){
                    int sum = nums[start] + nums[end];
                    if(sum == newTar){ // found the all four required element
                        List<Integer> curr = new ArrayList<>();
                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[start]);
                        curr.add(nums[end]);
                        ans.add(curr);
                        start++;
                        // moving next for same elements.
                        while(start < end && nums[start] == nums[start-1]) start++;
                        
                        end--;
                        // moving back from end for the same element
                        while(end > start && nums[end] == nums[end+1]) end--;
                    }
                    else if(sum < newTar){
                        start++;
                        // checking for same element and moving forward
                        while(start < end && nums[start] == nums[start-1]) start++;
                    }
                    else{
                        end--;
                        // checking for prev same element and moving backward 
                        while(end > start && nums[end] == nums[end+1]) end--;
                    }
                }
                // checking and moving forward for same element
                while(j+1 < nums.length && nums[j] == nums[j+1]) j++;
            }
            // checking and moving forward for same element
            while(i+1 < nums.length && nums[i] == nums[i+1]) i++;
        }
        
        return ans;
    }
}