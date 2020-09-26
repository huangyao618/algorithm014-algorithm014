class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1<1) return len2;
        int[][] dp = new int[len1+1][len2+1];
        int delete = 1,insert = 1,replace = 1;
        for(int i=1;i<=len2;i++) {
            dp[0][i] = i*insert;
        }
        for(int j=1;j<=len1;j++) {
            dp[j][0] = j*delete;
        }
        for(int m=1;m<=len1;m++) {
            for(int n=1;n<=len2;n++) {
                if(word1.charAt(m-1)==word2.charAt(n-1)) {
                    dp[m][n] = dp[m-1][n-1];
                }else {
                    dp[m][n] = Math.min(dp[m-1][n-1] + replace,Math.min(dp[m-1][n]+delete,dp[m][n-1]+insert));
                }
            }
        }
        return dp[len1][len2];
    }
}