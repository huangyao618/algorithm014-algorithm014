class Solution {
    public boolean isRight = false;
    public void solveSudoku(char[][] board) {
        int iRow = board.length;
        if(iRow<1) return ;
        int iColumn = board[0].length;
        isRight = false;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<iRow;i++) {
            for(int j=0;j<iColumn;j++) {
                if(board[i][j]=='.') {
                    list.add(i*iColumn + j);
                }
            }
        }
        helper(0,list.size(),board,list);
    }
    public void helper(int curIndex,int length,char[][] board,List<Integer> list) {
        if(curIndex == length) {
            isRight = true;
            return;
        }
        //process
        int pos = list.get(curIndex);
        int row = pos/9;
        int column = pos%9;
        for(int i=1;i<10;i++) {
            if(isCanPlace(row,column,i,board)) {
                board[row][column] = (char)(i+48);
                helper(curIndex+1,length,board,list);
                if(isRight) return;
                board[row][column] = ',';
            }
        }
        return;
    }

    public boolean isCanPlace(int row,int column,int k,char[][] board) {
        //ºá
        char ch = (char)(k+48);
        for(int i=0;i<9;i++) {
            if(board[row][i]==ch) {
                return false;
            }
        }
        //Êú
        for(int j=0;j<9;j++) {
            if(board[j][column]==ch) {
                return false;
            }
        }
        //×Ó¹¬
        int numX = row/3;
        int numY = column/3;
        for(int m = numX*3;m<numX*3+3;m++) {
            for(int n= numY*3;n<numY*3+3;n++) {
                if(board[m][n]==ch) {
                    return false;
                }
            }
        }
        return true;
    }
}