class Solution {
    /*
    //指针法从后往前遍历，利用num1的空出的空间
    //时间复杂度O（n）,空间复杂度O（1）
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2==null||nums2.length==0)  return;
        int end1 = m-1, end2 = n-1,end = m+n-1;
        while(end1>=0&&end2>=0){
            if(nums1[end1]>nums2[end2]){
                nums1[end--] = nums1[end1--];
            }else{
                 nums1[end--] = nums2[end2--];              
            }
        }
        if(end1==-1){
            while(end2>=0)   nums1[end--] = nums2[end2--];

        }
    }
    */
    /*
    //内部使用了归并排序，空间复杂度为O（（m+n）log(m+n)）;空间复杂度O(1)
     public void merge(int[] nums1, int m, int[] nums2, int n) {
         System.arraycopy(nums2,0,nums1,m,n);
         //System.arraycopy(arr1,start1,arr2,start2,len)
         //arr1 要被复制的数组
         //start1 复制的起始位置
         //arr2 目标数组
         //m 被复制到目标数组的起始位置
         //len 需要复制的长度
         Arrays.sort(nums1);
     }   
     */
}