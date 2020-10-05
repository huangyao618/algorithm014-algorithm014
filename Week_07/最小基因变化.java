class Solution {
    /*
    //双向BFS
    //1、每次通过交换使指定一端BFS最小，从该端开始
    //2、一个变量记录总BFS层数
    //3、
    public static char[] AGCT = {'A','G','C','T'};
    public int minMutation(String start, String end, String[] bank) {
        int len = bank.length;
        Set<String> allBank = new HashSet<>();
        for(int i=0;i<len;i++) {
            allBank.add(bank[i]);
        }
        if(!allBank.contains(end)) return -1;
        allBank.add(start);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Queue<String> beginQueue = new LinkedList<>();
        Queue<String> endQueue = new LinkedList<>();
        beginSet.add(start);
        endSet.add(end);
        beginQueue.offer(start);
        endQueue.offer(end);
        int count = 0;
        while(!beginQueue.isEmpty()&&!endQueue.isEmpty()) {
            count++;
            if(beginQueue.size()>endQueue.size()) {
                //swap
                Set<String> tempSet = beginSet;
                beginSet = endSet;
                endSet = tempSet;
                Queue<String> tempQueue = beginQueue;
                beginQueue = endQueue;
                endQueue = tempQueue;
            }
            int iSize = beginQueue.size();
            for(int i=0;i<iSize;i++) {
                String strTemp = beginQueue.poll();
                char[] chars = strTemp.toCharArray();
                for(int k=0;k<chars.length;k++) {
                    char c = chars[k];
                    for(int j=0;j<4;j++) {
                        chars[k] = AGCT[j];
                        String newStr = new String(chars);
                        if(beginSet.contains(newStr)) continue;
                        if(endSet.contains(newStr)) return count;
                        if(allBank.contains(newStr)) {
                            beginSet.add(newStr);
                            beginQueue.offer(newStr);
                        }
                    }
                    chars[k] = c;
                }
            }
        }
        return -1;
    }
    */
    //单向BFS
    /*
    public int minMutation(String start, String end, String[] bank) {
        if(bank==null||bank.length==0) return -1;
        int len = bank.length;
        int res = -1; 
        boolean isHasEnd =  false;
        for(int i=0;i<len;i++) {
            if(end.equals(bank[i])) {
                isHasEnd = true;
                break;
            }
        }
        if(!isHasEnd) {
            return -1;
        }else {
            Queue<String> queue = new LinkedList<>();
            boolean[] visited =new boolean[len];
            queue.offer(start);
            while(!queue.isEmpty()) {
                int size = queue.size();
                res++;
                for(int k=0;k<size;k++) {
                    String temp = queue.poll();
                    for(int i=0;i<len;i++) {
                        if(!visited[i]&&isCorrected(temp,bank[i])) {
                            visited[i] = true;
                            if(end.equals(bank[i])) return res+1;
                            queue.offer(bank[i]); 
                         }
                    }
                }
            }
            return -1;
        }
    }
    */
    //dfs
    public static int res = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        boolean isHasEnd = false;
        for(int i=0;i<bank.length;i++) {
            if(bank[i].equals(end)) isHasEnd = true;
        }
        if(!isHasEnd) return -1;
        LinkedList<String> list = new LinkedList<>();
        boolean[] visited = new boolean[bank.length];
        list.add(start);
        res = Integer.MAX_VALUE;
        dfs(end,list,bank,visited);
        return (res==Integer.MAX_VALUE)?-1:res - 1;
    }

    public void dfs(String end,LinkedList<String> list,String[] bank,boolean[] visited) {
        if(end.equals(list.getLast())) {
            res = Math.min(res,list.size());//每次储存结果都要新开辟一个空间，不然只是复制了地址，结果会随该引用类型时刻发生变化
            return;
        }
        String strTemp = list.getLast();
        for(int i=0;i<bank.length;i++) {
            if(!visited[i]&&isCorrected(strTemp,bank[i])) {
                list.addLast(bank[i]);
                visited[i] = true;
                dfs(end,list,bank,visited);
                list.removeLast();
                visited[i] = false;
            }
        }
        return;
    }

    public boolean isCorrected(String str1,String str2) {
        if(str1.length()!=8||str2.length()!=8)   return false;
        int diff = 0;
        for(int i=0;i<8;i++) 
           if(str1.charAt(i)!=str2.charAt(i)) diff++;
        return diff==1;
    }
}
