class ListNode {
    int val;
    ListNode next;
    ListNode pre;
    public ListNode(int val) {
        this.val = val;
    }
}
class MyCircularDeque {
    int size = 0;
    int capacity = 0;
    ListNode head = null;
    ListNode tail = null; 
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = new ListNode(-1);
        this.tail = new ListNode(-1);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(this.isFull())   return false;
        ListNode temp = this.head.next;
        ListNode curNode = new ListNode(value);
        this.head.next = curNode;
        curNode.pre = this.head;
        curNode.next = temp;
        temp.pre = curNode;
        this.size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(this.isFull())    return false;
        ListNode temp = this.tail.pre;
        ListNode curNode = new ListNode(value);
        temp.next = curNode;
        curNode.pre = temp;
        curNode.next = this.tail;
        this.tail.pre = curNode;
        this.size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(this.isEmpty())   return false;
        ListNode delNode = this.head.next;
        ListNode nextNode = delNode.next;
        this.head.next = nextNode;
        nextNode.pre = this.head;
        this.size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(this.isEmpty())    return false;
        ListNode delNode = this.tail.pre;
        ListNode preNode = delNode.pre;
        preNode.next = this.tail;
        this.tail.pre = preNode;
        this.size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(this.isEmpty()) return -1;
        return this.head.next.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(this.isEmpty()) return -1;
        return this.tail.pre.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(this.size==0) return true;
        return false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(this.size==this.capacity)    return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
