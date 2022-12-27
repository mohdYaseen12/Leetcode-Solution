class Solution {
    public String sortStr(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);

        return new String(ch);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int n = strs.length;
        Map<String, List<String>> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            String original = strs[i];
            String sorted = sortStr(original);

            if(hm.containsKey(sorted)){
                List<String> oldList = hm.get(sorted);
                oldList.add(original);
                hm.put(sorted,oldList);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(original);
                hm.put(sorted,list);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(String key : hm.keySet()){
            ans.add(hm.get(key));
        }
        return ans;
    }
}