class Solution {
    /*
    public boolean canJump(int[] nums) {
        if(nums.length<=1||nums==null) return true;
        boolean[] dp = new boolean[nums.length];//是否可以到达索引所处的位置
        dp[0] = true;//默认可以到达的
        for(int i=0;i<nums.length;i++) {
            if(!dp[i]) break;//不能到达该位置
            if(dp[i]) {//继续向前走的条件，1、本位置是可以到达的 
                for(int j=1;j<=nums[i]&&i+j<nums.length;j++) {
                    if(i+j==nums.length-1) return true;//可以到达终点
                    dp[i+j] = true;
                }
            }
        }
        return dp[nums.length-1];
    }
    */
    //贪心记录最远距离
    public boolean canJump(int[] nums) {
        int maxDistance = 0;//可以到达的最远位置的索引
        for(int i=0;i<nums.length;i++) {
            if(i>maxDistance) return false;//不可以到达
            maxDistance = Math.max(maxDistance,i + nums[i]);//更新可以到达的最远距离
        }
        return true;
    }
}