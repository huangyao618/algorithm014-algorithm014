class Solution {
    //public boolean isRight = false;
    public boolean isValidSudoku(char[][] board) {
        int iRow = board.length;
        if(iRow<1) return true;
        int iColumn = board[0].length;
        //isRight = false;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<iRow;i++) {
            for(int j=0;j<iColumn;j++) {
                if(board[i][j]!='.') {
                    if(!isCanPlace(i,j,board[i][j],board)) {
                        return false;
                    }
                }
            }
        }
        //helper(0,list.size(),board,list);
        return true;
    }

    public boolean isCanPlace(int row,int column,char ch,char[][] board) {
        //ºá
        for(int i=0;i<9;i++) {
            if(board[row][i]==ch&&i!=column) {
                return false;
            }
        }
        //Êú
        for(int j=0;j<9;j++) {
            if(board[j][column]==ch&&j!=row) {
                return false;
            }
        }
        //×Ó¹¬
        int numX = row/3;
        int numY = column/3;
        for(int m = numX*3;m<numX*3+3;m++) {
            for(int n= numY*3;n<numY*3+3;n++) {
                if(board[m][n]==ch&&!(m==row&&n==column)) {
                    return false;
                }
            }
        }
        return true;
    }
}