class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        List<Integer> ans = new ArrayList<>();
        
        while(i < nums1.length && j < nums2.length){
            
            if(nums1[i] == nums2[j]){
                ans.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]){
                i++;
            }
            else j++;
        }
        
        int[] res = new int[ans.size()];
        for(int idx = 0; idx < ans.size();idx++){
            res[idx] = ans.get(idx);
        }
        return res;
    }
}