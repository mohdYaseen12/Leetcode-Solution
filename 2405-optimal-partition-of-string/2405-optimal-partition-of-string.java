class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>(); // to check if substring of  their duplicate value
        int count = 0;
        
        for(char ch : s.toCharArray()){
            if(set.contains(ch)){ // check for duplicate character
                set.clear(); // clean hashset and add char and increment count by 1
                set.add(ch);
                count++;// we have found a substring which does not contains any dupllicate character.
            }
            else set.add(ch);
        }
        return count+1;
        
    }
}