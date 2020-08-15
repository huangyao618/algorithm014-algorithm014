class Solution {
    /*
<<<<<<< HEAD
    //Ö¸Õë·¨´ÓºóÍùÇ°±éÀú£¬ÀûÓÃnum1µÄ¿Õ³öµÄ¿Õ¼ä
    //Ê±¼ä¸´ÔÓ¶ÈO£¨n£©,¿Õ¼ä¸´ÔÓ¶ÈO£¨1£©
=======
    //æŒ‡é’ˆæ³•ä»ŽåŽå¾€å‰éåŽ†ï¼Œåˆ©ç”¨num1çš„ç©ºå‡ºçš„ç©ºé—´
    //æ—¶é—´å¤æ‚åº¦Oï¼ˆnï¼‰,ç©ºé—´å¤æ‚åº¦Oï¼ˆ1ï¼‰
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
    //ÄÚ²¿Ê¹ÓÃÁË¹é²¢ÅÅÐò£¬¿Õ¼ä¸´ÔÓ¶ÈÎªO£¨£¨m+n£©log(m+n)£©;¿Õ¼ä¸´ÔÓ¶ÈO(1)
     public void merge(int[] nums1, int m, int[] nums2, int n) {
         System.arraycopy(nums2,0,nums1,m,n);
         //System.arraycopy(arr1,start1,arr2,start2,len)
         //arr1 Òª±»¸´ÖÆµÄÊý×é
         //start1 ¸´ÖÆµÄÆðÊ¼Î»ÖÃ
         //arr2 Ä¿±êÊý×é
         //m ±»¸´ÖÆµ½Ä¿±êÊý×éµÄÆðÊ¼Î»ÖÃ
         //len ÐèÒª¸´ÖÆµÄ³¤¶È
         Arrays.sort(nums1);
     }   
     */
}
=======
    //å†…éƒ¨ä½¿ç”¨äº†å½’å¹¶æŽ’åºï¼Œç©ºé—´å¤æ‚åº¦ä¸ºOï¼ˆï¼ˆm+nï¼‰log(m+n)ï¼‰;ç©ºé—´å¤æ‚åº¦O(1)
     public void merge(int[] nums1, int m, int[] nums2, int n) {
         System.arraycopy(nums2,0,nums1,m,n);
         //System.arraycopy(arr1,start1,arr2,start2,len)
         //arr1 è¦è¢«å¤åˆ¶çš„æ•°ç»„
         //start1 å¤åˆ¶çš„èµ·å§‹ä½ç½®
         //arr2 ç›®æ ‡æ•°ç»„
         //m è¢«å¤åˆ¶åˆ°ç›®æ ‡æ•°ç»„çš„èµ·å§‹ä½ç½®
         //len éœ€è¦å¤åˆ¶çš„é•¿åº¦
         Arrays.sort(nums1);
     }   
     */
}
>>>>>>> 30d1cb0803461d437ab7aa5f126033593d458627
