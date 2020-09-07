class Point{
    int x;
    int y;
    public Point(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    private int[] directionX = {1,0,-1,0,1,-1,1,-1};
    private int[] directionY = {0,1,0,-1,1,-1,-1,1};
    /*
    //基于dfs的搜索
    public char[][] updateBoard(char[][] board, int[] click) {
        if(click==null||click.length<=1||board==null||board.length==0) return board;
        int row = click[0];
        int column = click[1];
        if(row>=board.length||row<0||column>=board[0].length||column<0) return board;
        if(board[row][column]=='M') {
            board[row][column] = 'X';
        }else {
            dfs(board,row,column);
        }
        return board;
    }

    public void dfs(char[][] board,int row,int column) {
        if(row>=board.length||row<0||column>=board[0].length||column<0||board[row][column]!='E')                       return ;//是否处理该节点
        int count = 0;
        for(int i=0;i<8;i++) {//计算是否扩展搜索的依据
            int row_ = row + directionX[i];
            int column_ = column + directionY[i];
            if(row_>=board.length||row_<0||column_>=board[0].length||column_<0) continue;
            if(board[row_][column_]=='M') count++;
        }
        if(count>0) {//判断是否继续进行搜索
            board[row][column] = (char)(count + '0');
            return;
        }
        board[row][column] = 'B';
        for(int i=0;i<8;i++) {//继续向四周八个方位扩张
           int row_ = row + directionX[i];
           int column_ = column + directionY[i];
           dfs(board,row_,column_);
        }
    }
    */
    /*
    //BFS的搜索
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0],column = click[1];
        if(board[row][column]=='M') {
            board[row][column] = 'X';
            return board;
        }else if(board[row][column]!='E') {
            return board;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        queue.offer(new int[]{row,column});
        visited[row][column] = true;
        while(!queue.isEmpty()) {
            int[] point = queue.poll();//弹出来的元素的board[x][y]='E'
            int tx = point[0];
            int ty = point[1];
            int count = 0;//用于判断是填数字还是‘B’，也用于判断是否继续进行扩张
            Set<Point> set = new HashSet<>();
            for(int i=0;i<8;i++) {//计算board[tx][ty]周围炸弹的个数
                int tx_ = tx + directionX[i];//获取其八个方向的坐标
                int ty_ = ty + directionY[i];
                if(tx_<0||tx_>=board.length|ty_<0||ty_>=board[0].length) {
                    set.add(new Point(tx_,ty_));
                    continue;//判断是否越界
                }
                if(board[tx_][ty_]!='E') {
                    set.add(new Point(tx_,ty_));
                }
                if(board[tx_][ty_]=='M') count++;
            }
            if(count>0) {//不扩张搜索
                board[tx][ty] = (char)(count + '0');
                continue;
            }
            board[tx][ty] = 'B';
            for(int j=0;j<8;j++) {//扩张
                int tx_ = tx + directionX[j];//获取其八个方向的坐标
                int ty_ = ty + directionY[j];
                //if(set.contains(new Point(tx_,ty_))) continue;
                if(tx_<0||tx_>=board.length|ty_<0||ty_>=board[0].length||board[tx_][ty_]!='E'||visited[tx_][ty_])
                 continue;       
                queue.offer(new int[]{tx_,ty_});
                visited[tx_][ty_] = true;
            }
        }
        return board;
     }
    */
    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            // 规则 1
            board[x][y] = 'X';
        } else{
            bfs(board, x, y);
        }
        return board;
    }

    public void bfs(char[][] board, int sx, int sy) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] vis = new boolean[board.length][board[0].length];
        queue.offer(new int[]{sx, sy});
        vis[sx][sy] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cnt = 0, x = pos[0], y = pos[1];
            for (int i = 0; i < 8; ++i) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                    continue;
                }
                // 不用判断 M，因为如果有 M 的话游戏已经结束了
                if (board[tx][ty] == 'M') {
                    ++cnt;
                }
            }
            if (cnt > 0) {
                // 规则 3
                board[x][y] = (char) (cnt + '0');
            } else {
                // 规则 2
                board[x][y] = 'B';
                for (int i = 0; i < 8; ++i) {
                    int tx = x + dirX[i];
                    int ty = y + dirY[i];
                    // 这里不需要在存在 B 的时候继续扩展，因为 B 之前被点击的时候已经被扩展过了
                    if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E' || vis[tx][ty]) {
                        continue;
                    }
                    queue.offer(new int[]{tx, ty});
                    vis[tx][ty] = true;
                }
            }
        }
    }
}