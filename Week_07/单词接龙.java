class Solution {
    /*
    //方法二：双向BFS
     //1、从字典中遍历查找未访问相邻字符串变为固定的字母变换在查看表中是否存在
     //2、从需要遍历层次元素较少的队列开始
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size()==0||wordList==null||endWord.length()==0) return 0;
        if(!wordList.contains(endWord)) return 0;
        if(beginWord.equals(endWord))  return 1;
        if(!wordList.contains(beginWord)) wordList.add(beginWord);
        Set<String> endSet = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        Queue<String> endQueue = new LinkedList<>();
        Queue<String> beginQueue = new LinkedList<>();
        beginQueue.offer(beginWord);
        endQueue.offer(endWord);
        beginSet.add(beginWord);
        endSet.add(endWord);
        int count = 0;

        Set<String> allWordSet = new HashSet<>(wordList);

        while(!beginQueue.isEmpty()&&!endQueue.isEmpty()) {
            count++;
            //通过特性交换实现每次从最小queue开始
            if(beginQueue.size()>endQueue.size()) {
                //swap address
                //swap set
                Set<String> tempSet = beginSet;
                beginSet = endSet;
                endSet = tempSet;
                //swap queue
                Queue<String> tempQueue = beginQueue;
                beginQueue = endQueue;
                endQueue = tempQueue;
            }
            int iSize = beginQueue.size();
            for(int i=0;i<iSize;i++) {
                String strTemp = beginQueue.poll();
                char[] chars = strTemp.toCharArray();;
                for(int k=0;k<chars.length;k++) {
                    char c = chars[k];
                    for(char ch='a';ch<='z';ch++) {
                        if(ch==chars[k]) continue;
                        chars[k] = ch;
                        String newStr = new String(chars);
                        if(beginSet.contains(newStr)) continue;
                        if(endSet.contains(newStr)) return count + 1;
                        if(allWordSet.contains(newStr)) {
                            beginSet.add(newStr);
                            beginQueue.offer(newStr);
                        }
                    }
                    chars[k] = c;//恢复
                }
            }
        }  
        return 0;  
    }
    */
    ///*
    //bfs + 
   public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size()==0||wordList==null||endWord.length()==0) return 0;
        if(!wordList.contains(endWord)) return 0;
        wordList.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(beginWord);
        set.add(beginWord);

        Set<String> allWordSet = new HashSet<>(wordList);

        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for(int i=0;i<size;i++) {
                String str = queue.poll();
                char[] chars = str.toCharArray();
                for(int k=0;k<chars.length;k++) {
                    char c = chars[k];
                    for(int j=0;j<26;j++) {
                        chars[k] = (char)(j+(int)'a');
                        if(c==chars[k]) continue;
                        String newStr = new String(chars);
                        if(wordList.contains(newStr)&&!set.contains(newStr)) {
                            set.add(newStr);
                            queue.offer(newStr);
                            if(newStr.equals(endWord)) return step + 1; 
                        }
                    }
                    chars[k] = c;
                }
            }
        }
        return 0;
    }
    //*/
    /*
    //BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size()==0||wordList==null||endWord.length()==0) return 0;
        boolean isHas = false;
        for(String temp:wordList) {
            if(temp.equals(endWord)) {
                isHas = true;
                break;
            }
        }
        if(!isHas) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 0;
        boolean[] visited = new boolean[wordList.size()];
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for(int i=0;i<size;i++) {
                String str = queue.poll();
                for(int j=0;j<wordList.size();j++) {
                    if(!visited[j]&&isValidate(str,wordList.get(j))) {
                        visited[j] = true;
                        if(endWord.equals(wordList.get(j))) return step + 1;
                        queue.offer(wordList.get(j));
                    }
                }
            }
        }
        return 0;
    }
    public boolean isValidate(String str1,String str2) {
        int len = str1.length();
        if(str2.length()!=len) return false;
        int diff = 0;
        for(int i=0;i<len;i++) {
            if(str1.charAt(i)!=str2.charAt(i)) diff++;
        }
        return diff==1;
    }  
    */ 
}