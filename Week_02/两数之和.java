class Solution {
    //暴力法：时间复杂度O(N^2),空间复杂度O(1)
    /*
    public int[] twoSum(int[] nums, int target) { 
        int a[]=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    a[0]=i;a[1]=j;
                    return a;
                }
            }
        }
       return a; 
    }
    */
    public int[] twoSum(int[] nums, int target) { 
       int[] result = new int[2];
       int left = 0;
       int len = nums.length;
       if(len<2){
           return result;
       }
       Map<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<len;i++){
           int temp = nums[i];
           int diff = target - temp;
           if(map.containsKey(diff)){
               result[0] = map.get(diff);
               result[1] = i;
               return result;
           }
           map.put(temp,i);
       }
    return result;
    }
}