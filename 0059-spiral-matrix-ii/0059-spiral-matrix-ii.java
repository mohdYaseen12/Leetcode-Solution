class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        
        int row = n-1;
        int col = n-1;
        int rowStart = 0;
        int colStart = 0;
        int num = 1;
        
        while(rowStart <= row && colStart <= col){
            
            // traversing right
            for(int i=colStart; i<= col; i++){
                mat[rowStart][i] = num;
                num += 1;
            }
            rowStart++;
            
            // traversing down
            for(int i=rowStart; i<=row;i++){
                mat[i][col] = num;
                num +=  1;
            }
            col--;
            
            if(rowStart <= row){
                // traversing left
                for(int i=col;i>=colStart;i--){
                    mat[row][i] = num;
                    num += 1;
                }
            }
            row--;
            
            if(colStart <= col){
                // traversing up
                for(int i=row;i>=rowStart; i--){
                    mat[i][colStart] = num;
                    num += 1;
                }
            }
            colStart++;
        }
        return mat;
    }
}