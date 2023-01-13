class Solution {
    public boolean isAnagram(String str1, String str2) {
        // char ch[] = new char[str1.length()];
        // char ch1[] = new char[str2.length()];

        // for(int i=0;i<str1.length();i++){
        //     ch[i] = str1.charAt(i);
        // }
        // for(int i=0;i<str2.length();i++){
        //     ch1[i] = str2.charAt(i);
        // }
        // Arrays.sort(ch);
        // Arrays.sort(ch1);
        // boolean flag = true;
        // if(str1.length() != str2.length()){
        //     return false;
        // }
        // else{
        //     for(int i=0; i<ch.length;i++){
        //         if(ch[i] != ch1[i]){
        //             flag = false;
        //             break;
        //         }
        //     }
        // }
        // return flag;


        // using hashMap

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