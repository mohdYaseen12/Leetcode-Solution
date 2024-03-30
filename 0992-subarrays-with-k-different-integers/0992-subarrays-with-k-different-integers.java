class Solution {
    public int subarraysWithKDistinct(int[] nums, int K) {
         return subarraysWithAtMostKDistinct(nums, K) - subarraysWithAtMostKDistinct(nums, K - 1);
        
    }
     private int subarraysWithAtMostKDistinct(int[] A, int K) {
        if (K == 0) return 0;
        
        int j = 0, numGoodSubArr = 0, n = A.length;
        // Map a character to its frequency in current window.
        Map<Integer, Integer> chToFreq = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (; j < n; j++) {
                chToFreq.put(A[j], chToFreq.getOrDefault(A[j], 0) + 1);
                if (chToFreq.size() <= K) numGoodSubArr += j - i + 1; 
                else {
                    chToFreq.put(A[j], chToFreq.get(A[j]) - 1);
                    if (chToFreq.get(A[j]) == 0) chToFreq.remove(A[j]);
                    break; 
                }
            }
            chToFreq.put(A[i], chToFreq.get(A[i]) - 1);
            if (chToFreq.get(A[i]) == 0) chToFreq.remove(A[i]);
        }

        return numGoodSubArr;
    }
}