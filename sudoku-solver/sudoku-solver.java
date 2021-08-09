class Solution {
    
    public class Pair{
        int r;
        int c;
        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public void solveSudoku(char[][] board) {
        ArrayList<Pair> spaces = countSpaces(board);
        sudokuSolver(board, spaces, 0);
    }
    
    public boolean sudokuSolver(char[][] board, ArrayList<Pair> spaces, int idx){
         if(idx == spaces.size()){
             return true;
         }
        
        Pair p = spaces.get(idx);
        int r = p.r;
        int c = p.c;
        
        for(int i = 1; i <= 9; i++){
            if(isSafeToPlaceNum(board, r, c, i)){
                board[r][c] = (char)(i + '0');
                if(sudokuSolver(board, spaces, idx + 1)) return true;
                board[r][c] = '.';
            }
        }
        return false;
    }
    
    public boolean isSafeToPlaceNum(char[][] board, int r, int c, int num){
        for(int i = 0; i < 9; i++){
            if(board[r][i] - '0' == num){
                return false;
            }
        }
        
        for(int i = 0; i < 9; i++){
            if(board[i][c] - '0' == num){
                return false;
            }
        }
        
        r = (r / 3) * 3;
        c = (c / 3) * 3;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[r + i][c + j] - '0' == num){
                    return false;
                }
            }
        }
        
        return true;
        
    }
    
    public ArrayList<Pair> countSpaces(char[][] board){
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    arr.add(new Pair(i, j));
                }
            }
        }
        
        return arr;
    }
}