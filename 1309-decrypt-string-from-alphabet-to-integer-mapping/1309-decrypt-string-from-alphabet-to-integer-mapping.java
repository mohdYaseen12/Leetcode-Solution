class Solution {
    public String freqAlphabets(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        for(int i = n-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch == '#'){
                int j = Integer.parseInt(s.substring(i-2,i));
                res.append((char)(j+'a'-1));
                i -= 2;
            }
            else res.append((char)(ch+'0'));
        }
        res.reverse();
        return res.toString();
    }
}