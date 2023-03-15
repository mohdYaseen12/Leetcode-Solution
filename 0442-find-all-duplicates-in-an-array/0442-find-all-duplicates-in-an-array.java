class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        if(nums.length == 1 || nums.length == 0) return new ArrayList<>();
        Map<Integer,Integer> hm = new HashMap<>();
        List<Integer> duplicate = new ArrayList<>();
        
        for(int num : nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
            
            if(hm.get(num) == 2) duplicate.add(num);
        }
        return duplicate;
        
    }
}