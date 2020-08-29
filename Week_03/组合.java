class Solution {
    public List<List<Integer>> ans = null;
    //����һ;���ݷ�����Ϊ�˴�ֻ�ܺͱ��Լ����Ԫ����ϣ����Բ��ü�¼����״̬��ֱ�Ӵ�С����ʼ����

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        if(n<k) return ans;
        LinkedList<Integer> list = new LinkedList<>();
        dfs(n,k,0,1,list);
        return ans;
    }
    public void dfs(int n,int k,int num,int start,LinkedList<Integer> list) {
        if(num==k) {
            ans.add(new LinkedList<Integer>(list));
            return;
        }
        //LinkedList��addFirt��addLast,removeFirst,removeLast���ʺϻ��ݷ��������ֳ���ʱ�临�Ӷȸ���
        //ArrayList��remove(Object)��O��n��;����removeLast��O��1��
        for(int i=start;i<=n;i++) {
                list.addLast(i);
                dfs(n,k,num + 1,i+1,list);//��ʼλ����i����������start
                //dfs(n,k,num+1,start+1,list);//
                list.removeLast();
        }
        //return
    }
}