class Solution {
    /*
    public int findMin(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) 
            minNum = Math.min(minNum,nums[i]);
        return minNum;
    }
    */
    /*
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(mid+1<nums.length&&nums[mid]>nums[mid+1]) {
                return nums[mid+1];
            }
            if(nums[mid]>nums[left]) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return Math.min(nums[0],nums[left]);//存在没有旋转依然处于升序的情况
    }
    */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(mid+1<nums.length&&nums[mid]>nums[mid+1]) {
                return nums[mid+1];
            }
            if(nums[mid]>nums[right]) {
                left = mid + 1;
            }else {
                right = mid;//当mid恰好是分界线时，right = mid -1 会导致错误结果
            }
        }
        return nums[left];//存在没有旋转依然处于升序的情况       
    }
}