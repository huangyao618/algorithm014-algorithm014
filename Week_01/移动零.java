class Solution {
    /*
    //ָ�뷨��¼ÿһ��������Ӧ�ò����λ��;��������λ���������λ�����ڲ�ͬλ�õ�ʱ��������Ҫ����ֵ��������ǰ���������㣩�������Ϳ���ʵ����ĺ��Ʋ���
    //ʱ�临�Ӷ�O��N�����ռ临�Ӷ�O��1��
    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length<2) return;
        int i = 0;
        for(int j=0;j<nums.length;j++) {
            if(nums[j]!=0) {
                nums[i++] = nums[j];
                if(i-1!=j) {
                    nums[j] = 0;
                }
            }
        }
    }
    */
    //�����ѩ��ⷨ
    //��¼������ǰ������ĸ�����Ȼ����������һ�������λ�ü���
    //ʱ�临�Ӷ�O��N�����ռ临�Ӷ�O��1��
    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length<2) return;
        int zeroNum = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0){
                zeroNum++;
            }else {
                if(zeroNum==0) continue;
                int temp = nums[i-zeroNum];
                nums[i-zeroNum] = nums[i];
                nums[i] = temp;
            }
        }
    }
}