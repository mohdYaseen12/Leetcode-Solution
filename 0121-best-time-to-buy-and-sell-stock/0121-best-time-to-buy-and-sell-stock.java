class Solution {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE; // least so far
	  int op = 0; // overall profit
	  int pid = 0; // profit on ith day
	  for(int i=0;i<prices.length;i++){
		  if(prices[i] < lsf){
			  lsf = prices[i];
		  }
		  pid = prices[i] - lsf;
		  if(op < pid){
			  op = pid;
		  }
	  }
	  return op;
    }
}