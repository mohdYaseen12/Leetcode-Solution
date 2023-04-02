class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];

        for(int i=0; i<spells.length; i++){
            int lo = 0, hi = potions.length;
            while(lo < hi){ 
                int mid = lo + (hi - lo)/2;
                if((long)spells[i] * (long)potions[mid] >= success){
                    hi = mid;
                }
                else{
                    lo = mid + 1;
                }
            }
            pairs[i] = potions.length - lo;
        }
        return pairs;
    }
}