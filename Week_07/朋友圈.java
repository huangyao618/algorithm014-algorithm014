class Solution {
    class UnionFind{
        //记录对象集合个数
        private int count = 0;
        //记录元素个数
        private int[] parent = null;
        //初始化
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for(int i=0;i<n;i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while(p!=parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        } 

        public void union(int p,int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP==rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }
    }
    /*
    //方法一：并查集，计算独立集合个数
    public int findCircleNum(int[][] M) {
        int len = M.length;
        UnionFind unionFind = new UnionFind(len);
        for(int i=0;i<len;i++) {
            for(int j=i+1;j<len;j++) {
                if(M[i][j]==1) {
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.count;
    }
    */
    /*
    //方法二：BFS
    public int findCircleNum(int[][] M) {
        int count = 0;
        boolean[] visited = new boolean[M.length];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<M.length;i++) {
            if(!visited[i]) {
                count++;
                visited[i] = true;
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int temp = queue.poll();
                    for(int j=0;j<M.length;j++) {
                        if(!visited[j]&&M[temp][j]==1) {
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        return count;
    }
    */
    //方法三 + DFS
    public int findCircleNum(int[][] M) {
        int count = 0;
        boolean[] visited = new boolean[M.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<M.length;i++) {
            if(!visited[i]) {
                count++;
                visited[i] = true;
                stack.push(i);
                while(!stack.isEmpty()) {
                    boolean isFind = false;
                    int temp = stack.peek();
                    for(int j=0;j<M.length;j++) {
                        if(!visited[j]&&M[temp][j]==1) {
                            isFind = true;
                            visited[j] = true;
                            stack.push(j);
                        }
                    }
                    if(!isFind) stack.pop();
                }
            }
        }
        return count;
    }
}