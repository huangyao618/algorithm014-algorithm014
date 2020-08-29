class Solution {
    List<List<Integer>> ans = null;
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums,len,0,visited,list);
        return ans;
    }
    public void dfs(int[] nums,int len,int index,boolean[] visited,List<Integer> list) {
        if(index==len) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<len;i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums,len,index+1,visited,list);
                visited[i] = false;
                list.remove((Integer)nums[i]);//������������������ô�ǰ�������ɾ�����������������������ͣ�����ʹ��ֵ��ɾ����
            }
        }
        //return;
    }
}