class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int idx = 1;
        while(k > 0 && idx <= 10000){
            if(set.contains(idx) == false){
                idx++;
                k--;
            }
            else idx++;
        }
        return idx-1;
    }
}