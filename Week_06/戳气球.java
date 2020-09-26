class Solution {
    /*
    ��Ҫ˼·������˼ά������������������ʱ���ݱ����У����Ѵ������򿴳��õ�����
        �����ݱ䣺1��3,1,5,8��1���������ڲ�����һ������Ȼ�����ԭ�������ڵ�������Ϊ���ڣ��������ߵڶ�������
        3*1*5 + ��1��3,5,8��1��,����һ�����ӡ����ڲ���������֪�������ڵ�����ȫ�����ߣ��ݱ�Ϊ1����1.��ô���ǿ��Է��ִ���ԭ�������ڵ������Ϊ���ڣ���ʹ���⻮��Ϊ�����ظ����������Ϊ�����ܡ���Ϊ����һ�����򣬲����ܰ�����ֳ����������⣬��һ��ԭ�������ڵ�����������һ���������
        �����ݱ䣺�����鷴���������Ӳ�������ȫ�գ��������Ϊ��ȫ�����򵽲������������Ϳ�������һ�������������������һ������ʱ����ô���Կ�����������õ��ģ���ô���ǾͿ��԰�����һ�����ָ�Ϊ��ͬ�������⣬��Ϊ�����������Ϊ����������µı߽�
        ��������������ķָʽ��foreach k i+1:j-1
                                dp[i][j] = Math.max(dp[i][j],dp[i][k]+dp[k][j]+nums[i]*nums[k]*nums[j]);
                                dp[i][j]:��ʾ���ԡ�i,j��Ϊ���ұ߽磨�м�ȫ�գ����н�λ�ò���һ���µ����򣬾Ͱ�����ָ�Ϊ�˶��������⣬ӦΪ����������Ϊ���µ�������ı߽�
    */
    public int[][] memo = null;
    public int[] nums_ = null;
    /*
    //��̬�滮
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] _nums = new int[len+2];
        for(int i=1;i<=len;i++) {
            _nums[i] = nums[i-1];
        }
        _nums[0] = 1;_nums[len+1] = 1;
        int[][] dp = new int[len+2][len+2];//dp[i][j]��ʾɾ����i-1,j-1����������Ի�õ������������
        //��״̬���̣�dp��i��[j] = dp[i][k] + dp[k][j] + _nums[i]*_nums[k]*_nums[j];dp[i][k],dp[k][j]Ҫ�ȱ�������˵��i�Ǵӵ�С������k���Ҫ�ȱ�����
        //����i<k<j����ôiҪ�Ӵ�С��������֤״̬kҪ����i��⣩��jҪ��С�����������֤ת̬k����j��⣩
        for(int m=len-1;m>=0;m--) {
            for(int n=m+2;n<=len + 1;n++) {
                for(int k=m+1;k<n;k++) {
                    dp[m][n] =Math.max(dp[m][n], dp[m][k] + dp[k][n] + _nums[m]*_nums[k]*_nums[n]);
                }
            }
        }
        return dp[0][len+1];
    }
    */
    //�ݹ� + ����
    public int maxCoins(int[] nums) {
        int len = nums.length;
        nums_ = new int[len+2];
        memo = new int[len+2][len+2];
        for(int i=1;i<=len;i++) {
            nums_[i] = nums[i-1];
        }
        for(int m=0;m<len;m++) {
            for(int n=m+2;n<=len+1;n++) {
                memo[m][n] = -1;//��ʶδ������
            }
        }
        nums_[0] = 1;nums_[len+1] = 1;
        return solve(0,len+1);
    }
    public int solve(int left,int right) {
        if(memo[left][right]!=-1) {
            return memo[left][right];
        }
        for(int k=left+1;k<right;k++) {
            int sum = nums_[left]*nums_[k]*nums_[right];
            memo[left][right] = Math.max(memo[left][right],solve(left,k) + solve(k,right) + sum);
        }
        return memo[left][right];
    }
}