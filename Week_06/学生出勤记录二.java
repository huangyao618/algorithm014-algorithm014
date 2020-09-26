class Solution {
    public final static int iMod = 1000000007;
    /*
    //方法一：暴力递归超时
    public int rewordNum = 0;
    public int checkRecord(int n) {
        String[] strs = {"A","L","P"};
        rewordNum = 0;
        helper(strs,n,0,0,0,"");
        return rewordNum;
    }
    public void helper(String[] strs,int len,int curIndex,int letterA,int letterL,String str) {
        if(str.contains("LLL")) return;
        if(curIndex == len) {
            rewordNum++;
            rewordNum = Math.min(rewordNum,rewordNum%iMod);
            return;
        }
        for(int i=0;i<strs.length;i++) {
            int isA=0,isL=0;
            if(strs[i].equals("A")) {
                isA = 1;
            }else if(strs[i].equals("L")) {
                isL = 1;
            } 
            if(isA==1&&letterA==1) {
                continue;
            }
            helper(strs,len,curIndex + 1,letterA + isA,letterL + isL,str + strs[i]);
        }
    }
    */
    //dongtai
    public int checkRecord(int n) {
        long[] dp_noA = new long[n+1];//dp_noA[i]表示没有A的缺勤记录下，获得奖励的最大次数
        dp_noA[0] = 1;
        long sum = 0;
        for(int i=1;i<=n;i++) {
            if(i==1) {
                dp_noA[1] = 2;
            }else if(i==2) {
                dp_noA[2] = 4;
            }else if(i==3) {
                dp_noA[3] = 7;
            }else {
                dp_noA[i] = (2*dp_noA[i-1]- dp_noA[i-4] + iMod)%iMod;
            }
        }
        sum = dp_noA[n];
        for(int j=1;j<=n;j++) {
            sum = sum + dp_noA[j-1]*dp_noA[n-j];
            sum =sum%iMod;
        }
        return (int)sum;
    }
}