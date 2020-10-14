class Solution {
    /*
    //方法一：暴力法 + 超时
    public int reversePairs(int[] nums) {
        if(nums.length<=1) return 0;
        int res = 0;
        for(int i=1;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if((((long)nums[i])<<1)<(long)nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }
    */
    //归并排序
    public int count = 0;

    public int reversePairs(int[] nums) {
        if(nums.length<=1) return 0;
        count = 0;
        mergeSort(nums,0,nums.length -1);
        return count;
    }

    public void mergeSort(int[] nums,int left,int right) {
        if(left>=right) return;
        int mid = (left + right)>>1;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }

    public void merge(int[] nums,int left,int mid,int right) {
        int[] tempArr = new int[right - left + 1];
        int i = left,j = mid + 1;
        int k = 0;
        int cnt = 0,h = j;
        for(int t=i;t<=mid;t++) {
            while(h<=right&&nums[t]/2.0>nums[h]) h++;//int/2.0编程double
            cnt = cnt + (h-j);
        }
        count = count + cnt;
        while(i<=mid&&j<=right) {
            tempArr[k++] = (nums[i]<nums[j])?nums[i++]:nums[j++];
        }
        while(i<=mid) {
            tempArr[k++] = nums[i++];
        }
        while(j<=right) {
            tempArr[k++] = nums[j++];
        }
        for(int p=0;p<tempArr.length;p++) {
            nums[left+p] = tempArr[p];
        }
    }
}