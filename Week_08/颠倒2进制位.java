public class Solution {
    /*
    // 方法一：诸位反转
    public int reverseBits(int n) {
        int ans = 0;
        for(int i=0;i<32;i++) {
            ans = ans<<1;//所有位都向左移动一位，方便把新的位加入末尾
            ans = ans + (n&1);//n&1取最低位值,逐次从低位到高位取出,取出后加到末尾
            n = n>>1;
        }
        return ans;
    }
    */
    /*
    public int reverseBits(int n) {   
        int ans = 0;
        for(int i=0;i<32;i++) {
            // res += (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
            // res |= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
            ans ^= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0; 
        }
        return ans;
    }
    */
    //分治思想
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        n = ((n&0xffff0000)>>> 16) | ((n&0x0000ffff)<< 16); //交换高16位和低16位
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8); //每个32位的第偶数个8位与奇数4位交换ff
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4); //每个32位的第偶数个4位与奇数4位交换f
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2); //每个32位的第偶数个2位与奇数2位交换1100-0011
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1); //每个32位的第偶数个1位与奇数1位交换1010-0101
        return n;
    } 
}