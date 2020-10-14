class Solution {
    //List<List<String>> ans = null;
    /*
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        //表示右斜
        boolean[] right_45 = new boolean[2*n-1];//0-2*n
        //表示左斜
        boolean[] left_45 = new boolean[2*n-1];
        //表示列
        boolean[] column = new boolean[n];
        String[][] strs = new String[n][n];
        //Arrays.fill(arr,obj);填充引用类型的坑，这样每一个元素都指向同一个引用
       // Arrays.fill(strs[0],"\\.");
        //Arrays.fill(strs,strs[0]);//这样做每一行都相同，指向同一个引用
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                strs[i][j] = ".";
            }
        }
        //split(regx):由于是正则表达式，所有“.”,要写成“\\.”
        dfs(strs,n,0,right_45,left_45,column);
        return ans;
    }
    public void dfs(String[][] strs,int n,int index,boolean[] right_45,boolean[] left_45,boolean[] column) {
        if(index==n) {
            List<String> list = new ArrayList<>();
            for(int p=0;p<n;p++) {
                String rowStr = "";
                for(int q=0;q<n;q++ ) {
                    rowStr = rowStr + strs[p][q];
                    //System.out.println(strs[p][q]);
                }
                list.add(new String(rowStr.toCharArray()));
            }
            ans.add(list);
            return;
        }
        for(int i=index;i<n;i++) {//行
            for(int j=0;j<n;j++) {//列
                if((!right_45[i+j])&&(!left_45[i-j+n-1])&&(!column[j])) {
                    right_45[i+j] = true;
                    left_45[i-j+n-1] = true;
                    column[j] = true;
                    strs[i][j] = "Q";
                    dfs(strs,n,index+1,right_45,left_45,column);
                    right_45[i+j] = false;
                    left_45[i-j+n-1] = false;
                    column[j] = false;
                    strs[i][j] = ".";                    
                }
            }
            return;
        }
    }
    */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        String[][] strs = new String[n][n];
        int[] queues = new int[n];//用于记录每一行皇后所在的列数，queue[i]=j,表示第i行的皇后在第j列
        dfs(0,n,0,0,0,queues,ans);
        return ans;
    }
   public void dfs(int row,int n,int columns,int left_45,int right_45,int[] queues,List<List<String>> ans) {
        if(row==n) {
            List<String> list = generateBoard(queues,n);
            ans.add(list);
            return;
        }
        /*
        //
        for(int j=0;j<n;j++) {//此处column的每一个位表示每一列上是否有有皇后，以整个表为出发点
            if((column&(1<<j))==0) {//位为1表示已经有皇后，0代表没有皇后
                if((left_45&(1<<(row - j + n-1)))==0) {
                    if((right_45&(1<<(row + j)))==0) {
                        queues[row] = j;
                        dfs(row+1,n,column^(1<<j),left_45^(1<<(row - j + n -1)),right_45^(1<<(row + j)),queues,ans);
                        queues[row] = 0;                       
                    }
                }
            }

        }
        */
        //columns的位为1表示已经有皇后，
        int availablePositions = (~(columns|left_45|right_45))&((1<<n)-1);//后面与上（1<<n-1）把范围之外的高位1去掉
        for(;availablePositions!=0;availablePositions=availablePositions&(availablePositions-1)) {
            //availablePositions=availablePositions&(availablePositions-1);每次循环后把最右侧1消掉
            int newData = availablePositions&(-availablePositions);//仅仅保留最右侧1;
            int pos = Integer.bitCount(newData-1);
            queues[row] = pos;
            dfs(row+1,n,columns|newData,(left_45|newData)>>1,(right_45|newData)<<1,queues,ans);
            //(left_45|newData)>>1,整体左右移动会产生超出范围外的1，所以最上面求可以填充位置时，进行高位1清除操作（与上((1<<n)-1)显得格外必要）
            //(right_45|newData)<<1
            queues[row] = 0;
        }
        return;
    }
    public List<String> generateBoard(int[] queues,int n) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++) {//行数
            int column = queues[i];//该行皇后所在列数
            char[] rows = new char[n];
            Arrays.fill(rows,'.');
            rows[column] = 'Q';//
            String newStr = new String(rows);
            list.add(newStr);
        }
        return list;
    }
}