class Solution {
    public String removeStars(String str) {
        Deque<Character> dq = new ArrayDeque<>();
        for(int i = 0; i < str.length(); i++){
            char j = str.charAt(i);
            if(j == '*'){
                dq.pop();
            }else{
                dq.push(j);
            }
        }
        String ans = "";
        int size = dq.size();
        for(int i = 0; i < size ; i++){
            ans += dq.removeLast();
        }

        return ans;
    }
}