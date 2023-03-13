class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int i=0;
        int j = 0;
        int idx = 0;
        
        while(i < m && j < n){
            if(nums1[i] < nums2[j]) {
                temp[idx++] = nums1[i];
                i++;
            }
            else if(nums1[i] > nums2[j]){
                temp[idx++] = nums2[j];
                j++;
            }
            else if(nums1[i] == nums2[j]){
                temp[idx++] = nums1[i];
                temp[idx++] = nums2[j];
                i++;
                j++;
            }
        }
        
        // if some element left from nums2
        while(j < n){
            temp[idx++] = nums2[j];
            j++;
        }
        
        // if some element left from nums1;
        while(i < m){
            temp[idx++] = nums1[i];
            i++;
        }
        
        // copy temp array to nums1 array.
        for(int k=0;k<temp.length;k++){
            nums1[k] = temp[k]; 
        }
    }
}