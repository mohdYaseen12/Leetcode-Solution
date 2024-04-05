class Solution {
    public String makeGood(String s) {
        // String ans="";
        for(int i=0;i<s.length()-1;i++){
            char ch1 = s.charAt(i+1);
            char ch2 = s.charAt(i);
            if((int)(Math.abs(ch1-ch2))== 32 ){
                return makeGood(s.substring(0,i) + s.substring(i+2));
            }
        }
        return s;
    }
}