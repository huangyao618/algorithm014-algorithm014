class Node{
    int key;
    int value;
    Node next,pre;
    public Node(int key,int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    public int capacity = 0;
    public int size = 0;
    public Node fakeHead = null;
    public Node fakeTail = null;
    public Map<Integer,Node> map = null;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        fakeHead = new Node(-1,-1);
        fakeTail = new Node(-1,-1);
        fakeHead.next = fakeTail;
        fakeTail.pre = fakeHead;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            //precess
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key,value);
        if(map.containsKey(key)) {//更新不涉及容量超标
            Node node = map.get(key);
            remove(node);
            map.put(key,newNode);
            addFirst(newNode);
            return;
        }
        if(size == capacity) {
            map.remove(removeLast().key);
            this.size--;
        }
        map.put(key,newNode);
        this.size++;
        addFirst(newNode);
    }

    public Node removeLast() {
        if(this.size==0) {
            return null;
        }
        Node rmNode = fakeTail.pre;
        rmNode.pre.next = fakeTail;
        fakeTail.pre = rmNode.pre;
        return rmNode;
    }

    public void remove(Node node) {
        if(this.size==0) {
            return;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return;
    }

    public void addFirst(Node node) {
        Node head = fakeHead.next;
        fakeHead.next = node;
        node.pre = fakeHead;
        node.next = head;
        head.pre = node;
        return;
    }

    public void moveToHead(Node node) {
        remove(node);
        addFirst(node);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */