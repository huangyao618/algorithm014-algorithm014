    //��̬�滮��״̬����Ϊ��dp[n] = dp[n-1] + dp[n-2];������n�����ݵ��ڵ�һ����һ�׺͵�һ��������
    //״̬ѹ������Ϊÿһ��״ֻ̬��������ת̬���
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