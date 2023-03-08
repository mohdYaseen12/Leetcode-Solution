class Solution {
    private int getMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int pile : piles){
            max = Math.max(pile,max);
        }
        return max;
    }
    
    private boolean ableToEat(int[] piles, int k, int h){
        int countHour = 0;
        for(int pile : piles){
            countHour += pile / k;
            
            if(pile % k != 0){
                countHour++;
            }
        }
        return countHour <= h;
    } 
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1; // min possible k 
        int end = getMax(piles); // max possible k
        
        while(start < end){
            // int mid = (start + end) / 2; 
            int mid = start + (end  - start) / 2;
            if(ableToEat(piles,mid,h)){
                end = mid;
            }
            else start = mid+1;
        }
        
        return start;
    }
}