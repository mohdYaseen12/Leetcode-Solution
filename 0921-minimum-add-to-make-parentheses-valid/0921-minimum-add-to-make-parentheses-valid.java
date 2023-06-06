class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int ans = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(') count++;
            else count--;
            
            if(count < 0){ // we have to add corresponding open bracket before we move forward;
                ans += Math.abs(count);
                count = 0;
            }
        }
        
        ans += Math.abs(count);
        return ans;
    }
}