class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int start = 0;
        int end = mat[0].length-1;
        
        while(start <= end){
            int mid = (start + end)/2;
            int row = 0;
            for(int i = 0; i< mat.length;i++){
                row = mat[i][mid] >= mat[row][mid] ? i:row;
            }
            boolean leftIsBig = mid-1 >= start && mat[row][mid-1]>mat[row][mid];
            boolean rigthIsBig = mid+1 <= end && mat[row][mid+1] > mat[row][mid];
            
            if(!leftIsBig && !rigthIsBig) // found the peak ele
                return new int[]{row,mid};
            
            else if(rigthIsBig) // rigth is big, then there is ele in right that is bigger than all the ele in the col
                start = mid+1;
            else // left is big
                end = mid-1;
        }
        return null;
    }
}