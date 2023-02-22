class Solution {
    boolean isPossible(int[] arr,int B, int maxCap){
		long numberOfdays = 1;
		long currCap = 0;
		for(int weight : arr){
			if(currCap + weight <= maxCap){
				currCap += weight;
			}
			else{
				numberOfdays++;
				currCap = weight;

				if(currCap > maxCap) return false;
			}
		}
		return numberOfdays <= B;
		
	}
    public int shipWithinDays(int[] A, int days) {
        int start = 0;
		int end = 0;
		for(int i=0;i<A.length;i++){
			start = Math.max(start,A[i]);
			end += A[i];
		}
		int res = -1;
		while(start<= end){
			int mid = (start + end) / 2;
			if(isPossible(A,days,mid) == true){
				res = mid;
				end = mid-1;
			}
			else start = mid+1;
		}
		return res;
    }
}