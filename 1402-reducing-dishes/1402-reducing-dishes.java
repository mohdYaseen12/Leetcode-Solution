class Solution {
    public int maxSatisfaction(int[] satisfaction) {
       Arrays.sort(satisfaction);
        int len = satisfaction.length;
        int index = len-1;
        int sum = 0;
        int maxSum = 0;
        
        while(index>=0){
            int satisfactionLevel = satisfaction[index];
            int currSum = satisfactionLevel+maxSum+sum; // a3*1 + a4*2 + a5*3 + a6*4 = a3 + a4*1 + a5*2 + a6*3 + a4 + a5 + a6
            
            if(currSum<maxSum) break;
            else maxSum = currSum;
            
            sum+=satisfactionLevel;
            index--;
        }
        
        return maxSum;
    }
}