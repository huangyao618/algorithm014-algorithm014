class Solution {
    /*
    //指针法记录每一个非零项应该插入的位置;当待插入位置与非零项位置属于不同位置的时候，我们需要进行值交换（当前非零项置零），这样就可以实现零的后移操作
    //时间复杂度O（N），空间复杂度O（1）
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
    //借鉴滚雪球解法
    //记录非零项前面零项的个数，然后非零项与第一个零项交换位置即可
    //时间复杂度O（N），空间复杂度O（1）
    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length<2) return;
        int zeroNum = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) {
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
