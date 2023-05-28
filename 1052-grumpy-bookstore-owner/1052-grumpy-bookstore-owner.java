class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int happy = 0;
        // calculate total happy customers
        for(int i=0;i<grumpy.length;i++){
            if(grumpy[i] == 0){
                happy += customers[i];
            }
        }
        
        
        for(int i=0;i<minutes;i++){
            if(grumpy[i] == 1){
                happy += customers[i];
            }
        }
        
        // apply sliding window in the minutes range
        int left = 0;
        int max = happy;
        for(int right = minutes;right<customers.length;right++){
            // expansion
            if(grumpy[right] == 1){
                happy += customers[right];
            }
            // contraction
            if(grumpy[left] == 1){
                happy -= customers[left];
            }
            left++;
            max = Math.max(max,happy);
        }
        return max;
    }
}