class Solution {
    List<List<Integer>> ans = null;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        if(nums==null||nums.length==0) return ans;
        int len = nums.length;
        //先排序把相同的重复的数字连在一起,这样得到的结果也是字典序的不用
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
                list.removeLast();//因为有重复元素，所以不可以按值（引用类型）来删除；如果索引是整型则按索引删除
                //若果是整型则按照索引删除;如果是引用类型则按照值删除
           }
        }
        //return;
    }
}