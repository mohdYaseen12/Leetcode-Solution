class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        Map<Integer,Integer> hm = new HashMap<>();
        
        for(int num : nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        
        int n = nums.length/3;
        
        for(int key : hm.keySet()){
            if(hm.get(key) > n) ans.add(key);
        }
        return ans;
    }
}