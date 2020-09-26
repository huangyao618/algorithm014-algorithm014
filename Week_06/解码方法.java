class Solution {
    /*
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if(chars.length<1) return 0;
        int[] dp = new int[chars.length+1];//dp[i]表示以第i个字符结尾的最大的编码方式
        dp[0] = 1;
        for(int i=1;i<=chars.length;i++) {
            if(i==1) {
                if(chars[i-1]=='0') return 0;
                dp[1] = 1;
            }else  {
                char cur = chars[i-1];
                String temp = chars[i-2] + "" + chars[i-1];
                int data = Integer.parseInt(temp);
                if(cur=='0'&&(data<1||data>26)) {
                    return 0;
                }else if(data>26||(data>=1&&data<10)) {
                    dp[i] = dp[i-1];
                } else if(data==10||data==20) {
                    dp[i] = dp[i-2];
                } else {
                    dp[i] = dp[i-1] + dp[i-2];
                }
            }
        }
        return dp[chars.length];
    }
    */
    //简单递归_超时
    //修改递归加记忆
    public int num = 0;
    public int numDecodings(String s) {
        if(s.equals("")||s==null) return 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        num = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        return helper(chars,0,len,map);
    }
    public int helper(char[] chars,int start,int length,Map<Integer,Integer> map) {
        if(start == length) {
            return 1;
        }
        if(map.containsKey(start)) {
            return map.get(start);
        }
        char cur = chars[start];
        if(cur=='0') return 0;
        if(start<length-1) {
            int data = Integer.parseInt(cur+""+chars[start+1]);
            if(data<=26) {
                map.put(start,num +helper(chars,start+2,length,map));
            }
        }
        int data_ = Integer.parseInt(cur+"");
        map.put(start,num +helper(chars,start+1,length,map));
        return 1;
    }
}