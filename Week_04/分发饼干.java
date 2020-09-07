class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childStart = 0;
        int num = 0;
        while(true) {
            if(num>=s.length||childStart>=g.length) {
                break;
            }
            if(s[num]>=g[childStart]) {
                childStart++;
            }
            num++;
        }
        return childStart;
    }
}