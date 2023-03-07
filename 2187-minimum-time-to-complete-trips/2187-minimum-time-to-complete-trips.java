class Solution {
    private boolean checkTime(long isValidTime, int totalTrips, int[] time){
        long trips = 0;
        for(int t : time){
            trips += isValidTime / t;
        }
        if(trips >= totalTrips) return true;
        return false;
    }
    public long minimumTime(int[] time, int totalTrips) {
        long start = Long.MAX_VALUE;
        long end = 0;
        long min = Long.MAX_VALUE;
        for(int t : time){
            start = Math.min(start,t);
            min = Math.min(min,t);
        }

        end = totalTrips * min;
        while(start < end){
            long mid = (start + end) / 2;

            if(checkTime(mid,totalTrips,time)){
                end = mid;
            }
            else start = mid + 1;
        }
        return start;
    }
}