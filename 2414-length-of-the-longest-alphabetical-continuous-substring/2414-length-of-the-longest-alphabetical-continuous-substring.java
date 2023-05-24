class Solution {
    public int longestContinuousSubstring(String s) {
        int len = 0;
        int prevch = 0;
        int ans = 0;
        for(char ch : s.toCharArray()){
            len = ch - 'a' - prevch == 1 ? len + 1 : 1; // either add in the length or restart again
            
            ans = Math.max(ans,len);
            prevch = ch-'a'; // keep track of prev char element for comparison
        }
        return ans;
    }
}