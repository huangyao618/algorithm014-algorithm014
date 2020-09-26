class Solution {
    /*
    主要思路：逆向思维；倒过来看整个事情时间演变序列，（把戳破气球看成拿掉气球）
        正向演变：1【3,1,5,8】1，从括号内层拿走一个气球，然后可能原本不相邻的气球会变为相邻，比如拿走第二个气球，
        3*1*5 + （1【3,5,8】1）,这样一步步从【】内部拿走气球，知道括号内的气球全被拿走，演变为1【】1.那么我们可以发现存在原本不相邻的气球变为相邻，这使问题划分为可以重复的子问题成为不可能。因为戳破一个气球，并不能把问题分成两个子问题，另一半原本不相邻的气球会对其他一层产生依赖
        反向演变：把事情反过来看，从插满气球到全空；可以理解为从全空气球到插满气球，这样就可以逆向一步步把气球插满；插入一个气球时，那么可以看成它是最后拿掉的，那么我们就可以把问题一步步分割为相同的子问题，因为插入的气球会成为待查气球的新的边界
        存在如下子问题的分割方式：foreach k i+1:j-1
                                dp[i][j] = Math.max(dp[i][j],dp[i][k]+dp[k][j]+nums[i]*nums[k]*nums[j]);
                                dp[i][j]:表示在以【i,j】为左右边界（中间全空）的中建位置插入一个新的气球，就把问题分割为了二两子问题，应为插入的气球成为了新的子问题的边界
    */
    public int[][] memo = null;
    public int[] nums_ = null;
    /*
    //动态规划
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] _nums = new int[len+2];
        for(int i=1;i<=len;i++) {
            _nums[i] = nums[i-1];
        }
        _nums[0] = 1;_nums[len+1] = 1;
        int[][] dp = new int[len+2][len+2];//dp[i][j]表示删除（i-1,j-1）的气球可以获得的最大银币数量
        //由状态方程：dp【i】[j] = dp[i][k] + dp[k][j] + _nums[i]*_nums[k]*_nums[j];dp[i][k],dp[k][j]要先遍历，则说明i是从到小遍历（k大的要先遍历）
        //由于i<k<j，那么i要从大到小遍历（保证状态k要先于i求解），j要从小到大遍历（保证转态k先于j求解）
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
    //递归 + 记忆
    public int maxCoins(int[] nums) {
        int len = nums.length;
        nums_ = new int[len+2];
        memo = new int[len+2][len+2];
        for(int i=1;i<=len;i++) {
            nums_[i] = nums[i-1];
        }
        for(int m=0;m<len;m++) {
            for(int n=m+2;n<=len+1;n++) {
                memo[m][n] = -1;//标识未被求解过
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