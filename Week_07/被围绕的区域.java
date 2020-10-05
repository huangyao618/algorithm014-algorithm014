class Point{
    int x;
    int y;
    public Point(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class UnionFind{
    private int[] parent = null;
    private int count = 0;
    //��ʼ��
    public UnionFind(int iNum) {
        this.count = iNum;
        parent = new int[iNum];
        for(int i=0;i<iNum;i++) {
            parent[i] = i;
        }
    }

    //find,p�ĸ��ڵ�
    public int find( int p) {
        while(p!=parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    //union �ϲ�p��q
    public void union(int p,int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }
    //isCorrected
    public boolean isCorrected(int p,int q) {
        return find(p)==find(q);
    }
}
class Solution {
    //����һ��BFS
    public static int[][] DIRECTION = {{1,0},{0,-1},{-1,0},{0,1}};
    /*
    public void solve(char[][] board) {
        int iRow = board.length;
        if(iRow<1) return;//����Ϊ��
        int iColumn = board[0].length;
        boolean[][] visited = new boolean[iRow][iColumn];
        //���ĸ��߽��O��ʼ��
        //��һ��
        for(int i=0;i<iColumn;i++) {
            if(!visited[0][i]&&board[0][i]=='O') {
                helper(0,i,board,visited);
            }
        }
        //��һ��
        for(int i=1;i<iRow;i++) {
            if(!visited[i][0]&&board[i][0]=='O') {
                helper(i,0,board,visited);
            }
        }
        //��iRow-1��
        for(int i=0;i<iColumn;i++) {
            if(!visited[iRow-1][i]&&board[iRow-1][i]=='O') {
                helper(iRow-1,i,board,visited);
            }
        }
        //��iColumn-1��
        for(int i=0;i<iRow;i++) {
            if(!visited[i][iColumn-1]&&board[i][iColumn-1]=='O') {
                helper(i,iColumn-1,board,visited);
            }
        }
        for(int m=0;m<iRow;m++) {
            for(int n=0;n<iColumn;n++) {
                if(!visited[m][n]&&board[m][n]=='O') {
                    board[m][n] = 'X';
                }
            }
        }
    }
    public void helper(int i,int j,char[][] board,boolean[][] visited) {
        int iRow = board.length;
        int iColumn = board[0].length;
            visited[i][j] = true;
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(i,j));
            while(!queue.isEmpty()) {
                Point tPoint = queue.poll();
                for(int k=0;k<4;k++) {
                    int newX = tPoint.x + DIRECTION[k][0];
                    int newY = tPoint.y + DIRECTION[k][1];
                    if(newX>=0&&newX<iRow&&newY>=0&&newY<iColumn&&(!visited[newX][newY])&&board[newX][newY]=='O') {
                        visited[newX][newY] = true;
                         queue.offer(new Point(newX,newY));
                    }
                }
            }
    }
    */
    public void solve(char[][] board) {    
        int iRow = board.length;
        if(iRow<1) return;
        int iColumn = board[0].length;
        //������һ���ڵ㣬��Ϊ��ǽڵ�
        UnionFind unionFind = new UnionFind(iRow*iColumn + 1);
        int dummyNode = iRow*iColumn;

        for(int i=0;i<iRow;i++) {
            for(int j=0;j<iColumn;j++) {
                if(board[i][j]=='O') {
                    if(i==0||j==0||i==iRow-1||j==iColumn-1) {
                        //��߽������ļ���
                        unionFind.union(i*iColumn + j,dummyNode);//��߽���ͨ
                    }else {
                        for(int k=0;k<4;k++) {
                            int newX = i + DIRECTION[k][0];
                            int newY = j + DIRECTION[k][1];
                            if(newX>=0&&newX<iRow&&newY>=0&&newY<iColumn&&board[newX][newY]=='O') {
                                unionFind.union(i*iColumn+j,newX*iColumn+newY);
                            }
                        }
                    }
                }
            }
        }
        for(int m=0;m<dummyNode;m++) {
            int rowNum = m/iColumn;
            int columnNum = m%iColumn;
            if(!unionFind.isCorrected(m,dummyNode)) {
                board[rowNum][columnNum] = 'X';
            }
        }   
    }
}