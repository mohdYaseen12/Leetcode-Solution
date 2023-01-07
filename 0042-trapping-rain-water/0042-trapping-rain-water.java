class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lmax = new int[n];
        lmax[0] = height[0];
        for(int i=1;i<n;i++){
            lmax[i] = Math.max(lmax[i-1],height[i]);
        }

        int[] rmax = new int[n];
        rmax[n-1] = height[n-1];
        for(int i = n-2;i>=0;i--){
            rmax[i] = Math.max(rmax[i+1],height[i]);
        }

        int totalWater = 0;
        for(int i=0;i<n;i++){
            int maxHeight = Math.min(rmax[i],lmax[i]);
            int waterHeight = maxHeight - height[i];
            int currWater = waterHeight * 1;
            totalWater = totalWater + currWater;
        }
        return totalWater;
    }
}