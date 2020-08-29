class Solution {
    public List<List<Integer>> ans = null;
    //方法一;回溯法，因为此处只能和比自己大的元素组合，所以不用记录访问状态，直接从小到大开始访问

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
        //LinkedList的addFirt、addLast,removeFirst,removeLast更适合回溯法的清理现场，时间复杂度更低
        //ArrayList的remove(Object)是O（n）;而用removeLast是O（1）
        for(int i=start;i<=n;i++) {
                list.addLast(i);
                dfs(n,k,num + 1,i+1,list);//开始位置由i决定而不是start
                //dfs(n,k,num+1,start+1,list);//
                list.removeLast();
        }
        //return
    }
}