class Point{
    int x;
    int y;
    public Point(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public static final int[][]  DIRECTIONS = {{-1,0},{0,1},{1,0},{0,-1}}; 
    /*
    //方法一：BFS
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int row = grid.length;
        int column = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[row][column];
        Queue<Point> queue = new LinkedList<>();
        for(int i=0;i<row;i++) {
            for(int j=0;j<column;j++) {
                if(!visited[i][j]&&grid[i][j]=='1') {
                    queue.offer(new Point(i,j));
                    visited[i][j] = true;
                    while(!queue.isEmpty()) {
                        Point temp = queue.poll();
                        for(int k=0;k<4;k++) {
                            int new_x = temp.x + DIRECTIONS[k][0];
                            int new_y = temp.y + DIRECTIONS[k][1];
                            if(new_x>=0&&new_x<row&&new_y>=0&&new_y<column&&!visited[new_x][new_y]&&grid[new_x][new_y]=='1') {//索引是包含零的
                                visited[new_x][new_y] = true;
                                queue.offer(new Point(new_x,new_y));
                            }
                        }                      
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
    */
    /*
    //尝试DFS--递归（非手动维护栈）
    public int ans = 0;
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int row = grid.length;
        int column = grid[0].length;
        ans = 0;
        boolean[][] visited = new boolean[row][column];
        for(int i=0;i<row;i++) {
            for(int j=0;j<column;j++) {
                if(!visited[i][j]&&grid[i][j]=='1') {
                    ans++;
                    visited[i][j] = true;
                    dfs(i,j,visited,grid);
                }
            }
        }
        return ans;
    }
    public void dfs(int x,int y, boolean[][] visited,char[][] grid) {
        
         for(int k=0;k<4;k++) {
            int new_x= x + DIRECTIONS[k][0];
            int new_y = y + DIRECTIONS[k][1];
            if(new_x>=0&&new_x<visited.length&&new_y>=0&&new_y<visited[0].length&&!visited[new_x][new_y]&&grid[new_x][new_y]=='1') {//索引是包含零的
                visited[new_x][new_y] = true;
                dfs(new_x,new_y,visited,grid);
            }
        }
        return;  
    }
    */
    //DFS：代码优化,不用开辟额外空间用于记录访问状态
    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        if(row==0) return 0;
        int column = grid[0].length;
        for(int i=0;i<row;i++) {
            for(int j=0;j<column;j++) {
                if(grid[i][j]=='1') {//找到第一块陆地，
                    count++;
                    //处理，把所有与其连接的陆地都变成平地，或已访问
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    } 
    public void dfs(char[][] grid,int i,int j) {
        //terminal
        if(i<0||i>=grid.length||j<0||j>=grid[0].length) return;
        if(grid[i][j]=='0') return;
         //process
         grid[i][j] = '0';
         dfs(grid,i-1,j);
         dfs(grid,i,j-1);
         dfs(grid,i+1,j);
         dfs(grid,i,j+1);
    } 
}