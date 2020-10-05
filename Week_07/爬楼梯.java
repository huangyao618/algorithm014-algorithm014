    //动态规划；状态方程为：dp[n] = dp[n-1] + dp[n-2];代表上n步阶梯等于第一步上一阶和第一步上两阶
    //状态压缩，因为每一个状态只和上两个转态相关
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int num1 = 1, num2 = 1;
        int num3 = 0;
        for(int i=2;i<=n;i++){
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
        return num3;
    }