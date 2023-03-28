class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < days.length; i++){
            set.add(days[i]);
        }
        int max = days[days.length - 1];
        int[] dp = new int[ max + 1];
        for(int i = 1; i < dp.length; i++){
            int c1 = dp[i-1];
            int c7 = (i-7) > 0 ? dp[i-7] : 0;
            int c30 = (i-30) > 0 ? dp[i-30] : 0;
            if(set.contains(i)){
                dp[i] = Math.min(c1 + costs[0], Math.min(c7 + costs[1], c30 + costs[2])); 
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length - 1];
    }
}