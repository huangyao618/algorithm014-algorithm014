class  TrieNode {
    private TrieNode[] links;//��ʾ��ǰ�ڵ���Բ�ѯ������һ���ڵ�

    private boolean isEnd;//�ýڵ��Ƿ�Ϊ��ֹ�ڵ�

    public static int iSize = 26;

    public TrieNode() {
        this.links = new TrieNode[iSize];
    }

    //�жϸýڵ��Ƿ���Բ鵽��һ���ַ�
    public boolean isContainsLetter(char ch) {
        return links[ch - 'a']!=null; //������������ĸ
    }

    //�Ӹýڵ������ַ�
    public void put(char ch) {
        if(!isContainsLetter(ch)) {
           links[ch-'a'] = new TrieNode();
        }
    }

    public TrieNode getNodeByLetter(char ch) {
        if(isContainsLetter(ch)) {
            return links[ch - 'a'];
        }
        return null;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
}
class Trie {
     
     private TrieNode head = null;
    /** Initialize your data structure here. */
    public Trie() {
        head = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = head;
        int len = word.length();
        if(len<1) return;
        for(int i=0;i<len;i++) {
            char ch = word.charAt(i);
            temp.put(ch);
            temp = temp.getNodeByLetter(ch);
        }
        temp.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = head;
        int len = word.length();
        if(len<1) return true;
        for(int i=0;i<len;i++) {
            char ch = word.charAt(i);
            if(!temp.isContainsLetter(ch)) return false;
            temp = temp.getNodeByLetter(ch);
        } 
        return temp.getIsEnd();      
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = head;
        int len = prefix.length();
        if(len<1) return true;
        for(int i=0;i<len;i++) {
            char ch = prefix.charAt(i);
            if(!temp.isContainsLetter(ch)) return false;
            temp = temp.getNodeByLetter(ch);
        } 
        return true;
    }
}