class Solution {
    /*
    public boolean canJump(int[] nums) {
        if(nums.length<=1||nums==null) return true;
        boolean[] dp = new boolean[nums.length];//�Ƿ���Ե�������������λ��
        dp[0] = true;//Ĭ�Ͽ��Ե����
        for(int i=0;i<nums.length;i++) {
            if(!dp[i]) break;//���ܵ����λ��
            if(dp[i]) {//������ǰ�ߵ�������1����λ���ǿ��Ե���� 
                for(int j=1;j<=nums[i]&&i+j<nums.length;j++) {
                    if(i+j==nums.length-1) return true;//���Ե����յ�
                    dp[i+j] = true;
                }
            }
        }
        return dp[nums.length-1];
    }
    */
    //̰�ļ�¼��Զ����
    public boolean canJump(int[] nums) {
        int maxDistance = 0;//���Ե������Զλ�õ�����
        for(int i=0;i<nums.length;i++) {
            if(i>maxDistance) return false;//�����Ե���
            maxDistance = Math.max(maxDistance,i + nums[i]);//���¿��Ե������Զ����
        }
        return true;
    }
}