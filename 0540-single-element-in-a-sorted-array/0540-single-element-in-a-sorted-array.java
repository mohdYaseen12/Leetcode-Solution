class Solution {
    public int singleNonDuplicate(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        if(arr.length == 1) return arr[start];
        int ans = -1;
        while(start <= end){
			int mid = (start + end) / 2;
			// mid != mid+1|| mid-1
			if((mid+1 < arr.length && arr[mid] != arr[mid+1]) && (mid-1 >= 0 && arr[mid] != arr[mid -1])){
				return arr[mid];
			}
				if(mid % 2 == 0){
					if(mid+1 < arr.length && arr[mid] == arr[mid + 1]) start = mid + 1;
					else {
                        ans = arr[mid];
                        end = mid - 1;
                    }
				}
					else{
						if(mid-1 >= 0 && arr[mid] == arr[mid -1]) start = mid + 1;
						else {
                            ans = arr[mid];
                            end = mid - 1;
                        }
					}
		}
		return ans;
    }
}