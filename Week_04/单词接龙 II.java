class Solution {
    //dfs的解法
    List<List<String>> res = null;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        res = new LinkedList<>();
        if(!wordList.contains(endWord)) return res;
        int len = wordList.size();
        boolean[] visited = new boolean[len];
        LinkedList<String> list = new LinkedList<>();
        list.add(beginWord);
        dfs(0,len,visited,beginWord,endWord,wordList,list);
        return res;
    }
    public void dfs(int start,int end,boolean[] visited,String beginWord,String endWord,List<String> wordList,LinkedList<String> list) {
        //terminal
        if(beginWord.equals(endWord)) {
            while(res.size()!=0&&list.size()<res.get(res.size()-1).size()) {
                res.remove(res.size()-1);
            }
            if(res.size()==0||list.size()<=res.get(res.size()-1).size())
            res.add(new LinkedList<String>(list));
            return;
        }
        if(start==end) {
            return;
        }
        for(int i=0;i<end;i++) {
            if(!visited[i]&&isValidate(beginWord,wordList.get(i))) {
                visited[i] = true;
                list.addLast(wordList.get(i));
                dfs(start+1,end,visited,wordList.get(i),endWord,wordList,list);
                visited[i] = false;
                list.removeLast();
            }
        }
    }

    /*
    //bfs解法
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        res = new LinkedList<>();   
        LinkedList<String> list = new LinkedList<>();
        if(!wordList.contains(endWord)) return res;
        Queue<LinkedList<String>> queue = new LinkedList<>();
        list.add(beginWord);
        queue.offer(list);
        Set<String> library = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Set<String> subVisited = null;
        boolean isOver = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            subVisited = new HashSet<>();
            for(int j=0;j<size;j++) {//每一层之间可以重复，每个路径内部不能重复
                LinkedList<String> tempList = queue.poll();
                String tempStr = tempList.getLast();
                List<String> neighbors = getNeighbors(tempStr,library,visited);
                for(String neighbor:neighbors) {
                    if(!visited.contains(neighbor)) {
                        subVisited.add(neighbor);
                        LinkedList<String> list1 = new LinkedList<>(tempList);
                        list1.add(neighbor);
                        if(endWord.equals(neighbor)) {
                            isOver = true;
                            res.add(list1);
                            break;
                        }else if(!isOver){
                            queue.add(list1);
                        }
                    }
                }
            }
            visited.addAll(subVisited);
            if(isOver) break;
        }
        return res;
    }
    */
    private List<String> getNeighbors(String str,Set<String> library,Set<String> visited) {
        List<String> res = new ArrayList<>();
        if(str.equals("")||str==null||library.size()==0)      return res;
        for(int i=0;i<str.length();i++) {//26*str.length()：只有在libary很大，而单词长度很短的时候适用
            for(char j = 'a';j<='z';j++) {
                String newStr = str.substring(0,i) + j + str.substring(i+1,str.length());
                if(library.contains(newStr)&&!newStr.equals(str)) res.add(newStr);
            }
        }
        return res;
    }
}