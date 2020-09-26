class Solution {
    /*
    //��̬�滮��״̬����dp[i][j][0],��ʾ�Ե㣨i��j����Ϊ�յ㣬���������1�ĸ�������������
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length<1) return 0;
        int iRow = matrix.length;
        int iColumn = matrix[0].length;
        int[][][] dp = new int[iRow+1][iColumn+1][2];
        //dp[i][j][0] ��ʾ�Ե㣨i��j����Ϊ�յ㣬���������1�ĸ�������������
        //dp[i][j][1] ��ʾ�Ե㣨i,j����Ϊ�յ㣬���Ϸ�����1�ĸ�������������
        int maxEdge = 0;
        for(int i=1;i<=iRow;i++) {
            for(int j=1;j<=iColumn;j++) {
                if(matrix[i-1][j-1]=='1') {
                    dp[i][j][0] = dp[i][j-1][0] + 1;
                    dp[i][j][1] = dp[i-1][j][1] + 1;
                    int left_upper = Math.min(dp[i][j][0],dp[i][j][1]);
                    for(int edge = maxEdge+1;edge<=left_upper;edge++) {
                        boolean isSquare = true;
                        for(int offset =1;offset<edge;offset++) {
                            if(dp[i][j-offset][1]<edge) {
                                isSquare = false;
                                break;
                            }
                        }
                        if(isSquare) {
                            maxEdge = Math.max(edge,maxEdge);
                        }
                    }
                }
            }
        }
        return maxEdge*maxEdge;
    }
    */
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length<1) return 0;
        int iRow = matrix.length;
        int iColumn = matrix[0].length;    
        int[][] dp = new int[iRow+1][iColumn+1];
        int maxEdge = 0;
        //dp[i][j]Ϊmatrix[i-1][j-1]Ϊ����������������Ŀ
        for(int i=1;i<=iRow;i++) {
            for(int j=1;j<=iColumn;j++) {
                if(matrix[i-1][j-1]=='1') {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                    maxEdge = Math.max(maxEdge,dp[i][j]);
                }
            }
        }  
        return maxEdge*maxEdge;    
    }
}