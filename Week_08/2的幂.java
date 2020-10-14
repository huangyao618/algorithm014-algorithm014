class Solution {
    //方法一：去除最右侧1，但要明白位运算中若是有符号数存在负数的形式；仅仅符号为1（负），其他都是零表示的是最小负数，其位的形式是2的幂的形式，但却不是2的幂次方
    //有符号8位，1000000表示-128（求反再加一）
    //不考虑位运算的话，2的幂级数一定是正数
    //000000000也是一个特例，不存在1也就不能用去掉最右侧1来判断
    //使用最右侧1的前提是当前十进制数不为零（考虑非范围内1的影响）
    /*
    public boolean isPowerOfTwo(int n) {
        if(n==0) return false;     
        return (n&(n-1))==0&&(n>0);
    }
    */
    //方法二：截取最右侧1
    public boolean isPowerOfTwo(int n) {
        if(n==0) {
            return false;
        }

        return (n&(-n))==n&&n>0;
    }
}