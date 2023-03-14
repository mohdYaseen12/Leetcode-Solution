class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

       List<List<Integer>> fr = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if(target == -294967296) {

            return fr;
        }

        Arrays.sort(nums);
        for(int i = 0;i< nums.length;i++) {
            for (int j = i+1;j< nums.length;j++) {
                int k = j+1;
                int end = nums.length-1;
                while(k < nums.length && end > 0 && end !=k && end >k) {
                   int sum = nums[i] + nums[j] + nums[k] + nums[end];
                    if(sum == target) {
                     result.add(nums[i]);
                         result.add(nums[j]);
                     result.add(nums[k]);
                     result.add(nums[end]);
                  if(result.size() ==4 ) {
                     Collections.sort(result);
                     if(!fr.contains(result)) {
                     fr.add(result);
                     }
                  }
                     k++;
                     end--;
                     result = new ArrayList<>();
                    } else if(sum < target) {
                        k++;
                    } else {
                        end--;
                    }   
                }       
            }
        }
        return fr;
    }
}