class Solution {
    /*
    public int minPathSum(int[][] grid) {
        int iRow = grid.length;
        int iColumn = grid[0].length;
        int[][] dp = new int[iRow+1][iColumn+1];
        for(int i=0;i<=iRow;i++) {
            dp[i][0] =  Integer.MAX_VALUE;
        }
        for(int j=0;j<=iColumn;j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        dp[0][0] = 0;
        for(int i=1;i<=iRow;i++) {
            for(int j=1;j<=iColumn;j++) {
                if(i==j&&i==1) {
                    dp[i][j] = grid[i-1][j-1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[iRow][iColumn];
    }
    */
    
    //×´Ì¬Ñ¹Ëõ---Ò»Î¬Êý×é
    public int minPathSum(int[][] grid) {
        int iRow = grid.length;
        int iColumn = grid[0].length;
        int[] dp = new int[iColumn+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0;i<iRow;i++) {
            for(int j=1;j<=iColumn;j++) {
                dp[j] = Math.min(dp[j],dp[j-1]) + grid[i][j-1];
            }
            dp[0] = Integer.MAX_VALUE;
        }
        return dp[iColumn];
    }   
}