class Solution {
    public boolean checkIfExist(int[] arr) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0;i<arr.length;i++){
            // check whether 2*arr[i] exists in set, if exist return true
            if(set.contains(2*arr[i]) || (arr[i]%2 == 0 && set.contains(arr[i]/2))) return true;
            // if doesn't exist add element to set
            set.add(arr[i]);
        }
        // will come to this, when there is no element present which satisfy the given condition
        return false;
    }
}