class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000007;
        int[] peopleKnow = new int[n+forget];
        
        peopleKnow[1] = 1;
        for(int i=1;i<=n;i++){
            for(int j = i+delay; j<i+forget; j++){
                peopleKnow[j] = (peopleKnow[j] + peopleKnow[i])%mod;
                // System.out.println(peopleKnow[j]);
            }
        }
        
        // int i=0;
        long ans = 0;
        for(int i=n;i>n-forget;i--){
            ans = (ans + peopleKnow[i])%mod;
            // System.out.println(ans);
        }
        return (int)ans;
    }
}