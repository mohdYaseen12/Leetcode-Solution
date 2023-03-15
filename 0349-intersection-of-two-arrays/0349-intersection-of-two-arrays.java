class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        Set<Integer> intersect = new HashSet<>();
        for(int num : nums2){
            if(set.contains(num)){
                intersect.add(num);
            }
        }
        int[] res = new int[intersect.size()];
        int idx = 0;
        for(int el : intersect){
            res[idx++] = el;
        }
        return res;
    }
}