class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int lb = Math.max(0,(ch-'a') - k);
            int ub = Math.min(25,(ch-'a') + k);
            int count = 0;
            for(int j = lb; j<= ub; j++){
                count = Math.max(count,dp[j]);
            }
            dp[ch - 'a'] = count+1;
            ans = Math.max(ans,dp[ch-'a']);
        }
        return ans;
    }
}