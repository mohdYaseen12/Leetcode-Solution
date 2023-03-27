class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = (row * cols)-1;
        while(start <= end){
            int mid = (start + end) / 2;
            int r = mid / cols;
            int c = mid % cols;
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] < target) start = mid+1;
            else end = mid-1;
        }
        return false;
    }
}