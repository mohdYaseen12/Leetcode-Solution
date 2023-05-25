class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int water = Integer.MIN_VALUE;
        
        while(left < right){
            int width = right-left;
            int high = Math.min(height[left],height[right]);
            int area = width * high;
            water = Math.max(water,area);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return water;
    }
}