class Solution {
    public int[][] DIRECTION = {{0,1},{1,0},{0,-1},{-1,0}};//此处是坐标，而不是矩阵的索引
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for(int k=0;k<obstacles.length;k++) {
            String temp = obstacles[k][0] + "-" + obstacles[k][1];
            set.add(temp);
        }       
        int direction = 0;
        int len = commands.length;
        int maxLen = 0;
        int[] position = {0,0};
        for(int i=0;i<len;i++) {
            if(commands[i]>=1&&commands[i]<=9) {
                for(int j=1;j<=commands[i];j++) {
                    int tx = position[0] + DIRECTION[direction][0];
                    int ty = position[1] + DIRECTION[direction][1];
                    String strPos = tx + "-" + ty;
                    if(!set.contains(strPos)) {
                        position[0] = tx;
                        position[1] = ty;
                    }else {
                        break;
                    }
                }
            }else if(commands[i]==-2) {
                direction = (direction - 1 + 4)%4;
            }else if(commands[i]==-1) {
                direction = (direction + 1)%4;
            }
            maxLen = Math.max(maxLen,position[0]*position[0] + position[1]*position[1]);
        }
        return maxLen;
    }
}