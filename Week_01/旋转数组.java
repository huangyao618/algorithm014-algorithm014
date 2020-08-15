class Solution {
    /*
    //方法一，移位法，一个一个的移位,时间复杂度O（k*n）,空间复杂度O（1）
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
    //方法二 反转,整块的移位，使用整块移位中块内部相对位置不变，所以可以使用反转
    //时间复杂度O（n）,空间复杂度O（1）
    public void rotate(int[] nums,int k) {
        if(nums==null||nums.length<=1) return;       
        int len = nums.length;
        k = k%len;
        reverseArr(nums,0,len-1);//改变块之间的相对位置，单块的内部顺序被反转了
        reverseArr(nums,0,k-1);//还原块内部元素的位置
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
    //非原地处理，空间复杂度O(n),时间复杂度虽然也是O(n);
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
    //方法三：连续跳着移位，类似青蛙每次跳k格，每次把当前位置值取出，把上个位置的值放到该处，遇到重复位置则结束（结束条件处还要交换一次)
    //时间复杂度O（n）,空间复杂度O（1）
    public void rotate(int[] nums,int k) {  
        if(nums==null||nums.length<=1) return;       
        int len = nums.length;
        k = k%len;
        int count = 0;//记录交换次数，只需要交换nums.length，可以作为结束条件
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