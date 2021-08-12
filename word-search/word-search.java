class Solution {
    public boolean exist(char[][] board, String word) {
        
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    board[i][j] = '$';
                    if(wordCheck(board, i, j, word, dir, 1, vis))
                    return true;
                    board[i][j] = word.charAt(0);
                }
            }
        }
        
        return false;
    }
    
    public boolean wordCheck(char[][] board, int sr, int sc, String word, int[][] dir, int idx, boolean[][] vis){
        if(idx == word.length()){
            return true;
        }
        
        vis[sr][sc] = true;
        boolean res = false;
        
        for(int i = 0; i < dir.length; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            
            if(r >= 0 && c >= 0 && r < board.length && c < board[0].length && !vis[r][c] && board[r][c] == word.charAt(idx)){     
                    res = wordCheck(board, r, c, word, dir, idx + 1, vis);
                    if(res) return true;
            }
        }
        
        vis[sr][sc] = false;
        return res;
    }
}