class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // if(ransomNote.length() != magazine.length()) return false;
        
        
        Map<Character,Integer> mag = new HashMap<>();
        Map<Character,Integer> ransom = new HashMap<>();
        
        //building ransom note freq map
        for(int i =0; i< ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            ransom.put(ch,ransom.getOrDefault(ch,0)+1);
        }
        
        // building magazine freq map
        for(int i =0; i< magazine.length();i++){
            char ch = magazine.charAt(i);
            mag.put(ch,mag.getOrDefault(ch,0)+1);
        }
        
        // comparing letters of ransome note to magazine
        
        for(char key : ransom.keySet()){
            if(!mag.containsKey(key)) return false;
            if(ransom.get(key) > mag.get(key)) return false;
        }

        return true;
    }
}