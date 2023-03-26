class Solution {
    public boolean isAnagram(String str1, String str2) {
        
        if(str1.length() != str2.length()) return false;
	   
	   HashMap<Character,Integer> hm = new HashMap<>();
	   for(int i=0;i<str1.length();i++){
		   hm.put(str1.charAt(i),hm.getOrDefault(str1.charAt(i),0)+1);
	   }
	   for(int i=0;i<str2.length();i++){
		   hm.put(str2.charAt(i),hm.getOrDefault(str2.charAt(i),0)-1);
	   }
	   for(int freq: hm.values()){
		   if(freq != 0) return false;
	   }
	   return true;
    }
}