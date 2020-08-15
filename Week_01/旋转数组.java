class Solution {
    /*
    //����һ����λ����һ��һ������λ,ʱ�临�Ӷ�O��k*n��,�ռ临�Ӷ�O��1��
    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length<=1) return;       
        int len = nums.length;
        k = k%len ;
        for(int i=0;i<k;i++) {
            int temp = nums[len-1];
            for(int j=len-1;j>0;j--) {
                nums[j] = nums[j-1];
            } 
            nums[0] = temp;
        }
    }
    */
    /*
    //������ ��ת,�������λ��ʹ��������λ�п��ڲ����λ�ò��䣬���Կ���ʹ�÷�ת
    //ʱ�临�Ӷ�O��n��,�ռ临�Ӷ�O��1��
    public void rotate(int[] nums,int k) {
        if(nums==null||nums.length<=1) return;       
        int len = nums.length;
        k = k%len;
        reverseArr(nums,0,len-1);//�ı��֮������λ�ã�������ڲ�˳�򱻷�ת��
        reverseArr(nums,0,k-1);//��ԭ���ڲ�Ԫ�ص�λ��
        reverseArr(nums,k,len-1);
    }
    public void reverseArr(int[] nums,int start,int end){
        if(start>=end) return;
        for(int i=start;i<start +(end-start+1)/2;i++) {
            int temp = nums[i];
            nums[i] = nums[end-(i-start)];
            nums[end-(i-start)] = temp;
        }  
    }
    */
    /*
    //��ԭ�ش����ռ临�Ӷ�O(n),ʱ�临�Ӷ���ȻҲ��O(n);
    public void rotate(int[] nums,int k) { 
        if(nums==null||nums.length<=1) return;       
        int len = nums.length;
        k = k%len;      
        int[] res = new int[len];
        int start = 0;
        for(int i=len-k;i<len;i++)     res[start++] = nums[i];
        for(int i=0;i<len-k;i++)       res[start++] = nums[i];
        for(int i=0;i<len;i++)         nums[i] = res[i];
        return;
    }
    */
    //������������������λ����������ÿ����k��ÿ�ΰѵ�ǰλ��ֵȡ�������ϸ�λ�õ�ֵ�ŵ��ô��������ظ�λ���������������������Ҫ����һ��)
    //ʱ�临�Ӷ�O��n��,�ռ临�Ӷ�O��1��
    public void rotate(int[] nums,int k) {  
        if(nums==null||nums.length<=1) return;       
        int len = nums.length;
        k = k%len;
        int count = 0;//��¼����������ֻ��Ҫ����nums.length��������Ϊ��������
        for(int i=0;i<len&&count<len;i++) {
           int cur = i;
           int curVal = nums[i];
           int next = (i+k)%len; 
            while(next!=i) {
                int temp = nums[next];
                nums[next] = curVal;
                curVal = temp;
                next = (next+k)%len;
                count++;
            }
            nums[i] = curVal;
            count++;
        }
        return;
    }  
}