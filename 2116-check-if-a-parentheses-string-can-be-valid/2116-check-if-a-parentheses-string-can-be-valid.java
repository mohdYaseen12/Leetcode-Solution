class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length() % 2 != 0){ // there is no way we can make any odd length string valid 
            // there will be atleast one bracket which can not be balanced 
            return false;
        }
        int total = 0;
        int open = 0;
        int closed = 0;
        
        // left to right traversal
        for(int i=0;i<s.length();i++){
            if(locked.charAt(i) == '0'){
                total++;
            }
            else if(s.charAt(i) == '(') open++;
            else if(s.charAt(i) == ')') closed++;
            
            if(total + open - closed < 0) return false;
        }
        
        total = 0;
        open = 0;
        closed = 0;
        
        // right to left
        for(int i = s.length()-1;i>=0;i--){
            if(locked.charAt(i) == '0'){
                total++;
            }
            else if(s.charAt(i) == '(') open++;
            else if(s.charAt(i) == ')') closed++;
            
            if(total - open + closed < 0) return false;
        }
        return true;
        
    }
}