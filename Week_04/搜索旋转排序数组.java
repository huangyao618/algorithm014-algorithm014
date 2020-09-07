class Solution {
    //
    /*
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left<=right) {
            int mid = left + (right - left)/2;
            if(target == nums[mid]) {
                return mid;
            } else if(target>nums[mid]) {
                if(nums[mid]>=nums[left]) {
                    left = mid + 1;
                }else if(target<nums[left]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                if(nums[mid]>=nums[left]) {
                    if(target>=nums[left]) {
                        right = mid -1;
                    } else {
                        left = mid + 1;
                    }
                }else {
                    right = mid -1;
                } 
            }
        }
        return -1;
    }
    */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left<=right) {
            int mid = left + (right - left)/2;
            if(target == nums[mid]) {
                return mid;
            } else if((nums[left]<=target&&target<nums[mid])||(target<nums[mid]&&nums[mid]<nums[left])||(nums[mid]<nums[left]&&nums[left]<=target)) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }    
}