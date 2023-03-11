class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : nums) hm.put(num,hm.getOrDefault(num,0)+1);
        
        int sum = 0;
        for(int key : hm.keySet()){
            if(hm.get(key) == 1) sum += key;
        }
        return sum;
    }
}