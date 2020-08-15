class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null||digits.length==0) return digits;
        int jinWei = 1;
        int len = digits.length;
        for(int i=len-1;i>=0;i--) {
            digits[i] = digits[i] + jinWei;
            jinWei  = digits[i]/10;
            digits[i] =digits[i]%10 ;
            if(jinWei==0) return digits; //�����ֽ�λΪ��ʱ���ǾͿ���ֱ�ӽ������㣬��Ϊ��������ݲ��ᱻӰ�쵽
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