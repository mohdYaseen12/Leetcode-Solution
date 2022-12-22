class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i] > 0){
                st.push(asteroids[i]);
            }
            while(st.size()>0 && st.peek() > 0 && st.peek() < -asteroids[i]){
                st.pop();
            }
            if(st.size() > 0 && st.peek() == -asteroids[i]){
                st.pop();
            }
            else if(st.size() == 0 || st.peek() < 0){
                st.push(asteroids[i]);
            }
        }
        int len = st.size();
        int[] ans = new int[len];
        for(int i = len-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}