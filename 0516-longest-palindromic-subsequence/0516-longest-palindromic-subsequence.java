class Solution {
    public int longestPalindromeSubseq(String s) {
        int a = s.length();
        int[] dp = new int[a];
        for(int i = a - 1; i >= 0;i--){
            int[] dp2 = new int[a];
            dp2[i] = 1;
            for(int j = i+1; j < a; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp2[j] = 2 + dp[j-1];
                }else{
                    dp2[j] = Math.max(dp[j], dp2[j-1]);
                }
            }
            dp = dp2;
        }
        return dp[a-1];
    }
}