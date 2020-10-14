public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       int count = 0;
       for(;n!=0;n=n&(n-1)) {//每次循环都消除n最右侧的1，并统计消除的次数
           count++;
       } 
       return count;
    }
}