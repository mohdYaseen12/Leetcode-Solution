class Solution {
    public int maximumWealth(int[][] accounts) {
        int sum = 0;
        for(int[] acc : accounts){
            int currSum = 0;
            for(int i=0;i<acc.length;i++){
                currSum += acc[i];
            }
            sum = Math.max(currSum,sum);
        }
        return sum;
    }
}