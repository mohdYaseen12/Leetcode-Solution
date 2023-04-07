class NumArray {
    int[] a;
    public NumArray(int[] nums) {
        a = nums;
        for(int i=1;i<nums.length;i++){
            a[i] = a[i-1] + a[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left - 1 >= 0) return a[right] - a[left-1];
        else return a[right];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */