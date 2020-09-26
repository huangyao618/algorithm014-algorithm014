class Solution {
    /*
    //暴力递归
    public boolean canCross(int[] stones) {
        int len = stones.length;
        if(len<=1) return true;

        return isCanCross(stones,0,0);
    }
    public boolean isCanCross(int[] stones,int index,int preJumpSize) {
        if(index == stones.length -1) {
            return true;
        }
        for(int i = index + 1;i<stones.length;i++) {//可能前进到的位置
            int gap = stones[i] - stones[index];//与上一个石子的间隔
            if(gap<=preJumpSize+1&&gap>=preJumpSize - 1) {//因为石子排列为升序，所以其gap一定大于零，保证其是前进的
                if(isCanCross(stones,i,gap)) {//探索下一个位置
                    return true;
                }
            }
        }
        return false;
    }
    */
  /*
  public boolean canCross(int[] stones) {
        int[][] memo = new int[stones.length][stones.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return can_Cross(stones, 0, 0, memo) == 1;
    }
    public int can_Cross(int[] stones, int ind, int jumpsize, int[][] memo) {
        if (memo[ind][jumpsize] >= 0) {
            return memo[ind][jumpsize];
        }
        for (int i = ind + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[ind];
            if (gap >= jumpsize - 1 && gap <= jumpsize + 1) {
                if (can_Cross(stones, i, gap, memo) == 1) {
                    memo[ind][gap] = 1;
                    return 1;
                }
            }
        }
        memo[ind][jumpsize] = (ind == stones.length - 1) ? 1 : 0;
        return memo[ind][jumpsize];
    } 
    */
    public boolean canCross(int[] stones) {
        Map<Integer,HashSet<Integer>> map = new HashMap<>();
        for(int i=0;i<stones.length;i++) {
            map.put(stones[i],new HashSet<Integer>());
        }
        map.get(0).add(0);
        for(int m=0;m<stones.length-1;m++) {
            Set<Integer> set = map.get(stones[m]);//当前石子，所有可能的前一步跳跃距离
            for(Integer temp:set) {//temp为到达i个石子处的跳跃距离
                for(int n=temp -1;n<=temp+1;n++) {//当前可能的跳跃距离
                    if(n>0&&map.containsKey(stones[m] + n)) {
                        map.get(stones[m]+n).add(n);
                    }
                }
            }
        }
        return (map.get(stones[stones.length - 1]).size()!=0);
    }    
}