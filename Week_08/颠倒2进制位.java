public class Solution {
    /*
    // ����һ����λ��ת
    public int reverseBits(int n) {
        int ans = 0;
        for(int i=0;i<32;i++) {
            ans = ans<<1;//����λ�������ƶ�һλ��������µ�λ����ĩβ
            ans = ans + (n&1);//n&1ȡ���λֵ,��δӵ�λ����λȡ��,ȡ����ӵ�ĩβ
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
    //����˼��
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        n = ((n&0xffff0000)>>> 16) | ((n&0x0000ffff)<< 16); //������16λ�͵�16λ
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8); //ÿ��32λ�ĵ�ż����8λ������4λ����ff
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4); //ÿ��32λ�ĵ�ż����4λ������4λ����f
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2); //ÿ��32λ�ĵ�ż����2λ������2λ����1100-0011
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1); //ÿ��32λ�ĵ�ż����1λ������1λ����1010-0101
        return n;
    } 
}