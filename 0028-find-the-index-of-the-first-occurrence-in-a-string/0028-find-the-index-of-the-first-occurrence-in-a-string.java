class Solution {
    public int strStr(String haystack, String needle) {
        int idx = -1;
        int needleLen = needle.length();
        for(int i=0;i<=haystack.length()-needleLen;i++){
            if(haystack.substring(i,i+needleLen).equals(needle)){
                idx = i;
                break;
            }
        }
        return idx;
    }
}