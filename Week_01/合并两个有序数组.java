class Solution {
    /*
<<<<<<< HEAD
    //指针法从后往前遍历，利用num1的空出的空间
    //时间复杂度O（n）,空间复杂度O（1）
=======
    //鎸囬拡娉曚粠鍚庡線鍓嶉亶鍘嗭紝鍒╃敤num1鐨勭┖鍑虹殑绌洪棿
    //鏃堕棿澶嶆潅搴锛坣锛�,绌洪棿澶嶆潅搴锛�1锛�
>>>>>>> 30d1cb0803461d437ab7aa5f126033593d458627
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
<<<<<<< HEAD
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
=======
    //鍐呴儴浣跨敤浜嗗綊骞舵帓搴忥紝绌洪棿澶嶆潅搴︿负O锛堬紙m+n锛塴og(m+n)锛�;绌洪棿澶嶆潅搴(1)
     public void merge(int[] nums1, int m, int[] nums2, int n) {
         System.arraycopy(nums2,0,nums1,m,n);
         //System.arraycopy(arr1,start1,arr2,start2,len)
         //arr1 瑕佽澶嶅埗鐨勬暟缁�
         //start1 澶嶅埗鐨勮捣濮嬩綅缃�
         //arr2 鐩爣鏁扮粍
         //m 琚鍒跺埌鐩爣鏁扮粍鐨勮捣濮嬩綅缃�
         //len 闇�瑕佸鍒剁殑闀垮害
         Arrays.sort(nums1);
     }   
     */
}
>>>>>>> 30d1cb0803461d437ab7aa5f126033593d458627
