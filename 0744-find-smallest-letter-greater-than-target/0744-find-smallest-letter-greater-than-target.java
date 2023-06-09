class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = ' ';
        int left = 0;
        int right = letters.length-1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(letters[mid] > target){
                right = mid-1;
                ans = letters[mid];
            }
            else left = mid+1;
        }
        return ans == ' ' ? letters[0] : ans;
    }
}