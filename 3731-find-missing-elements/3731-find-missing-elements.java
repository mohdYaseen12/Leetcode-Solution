class Solution {
    // sorting method O(nlogn)
    // public List<Integer> findMissingElements(int[] nums) {

    //     List<Integer> ans = new ArrayList<>();
    //     Arrays.sort(nums);
        
    //     int curr = nums[0];

    //     for(int i =0; i<nums.length; i++) {
    //         if(curr < nums[i]){
    //             ans.add(curr);
    //             i--;
    //         }
    //         curr++;
    //     }

    //     return ans;
    // }


    // boolean method O(n)
    public List<Integer> findMissingElements(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        boolean[] contains = new boolean[101];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            contains[num] = true;
        }

        for(int i = min; i<=max; i++){
            if(!contains[i]) ans.add(i);
        }

        return ans;
       
    }
}