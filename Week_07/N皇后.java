class Solution {
    List<List<String>> ans = null;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        //��ʾ��б
        boolean[] right_45 = new boolean[2*n-1];//0-2*n
        //��ʾ��б
        boolean[] left_45 = new boolean[2*n-1];
        //��ʾ��
        boolean[] column = new boolean[n];
        String[][] strs = new String[n][n];
        //Arrays.fill(arr,obj);����������͵Ŀӣ�����ÿһ��Ԫ�ض�ָ��ͬһ������
       // Arrays.fill(strs[0],"\\.");
        //Arrays.fill(strs,strs[0]);//������ÿһ�ж���ͬ��ָ��ͬһ������
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                strs[i][j] = ".";
            }
        }
        //split(regx):������������ʽ�����С�.��,Ҫд�ɡ�\\.��
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
        for(int i=index;i<n;i++) {//��
            for(int j=0;j<n;j++) {//��
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