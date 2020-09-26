class Solution {
    /*
    //解法一：填充法
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(int i=0;i<tasks.length;i++) {
            freq[tasks[i]-'A']++;
        }
        Arrays.sort(freq);
        int times = 0;
        while(freq[25]>0) {
            int i=0;
            while(i<=n) {
                if(freq[25]==0) {
                    break;
                }
                if(i<26&&freq[25-i]>0) {
                    freq[25-i]--;
                }
                times++;
                i++;
            }
            Arrays.sort(freq);
        }
        return times;
    }
    */
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(int j=0;j<tasks.length;j++) {
            map[tasks[j]-'A']++;
        }
        Arrays.sort(map);
        int maxDepth = map[25] - 1,volume = maxDepth*n;
        for(int i=1;i<26;i++) {
            volume = volume - Math.min(map[25-i],maxDepth);
        }    
        return volume>0?(volume + tasks.length):tasks.length;   
    }    
}