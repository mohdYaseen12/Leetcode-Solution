class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int maxIdx = -1;
        int maxOcc = 0;
        // building count array, and find max occur character.
        for(int i=0;i<s.length();i++){
            count[s.charAt(i) - 'a']++;
            if(count[s.charAt(i) - 'a'] > maxOcc){
                maxOcc = count[s.charAt(i) - 'a'];
                maxIdx = (int)(s.charAt(i) - 'a');
            }
        }
        
        if(maxOcc > (s.length() +1)/2) return "";
        
        int idx = 0;
        char[] res = new char[s.length()];
        
        while(count[maxIdx] > 0){
            res[idx] = (char)(maxIdx + 'a');
            idx +=2;
            count[maxIdx]--;
        }
        
        for(int i=0;i<26;i++){
            while(count[i] > 0){
                if(idx >= s.length()) idx =1;
                res[idx] = (char)(i + 'a');
                idx+=2;
                count[i]--;
            }
        }
        return String.valueOf(res);
    }
   
}