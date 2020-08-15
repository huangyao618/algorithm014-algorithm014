class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null||digits.length==0) return digits;
        int jinWei = 1;
        int len = digits.length;
        for(int i=len-1;i>=0;i--) {
            digits[i] = digits[i] + jinWei;
            jinWei  = digits[i]/10;
            digits[i] =digits[i]%10 ;
            if(jinWei==0) return digits; //当发现进位为零时我们就可以直接结束运算，因为这面的数据不会被影响到
        }
        if(jinWei!=0) {
            int[] res = new int[len+1];
            for(int j=len;j>=1;j--)  res[j] = digits[j-1];
            res[0] = jinWei;
            return res;
        }
       return digits;
    }
}