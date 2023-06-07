class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length-1;
        int rowStart = 0;
        int colStart = 0;
        int col = matrix[0].length-1;
        
        while(rowStart <= row && colStart <= col){
            
            // traverse right
            for(int i=colStart; i<= col; i++){
                ans.add(matrix[rowStart][i]);
            }
            
            rowStart++;
            
            // traverse down
            for(int i = rowStart; i<=row;i++){
                ans.add(matrix[i][col]);
            }
            
            col--;
            
            if(rowStart <= row){
                // traverse left
                for(int i = col; i>= colStart;i--){
                    ans.add(matrix[row][i]);
                }
            }
            row--;
            
            if(colStart <= col){
                // traverse up
                for(int i=row;i>= rowStart;i--){
                    ans.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        return ans;
    }
}