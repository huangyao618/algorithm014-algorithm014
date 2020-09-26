class Solution {
    /*
    //�����ݹ�
    public boolean canCross(int[] stones) {
        int len = stones.length;
        if(len<=1) return true;

        return isCanCross(stones,0,0);
    }
    public boolean isCanCross(int[] stones,int index,int preJumpSize) {
        if(index == stones.length -1) {
            return true;
        }
        for(int i = index + 1;i<stones.length;i++) {//����ǰ������λ��
            int gap = stones[i] - stones[index];//����һ��ʯ�ӵļ��
            if(gap<=preJumpSize+1&&gap>=preJumpSize - 1) {//��Ϊʯ������Ϊ����������gapһ�������㣬��֤����ǰ����
                if(isCanCross(stones,i,gap)) {//̽����һ��λ��
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
            Set<Integer> set = map.get(stones[m]);//��ǰʯ�ӣ����п��ܵ�ǰһ����Ծ����
            for(Integer temp:set) {//tempΪ����i��ʯ�Ӵ�����Ծ����
                for(int n=temp -1;n<=temp+1;n++) {//��ǰ���ܵ���Ծ����
                    if(n>0&&map.containsKey(stones[m] + n)) {
                        map.get(stones[m]+n).add(n);
                    }
                }
            }
        }
        return (map.get(stones[stones.length - 1]).size()!=0);
    }    
}