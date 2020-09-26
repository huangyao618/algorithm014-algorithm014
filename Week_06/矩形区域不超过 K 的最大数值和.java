class Solution {
    //暴力法+滚动数组
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int iRow = matrix.length;
        int iColumn = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<iColumn;i++) {//每一行的子序列起点，做为统计的区分
            int[] sum = new int[iRow];//统计序列每一行的子序列和
            for(int j=i;j<iColumn;j++) {//每一行子序列的终点
                //统计每一行，从i~j前闭后闭的序列和
                for(int k1=0;k1<iRow;k1++) {
                    sum[k1] = sum[k1] + matrix[k1][j];
                }
                int realMax = findMaxSubArr(sum);
                if(realMax==k) {
                    return realMax; 
                }
                if(realMax<k) {
                    max = Math.max(realMax,max);
                    continue;
                }
                for(int m=0;m<iRow;m++) {
                    int he = 0;
                    for(int n=m;n<iRow;n++) {
                        he = he + sum[n];
                        if(he==k) {
                            return k;
                        }
                        if(he<k) {
                            max = Math.max(max,he);
                        }
                    }
                }

            }
        }
        return max;
    }
    public int findMaxSubArr(int[] arr) {
        int len = arr.length;
        if(len<1) return 0;
        if(len==1) return arr[0];
        int dp[] = new int[len];//dp[i]表示以i结尾的子序列的最大和
        int max= Integer.MIN_VALUE;
        for(int i=0;i<len;i++) {
            if(i==0) {
                dp[i] = arr[0];
            } else {
                dp[i] = Math.max(0,dp[i-1]) + arr[i];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    /*
    //动态规划-->内存超标
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int iRow = matrix.length;
        int iColumn = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        int[][][][] dp = new int[iRow+1][iColumn+1][iRow+1][iColumn+1];
        //dp[i][j][m][n]表示（i,j）为左上角，（m,n）为右下角的矩形元素的和
        for(int i=1;i<=iRow;i++) {
            for(int j=1;j<=iColumn;j++) {
                for(int m=i;m<=iRow;m++) {
                    for(int n=j;n<=iColumn;n++) {
                        dp[i][j][m][n] = dp[i][j][m][n-1] + dp[i][j][m-1][n] - dp[i][j][m-1][n-1] + matrix[m-1][n-1];
                        if(dp[i][j][m][n]==k) return k;
                        if(dp[i][j][m][n]<k) {
                            ans = Math.max(ans,dp[i][j][m][n]);
                        }
                    }
                }
            }
        }
        return ans;
    }
    */
    /*
    //动态规划 + 状态压缩
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int iRow = matrix.length;
        int iColumn = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[iRow+1][iColumn+1];
        //dp[i][j][m][n]表示（i,j）为左上角，（m,n）为右下角的矩形元素的和
        for(int i=1;i<=iRow;i++) {
            for(int j=1;j<=iColumn;j++) {
                dp = new int[iRow+1][iColumn+1];//左上角的起点发生变化，计算的起始点变化，我们重新开始计算
                for(int m=i;m<=iRow;m++) {
                    for(int n=j;n<=iColumn;n++) {
                        dp[m][n] = dp[m][n-1] + dp[m-1][n] - dp[m-1][n-1] + matrix[m-1][n-1];
                        if(dp[m][n]==k) return k;
                        if(dp[m][n]<k) {
                            ans = Math.max(ans,dp[m][n]);
                        }
                    }
                }
            }
        }
        return ans;
    }
    */
}