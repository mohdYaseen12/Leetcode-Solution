class Solution {
    public boolean exist(char[][] board, String word) {
        for(int row = 0; row<board.length;row++){
            for(int col = 0; col<board[0].length;col++){
                if(board[row][col] == word.charAt(0) && helper_dfs(board,word,0,row,col))
                    return true;
            }
        }
        return false;
    }
    
    
    private boolean helper_dfs(char[][] board, String word, int len, int row, int col){
        if(word.length() <= len )
            return true;
        
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '0' || board[row][col] != word.charAt(len))
            return false;
        
        // visit the current character
        char tmp = board[row][col];
        board[row][col] = '0';
        
        // recursion in all four direction
        
        if(helper_dfs(board,word,len+1,row-1,col) ||
          helper_dfs(board,word,len+1,row+1,col) ||
          helper_dfs(board,word,len+1,row,col+1) ||
          helper_dfs(board,word,len+1,row,col-1))
            return true;
        
        // unvisit the current character
        board[row][col] = tmp;
        
        return false;
        
        
    }
}