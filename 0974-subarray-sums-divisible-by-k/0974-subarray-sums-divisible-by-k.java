class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer, Integer> hm = new HashMap<>(); // (rem, freq)
        
        
        hm.put(0,1);
        int count = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
         sum += nums[i];
            int rem = sum % k;
            if(rem < 0) 
                rem += k;
            int val = hm.getOrDefault(rem,0);
            count = count + val;
            hm.put(rem,val+1);
        }
        return count;
    }
}

// 
// Approaach 1
// num % k -- > rem
// rem --> present
// rem < 0  --> rem + k
// 5 -14 1 -- > -14 % 5 --> -4 + 5 >  1
// 1 % 5 --> 1
// 

// App
// i = 0 -> n
// j = i+1 -> n

