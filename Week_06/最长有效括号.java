class Solution {
    //方法一：暴力法超时
    /*
  public int longestValidParentheses(String s) {
        int len = s.length();
        if(len<1) return 0;
        for(int k=len;k>=1;k--) {
            for(int i=0;i<len - k +1;i++) {
                if(isValidParentheses(s.substring(i,i+k))) {
                    return k;
                }
            }
        }
        return 0;
    }
    public boolean isValidParentheses(String s) {
        Deque<String> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        if(chars.length<=1) return false;
        for(int i=0;i<chars.length;i++) {
            String temp = chars[i] + "";
            if(temp.equals("(")) {
                stack.push(temp);
            }else if(temp.equals(")")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }  
    */

    /*
    //解法二：动态规划
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len<=1) return 0;
        //dp[i]表示以i结尾的最长有效括号字符长度
        //以i结尾的非零有效符号长度（dp[i]>0）只有两种
        /*
            a、xxxxxx():保证结尾有效
            b、xxxxxx((rrrr))
        */
        /*
        int[] dp = new int[len];
        int maxLen = 0;
        for(int i=1;i<len;i++) {
            if(s.charAt(i)==')') {//只有结尾为右括号才方可构成有效括号并以其为结尾
                if(s.charAt(i-1)=='(') {// xxxx()的可能形式
                    dp[i] = 2 + (i-2<0?0:dp[i-2]) ;
                }else {
                    if(dp[i-1]>0&&(i-dp[i-1]-1>=0)&&s.charAt(i-dp[i-1]-1)=='(') {//xxxxx((yyyy))的形式
                        dp[i] = dp[i-1] + 2  + (i-dp[i-1]-2<0?0:dp[i-dp[i-1]-2]);
                    }
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
    */

    /*
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len<=1) return 0; 
        int left = 0,right = 0,maxLen=0;
        for(int i=0;i<len;i++) {
            if(s.charAt(i)==('(')) {
                left++;
            }else {
                right++;
            }
            if(left==right) {
                maxLen = Math.max(maxLen,2*left);
            }else if(right>left) {
                left = 0;
                right = 0;
            }
        } 
        left = 0;right=0;
        for(int i=len-1;i>=0;i--) {
            if(s.charAt(i)==('(')) {
                left++;
            }else {
                right++;
            }
            if(left==right) {
                maxLen = Math.max(maxLen,2*left);
            }else if(right<left) {
                left = 0;
                right = 0;
            }
        } 
        return maxLen;    
    }
    */
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len<=1) return 0; 
        Deque<Integer> stack = new ArrayDeque<>();
        int maxLen =0,popNum = 0;
        stack.push(-1);
        for(int i=0;i<len;i++) {
            if(s.charAt(i)=='(') {
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);//首次的话，说明弹出了-1，则要用非合理i 替换-1
                }else {
                    maxLen = Math.max(maxLen,i-stack.peek());
                }
            }
        } 
        return maxLen;    
    }
}