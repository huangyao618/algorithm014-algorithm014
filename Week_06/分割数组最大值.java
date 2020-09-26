class Solution {
    public int min = 0;
    /*
    //����һ�������ݹ鳬ʱ
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        if(len<m) return 0;
        min = Integer.MAX_VALUE;
        int[][] memo = new int[len][len];
        for(int i=0;i<len;i++) {
            for(int j=i;j<len;j++) {
                memo[i][j] = nums[j] + (i==j?0:memo[i][j-1]);
            }
        }
        getSplitArray(nums,0,0,m,0,memo);
        return min;
    }   
    public void getSplitArray(int[] datas,int segmentIndex,int numsIndex,int m,int max,int[][] memo) {
        if(segmentIndex == m) {
            min = Math.min(min,max);
            return;
        }
        if(datas.length - numsIndex< m - segmentIndex) return;
        if(segmentIndex == m-1&&numsIndex<datas.length) {
            getSplitArray(datas,segmentIndex + 1,datas.length,m,Math.max(max,memo[numsIndex][datas.length-1]),memo); 
        }else {      
            for(int i=numsIndex;i<datas.length;i++) {

                getSplitArray(datas,segmentIndex + 1,i + 1,m,Math.max(max,memo[numsIndex][i]),memo);
            }
        }
    }
    */
    /*
    //��̬�滮 
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        if(len<m) return 0;
        int[] sum = new int[len + 1];
        for(int l=1;l<=len;l++) {
            sum[l] = sum[l-1] + nums[l-1];
        }
        int[][] dp = new int[m+1][len+1];//dp[i][j],ǰj��Ԫ�طֳ�i�����������飬ʹ��j���������е����������зָ������С
        //initial
        for(int i=0;i<=m;i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }  
        dp[0][0] = 0;//����ַ�
        for(int h=1;h<=m;h++) {//ǰg��Ԫ��
            for(int g=h;g<=len;g++) {//�ֳ�h��
                for(int k=h-1;k<g;k++) {
                    dp[h][g] = Math.min(dp[h][g],Math.max(dp[h-1][k],sum[g] - sum [k]));
                }
                //System.out.println("dp["+h+"]["+g+"]:"+dp[h][g]);
            }
        }
        return dp[m][len];
    }
    */
    //���ַ�+�ض�ֵ�ķֶ���֤����֤ÿ�κͲ�����mid��������С�ڵ��ڹ涨������
    public int splitArray(int[] nums, int m) {
        int min = 0,max = 0;
        for(int i=0;i<nums.length;i++) {
            max+= nums[i];
            min = Math.min(min,nums[i]);
        }
        int left = min,right = max;
        while(left<right) {
            int mid = left + (right - left)/2;
            if(check(nums,mid,m)) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean check(int[] nums,int x,int m) {
        int segement = 0,sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum = sum + nums[i];
            if(sum > x) {
                segement++;
                sum = nums[i];
            }
            if(sum>x)  return false;//sumΪ����Ԫ����Ȼ����x������������
        }
        segement++;
        return (segement<=m);
    }
}