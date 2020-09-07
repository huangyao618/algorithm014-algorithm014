class Solution {
    public int ans = 0;
    /*
    //�ݹ�+���ݳ�ʱ
    public int jump(int[] nums) {
        if(nums.length<=1||nums==null) return 0;
        int res = 0;
        ans = Integer.MAX_VALUE;
        helper(nums,0,res);
        return ans;
    }
    public void helper(int[] nums,int start,int res) {
        if(start == nums.length-1) {
            ans = Math.min(res,ans);
            return;
        }
        if(nums[start] == 0) return;
        if(res+1>ans) return;
        for(int i=Math.min(nums[start],nums.length-start-1);i>0;i--) {
            helper(nums,start + i,res + 1);
        }
    }
    */
    /*
    //��̬�滮
    public int jump(int[] nums) {
        if(nums.length<=1||nums==null) return 0;
        int[] dp = new int[nums.length];//dp[i]��ʾ��i����С��Ծ����
        Arrays.fill(dp,nums.length);
        dp[0] = 0;
        for(int i=1;i<nums.length;i++) {
            for(int j=i;j>=1;j--) {//��Զ���뿪ʼ��Ծ
                if(nums[i-j]>=j) { //���Դ�dp[i-j]һ�ε���dp[i]
                    dp[i] = Math.min(dp[i-j]+1,dp[i]);//nums[]
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }   
    */
    /*
    public int jump(int[] nums) {
        int position = nums.length - 1; //Ҫ�ҵ�λ��
        int steps = 0;
        while (position != 0) { //�Ƿ��˵� 0 ��λ��
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    position = i; //����Ҫ�ҵ�λ��
                    steps++;
                    break;
                }
            }
        }
    return steps;
    }
    */
    public int jump(int[] nums) {
        if(nums.length<=1||nums==null) return 0;
        int end = 0;
        int maxPos = 0;
        int steps = 0 ;
        for(int i=0;i<nums.length-1;i++) {
            maxPos = Math.max(maxPos,i + nums[i]);
            if(i == end) {
                steps++;
                end = maxPos;
            }
        }
        return steps;
    }
}