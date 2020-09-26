class Solution {
    //������+��������
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int iRow = matrix.length;
        int iColumn = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<iColumn;i++) {//ÿһ�е���������㣬��Ϊͳ�Ƶ�����
            int[] sum = new int[iRow];//ͳ������ÿһ�е������к�
            for(int j=i;j<iColumn;j++) {//ÿһ�������е��յ�
                //ͳ��ÿһ�У���i~jǰ�պ�յ����к�
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
        int dp[] = new int[len];//dp[i]��ʾ��i��β�������е�����
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
    //��̬�滮-->�ڴ泬��
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int iRow = matrix.length;
        int iColumn = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        int[][][][] dp = new int[iRow+1][iColumn+1][iRow+1][iColumn+1];
        //dp[i][j][m][n]��ʾ��i,j��Ϊ���Ͻǣ���m,n��Ϊ���½ǵľ���Ԫ�صĺ�
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
    //��̬�滮 + ״̬ѹ��
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int iRow = matrix.length;
        int iColumn = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[iRow+1][iColumn+1];
        //dp[i][j][m][n]��ʾ��i,j��Ϊ���Ͻǣ���m,n��Ϊ���½ǵľ���Ԫ�صĺ�
        for(int i=1;i<=iRow;i++) {
            for(int j=1;j<=iColumn;j++) {
                dp = new int[iRow+1][iColumn+1];//���Ͻǵ���㷢���仯���������ʼ��仯���������¿�ʼ����
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