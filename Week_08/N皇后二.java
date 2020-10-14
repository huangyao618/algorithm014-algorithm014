class Solution {
    //List<List<String>> ans = null;
    /*
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
    */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        String[][] strs = new String[n][n];
        int[] queues = new int[n];//���ڼ�¼ÿһ�лʺ����ڵ�������queue[i]=j,��ʾ��i�еĻʺ��ڵ�j��
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
        for(int j=0;j<n;j++) {//�˴�column��ÿһ��λ��ʾÿһ�����Ƿ����лʺ���������Ϊ������
            if((column&(1<<j))==0) {//λΪ1��ʾ�Ѿ��лʺ�0����û�лʺ�
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
        //columns��λΪ1��ʾ�Ѿ��лʺ�
        int availablePositions = (~(columns|left_45|right_45))&((1<<n)-1);//�������ϣ�1<<n-1���ѷ�Χ֮��ĸ�λ1ȥ��
        for(;availablePositions!=0;availablePositions=availablePositions&(availablePositions-1)) {
            //availablePositions=availablePositions&(availablePositions-1);ÿ��ѭ��������Ҳ�1����
            int newData = availablePositions&(-availablePositions);//�����������Ҳ�1;
            int pos = Integer.bitCount(newData-1);
            queues[row] = pos;
            dfs(row+1,n,columns|newData,(left_45|newData)>>1,(right_45|newData)<<1,queues,ans);
            //(left_45|newData)>>1,���������ƶ������������Χ���1��������������������λ��ʱ�����и�λ1�������������((1<<n)-1)�Եø����Ҫ��
            //(right_45|newData)<<1
            queues[row] = 0;
        }
        return;
    }
    public List<String> generateBoard(int[] queues,int n) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++) {//����
            int column = queues[i];//���лʺ���������
            char[] rows = new char[n];
            Arrays.fill(rows,'.');
            rows[column] = 'Q';//
            String newStr = new String(rows);
            list.add(newStr);
        }
        return list;
    }
}