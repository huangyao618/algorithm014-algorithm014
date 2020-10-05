class Point{
    int x;
    int y;
    public Point(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    //方法一：dfs + 回溯
   // public LinkedList<String> res = null;
    public static int[][] iDirection = {{1,0},{0,1},{0,-1},{-1,0}};
    /*
    //BFS解法
    public List<String> findWords(char[][] board, String[] words) {
        res = new LinkedList<>();
        for(int i=0;i<words.length;i++) {
            if(canFind(words[i],board)) {
                res.addFirst(words[i]);
            }
        }
        return res;
    }
    
    public boolean canFind(String str,char[][] board) {
        int iRow = board.length;
        int iColumn = board[0].length;
        int len = str.length();
        if(len<1) return true;
        boolean[][] visited = null;
        for(int i=0;i<iRow;i++) {
            for(int j=0;j<iColumn;j++) {
              if(board[i][j] == str.charAt(0)) {//从字母头字母开始搜索
                  visited = new boolean[iRow][iColumn];
                  visited[i][j] = true;
                 if(findTarget(str,1,i,j,board,visited)) {//递归 + 回溯
                     return true;
                 }
              }   
            }
        }
        return false;
    }
    //递归 + 回溯
    public boolean findTarget(String target,int level,int posX,int posY,char[][] board,boolean[][] visited) {
        //结束条件
        if(level==target.length()) {
            return true;
        }
        //process
        for(int i=0;i<4;i++) {
            int newX = posX + iDirection[i][0];
            int newY = posY + iDirection[i][1];
            if(newX>=0&&newX<board.length&&newY>=0&&newY<board[0].length&&!(visited[newX][newY])&&target.charAt(level)==board[newX][newY]) {
                visited[newX][newY] = true;
                if(findTarget(target,level+1,newX,newY,board,visited)) {
                    return true;
                }
                //还原现场
                visited[newX][newY] = false;
            }
        }
        return false;
    }
    */
    //方法二，构建前缀树
    class TreiNode {
        private TreiNode[] links = null;
        private boolean isEnd = false;
        
        public TreiNode() {
            links = new TreiNode[26];
        }

        public boolean isContainKey(char ch) {
            return links[ch - 'a']!=null;//该元素没有实例话则为空
        }

        public void put(char ch) {
            if(!isContainKey(ch)) {
                links[ch - 'a'] = new TreiNode();
            }
        }

        public TreiNode getTreiNoeByLetter(char ch) {
            if(isContainKey(ch)) {
                return links[ch - 'a'];
            }
            return null;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean getIsEnd() {
            return isEnd;
        }
    }
    
    class Trei{

        TreiNode root = null;

        public Trei() {
            root = new TreiNode();
        }

         public void buildTrei(char[][] board) {
            int iRow = board.length;
            int iColumn = board[0].length;
            TreiNode head = root;
            for(int i=0;i<iRow;i++) {
                for(int j=0;j<iColumn;j++) {
                    head.put(board[i][j]);
                    TreiNode temp = head.getTreiNoeByLetter(board[i][j]);
                    Queue<Point> queue1 = new LinkedList<>();
                    Queue<TreiNode> queue2 = new LinkedList<>();
                    Set<String> set = new HashSet<>();
                    Set<String> subSet = null;
                    queue1.add(new Point(i,j));
                    queue2.add(temp);
                    set.add(i+""+j);
                    while(!queue1.isEmpty()) {
                        int iSize = queue1.size();
                        subSet = new HashSet();
                        for(int l=0;l<iSize;l++) {
                        	Point tPoint = queue1.poll();
                        	TreiNode tNode = queue2.poll();
                        	for(int k=0;k<4;k++) {
                        		int newX = tPoint.x + iDirection[k][0];
                        		int newY = tPoint.y + iDirection[k][1];
                        		if(newX>=0&&newX<iRow&&newY>=0&&newY<iColumn&&(!set.contains(newX+""+newY))) {
                        			tNode.put(board[newX][newY]);
                        			queue1.offer(new Point(newX,newY));
                        			queue2.offer(tNode.getTreiNoeByLetter(board[newX][newY]));
                        			//visited[newX][newY] = true;
                        			subSet.add(newX+""+newY);
                        		}
                        	}
                        }
                        set.addAll(subSet);
                    }
                }
            }
        }

        public boolean search(String str) {
            TreiNode head = root;
            for(int i=0;i<str.length();i++) {
                char ch = str.charAt(i);
                if(head.isContainKey(ch)) {
                    head = head.getTreiNoeByLetter(ch);
                }else {
                    return false;
                }
            }
            return true;
        }
    }
    
    public List<String> res = null;
    public List<String> findWords(char[][] board, String[] words) {   
        res = new ArrayList<>();
        Trei trei = new Trei();
        trei.buildTrei(board);
        int len = words.length;
        for(int i=0;i<len;i++) {
            if(trei.search(words[i])) {
                res.add(words[i]);
            }
        }
        return res;
    }
}
海市互联网违法和不良信息举报中心
