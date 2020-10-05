class Solution {
    List<List<String>> ans = null;
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
}