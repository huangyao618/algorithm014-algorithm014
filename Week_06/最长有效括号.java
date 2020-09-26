class Solution {
    //����һ����������ʱ
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
    //�ⷨ������̬�滮
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len<=1) return 0;
        //dp[i]��ʾ��i��β�����Ч�����ַ�����
        //��i��β�ķ�����Ч���ų��ȣ�dp[i]>0��ֻ������
        /*
            a��xxxxxx():��֤��β��Ч
            b��xxxxxx((rrrr))
        */
        /*
        int[] dp = new int[len];
        int maxLen = 0;
        for(int i=1;i<len;i++) {
            if(s.charAt(i)==')') {//ֻ�н�βΪ�����Ųŷ��ɹ�����Ч���Ų�����Ϊ��β
                if(s.charAt(i-1)=='(') {// xxxx()�Ŀ�����ʽ
                    dp[i] = 2 + (i-2<0?0:dp[i-2]) ;
                }else {
                    if(dp[i-1]>0&&(i-dp[i-1]-1>=0)&&s.charAt(i-dp[i-1]-1)=='(') {//xxxxx((yyyy))����ʽ
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
                    stack.push(i);//�״εĻ���˵��������-1����Ҫ�÷Ǻ���i �滻-1
                }else {
                    maxLen = Math.max(maxLen,i-stack.peek());
                }
            }
        } 
        return maxLen;    
    }
}