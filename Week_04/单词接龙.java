class Solution {
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
}