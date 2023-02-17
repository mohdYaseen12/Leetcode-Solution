class Solution {
    

    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
       String prev = "";
        for(String s : words){
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String curr = new String(tmp);
            if(!curr.equals(prev)) ans.add(s);
            prev = curr;
        }
        return ans;
    }
}