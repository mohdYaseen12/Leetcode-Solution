class Solution {
    public int[] sortByBits(int[] arr) {
        // apply a bitcount modifier to the array values
        for(int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 10001;
        }
        
        // sort the array, and remove the bitcount modifier
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            arr[i] %= 10001;     
        }
        
        // return the sorted array
        return arr;
    }
}