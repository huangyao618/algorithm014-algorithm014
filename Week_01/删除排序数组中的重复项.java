class Solution {
    /*
    //����Ĺ�ѧ��ⷨ
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return 1;
        int len = nums.length;
        int res = 0;
        int delNum = 0;//��¼��ǰ��ǰ���ж��ٸ���Ҫɾ�����ظ���
        for(int i=0;i<len;i++) {
            if(i==0) {
                res++;
                continue;
            }
            if(nums[i]==nums[i-1]) {
                delNum++;
            }else {
                nums[i-delNum] = nums[i];
                res++;
            }
        }
        return res;
    }
    */
    public int removeDuplicates(int[] nums) {
        //ָ�뷨����һ��ָ���¼ÿһ�����ظ�����Ҫ���������λ��
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return 1;
        int len = nums.length, res = 1,i=1;
        for(int j=1;j<len;j++){
            if(nums[j]!=nums[j-1]){
                nums[i++] = nums[j];
                res++; 
            }
        }
        return res;
    }
}