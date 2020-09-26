class Solution {
    /*
    public int countSubstrings(String s) {
        int len = s.length();
        if(s.trim().equals("")) return 0;
        char[] chars = s.toCharArray();
        boolean[][] huiWen = new boolean[len][len];
        int iNum = 0;
        for(int i=0;i<len;i++) {
            huiWen[i][i] = true;
            iNum++;
            if(i!=0&&chars[i]==chars[i-1]) {
                huiWen[i-1][i] = true;
                iNum++;
            }
        }
        for(int k=3;k<=len;k++) {
            for(int l=0;l<len-k+1;l++) {
                int m = l + k - 1;
                if(huiWen[l+1][m-1]&&chars[l]==chars[m]) {
                    huiWen[l][m] = true;
                    iNum++;
                }
            }
        }
        return iNum;
    }
    */
    //马拉车解法
    public int countSubstrings(String s) {
        int len = s.length();
        if(s.trim().equals("")) return 0;
        String newStr = _processStr(s); 
        int newLen = newStr.length();
        int[] dp = new int[newLen];
        int iCenter = 0,mirror = 0;
        int rightLimit = 0,ans = 0;
        for(int i=1;i<newLen-1;i++) {//中心要去掉两头，不然会遇到以边界为中心，这样扩张就会越界
            mirror = 2*iCenter - i;
            if(i<rightLimit) {
                dp[i] = Math.min(dp[mirror],rightLimit - i);
            }
            while(i+dp[i]+1<newLen&&i-dp[i]>0&&newStr.charAt(i+dp[i]+1)==newStr.charAt(i-dp[i]-1)) {
                dp[i]++;
            }
            if(i+dp[i]>rightLimit) {
                iCenter = i;
                rightLimit = i + dp[i];
                //System.out.println(i)
            }
            ans = ans + (dp[i] + 1)/2;
        }
        return ans;
    }
    public String _processStr(String str) {
        String delimiter = "$";
        String result = "";
        for(int i=0;i<str.length();i++) {
            result = result + delimiter + str.charAt(i);
        }
        return result + delimiter;
    }
}