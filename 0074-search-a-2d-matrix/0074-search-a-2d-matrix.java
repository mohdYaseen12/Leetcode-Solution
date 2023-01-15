class Solution {
    private int floor(int[][] matrix, int target){
        int start = 0;
        int end = matrix.length-1;
        int ans = -1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(matrix[mid][0] == target) return mid;
            else if(target > matrix[mid][0]){
                ans = mid;
                start = mid+1;
            }
            else end = mid-1;
        }
        return ans;
    }

    private boolean binarySearch(int[][] matrix, int target, int row){
        int start = 0;
        int end = matrix[row].length-1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] < target) start = mid+1;
            else end = mid-1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = floor(matrix,target);
        if(row == -1) return false;

        return binarySearch(matrix,target,row);
    }
}