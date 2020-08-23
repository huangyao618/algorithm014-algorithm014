//基于循环数据的实现方法
class MyCircularDeque {
    int[] elements = null;
    int head = 0;
    int tail = 0;
    int length = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.elements = new int[k+1];
        this.length = k+1;
        this.head = 0;//指向当前头部
        this.tail = 0;//指向尾部的下一个元素
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(this.isFull()) {
            return false;
        }
        this.head = (this.head - 1 + this.length)%this.length;//这里避免减法出现负值故先加一个capacity
        this.elements[this.head] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(this.isFull()) {
            return false;
        }
        this.elements[this.tail] = value;
        this.tail = (this.tail + 1)%this.length;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(this.isEmpty()) {
            return false;
        }
        this.head = (this.head + 1)%this.length;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(this.isEmpty()) {
            return false;
        }
        this.tail = (this.tail - 1 + this.length)%this.length;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(!this.isEmpty()) {
           return  elements[this.head];
        }
        return -1;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(!this.isEmpty()) {
           return  elements[(this.tail-1+this.length)%this.length];
        }
        return -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {//由于空和满的条件是相同的，矛盾的，因此我们可以多修改满的条件，即使会造成空间的浪费
        return this.head == this.tail;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return ((this.tail + 1)%this.length)==this.head;
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


//基于双向链表的实现
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
        return this.size==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.size==this.capacity;
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
