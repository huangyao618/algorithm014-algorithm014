class Solution {
    List<List<Integer>> ans = null;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        if(nums==null||nums.length==0) return ans;
        int len = nums.length;
        //���������ͬ���ظ�����������һ��,�����õ��Ľ��Ҳ���ֵ���Ĳ���
        Arrays.sort(nums);
        boolean[] visited = new boolean[len];
        LinkedList<Integer> list = new LinkedList<>();
        dfs(nums,len,0,visited,list);
        return ans;
    }
    public void dfs(int[] nums,int len,int index,boolean[] visited,LinkedList<Integer> list) {
        if(index==len) {
            ans.add(new LinkedList<Integer>(list));
            return;
        }
        for(int i=0;i<len;i++) {
            if(!visited[i]&&!(i>0&&nums[i]==nums[i-1]&&!visited[i-1])) {
                visited[i] = true;
                list.addLast(nums[i]);
                dfs(nums,len,index+1,visited,list);
                visited[i] = false;
                //list.remove((Integer)nums[i]);
                list.removeLast();//��Ϊ���ظ�Ԫ�أ����Բ����԰�ֵ���������ͣ���ɾ�����������������������ɾ��
                //������������������ɾ��;�����������������ֵɾ��
           }
        }
        //return;
    }
}