<<<<<<< HEAD
//原生API-------ArrayDeque的实现，基于循环数组+动态扩增数组大小的方式实现方法
//其本身就是使用addFist和addLast方法，用两个指针记录数组索引，head记录数组当前头部所在的索引下标，tail记录数组当前尾部的下一个位置所在的索引下表
//注意head记录的当前头部索引，tail记录的是尾部的下一个待插入位置的索引；而插入数据后head和tail索引相同时那么循环数组的首尾就相连了，这时就需要
//对数组大小进行动态的扩增
  public void addFirst(E var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         this.elements[this.head = this.head - 1 & this.elements.length - 1] = var1;
         if (this.head == this.tail) {
            this.doubleCapacity();
         }

      }
   }

   public void addLast(E var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         this.elements[this.tail] = var1;
         if ((this.tail = this.tail + 1 & this.elements.length - 1) == this.head) {
            this.doubleCapacity();
         }

      }
   }

  public E pollFirst() {
      int var1 = this.head;
      Object var2 = this.elements[var1];
      if (var2 == null) {
         return null;
      } else {
         this.elements[var1] = null;
         this.head = var1 + 1 & this.elements.length - 1;
         return var2;
      }
   }

   public E pollLast() {
      int var1 = this.tail - 1 & this.elements.length - 1;
      Object var2 = this.elements[var1];
      if (var2 == null) {
         return null;
      } else {
         this.elements[var1] = null;
         this.tail = var1;
         return var2;
      }
   }

   public E removeFirst() {
      Object var1 = this.pollFirst();
      if (var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1;
      }
   }

   public E removeLast() {
      Object var1 = this.pollLast();
      if (var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1;
      }
   }

  public E getFirst() {
      Object var1 = this.elements[this.head];
      if (var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1;
      }
   }

   public E getLast() {
      Object var1 = this.elements[this.tail - 1 & this.elements.length - 1];
      if (var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1;
      }
   }

   private void doubleCapacity() {
      assert this.head == this.tail;

      int var1 = this.head;
      int var2 = this.elements.length;
      int var3 = var2 - var1;
      int var4 = var2 << 1;
      if (var4 < 0) {
         throw new IllegalStateException("Sorry, deque too big");
      } else {
         Object[] var5 = new Object[var4];
         System.arraycopy(this.elements, var1, var5, 0, var3);
         System.arraycopy(this.elements, 0, var5, var3, var1);
         this.elements = var5;
         this.head = 0;
         this.tail = var2;
      }
   }
=======
//鍘熺敓API-------ArrayDeque鐨勫疄鐜帮紝鍩轰簬寰幆鏁扮粍+鍔ㄦ�佹墿澧炴暟缁勫ぇ灏忕殑鏂瑰紡瀹炵幇鏂规硶
//鍏舵湰韬氨鏄娇鐢╝ddFist鍜宎ddLast鏂规硶锛岀敤涓や釜鎸囬拡璁板綍鏁扮粍绱㈠紩锛宧ead璁板綍鏁扮粍褰撳墠澶撮儴鎵�鍦ㄧ殑绱㈠紩涓嬫爣锛宼ail璁板綍鏁扮粍褰撳墠灏鹃儴鐨勪笅涓�涓綅缃墍鍦ㄧ殑绱㈠紩涓嬭〃
//娉ㄦ剰head璁板綍鐨勫綋鍓嶅ご閮ㄧ储寮曪紝tail璁板綍鐨勬槸灏鹃儴鐨勪笅涓�涓緟鎻掑叆浣嶇疆鐨勭储寮曪紱鑰屾彃鍏ユ暟鎹悗head鍜宼ail绱㈠紩鐩稿悓鏃堕偅涔堝惊鐜暟缁勭殑棣栧熬灏辩浉杩炰簡锛岃繖鏃跺氨闇�瑕�
//瀵规暟缁勫ぇ灏忚繘琛屽姩鎬佺殑鎵╁
  public void addFirst(E var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         this.elements[this.head = this.head - 1 & this.elements.length - 1] = var1;
         if (this.head == this.tail) {
            this.doubleCapacity();
         }

      }
   }

   public void addLast(E var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         this.elements[this.tail] = var1;
         if ((this.tail = this.tail + 1 & this.elements.length - 1) == this.head) {
            this.doubleCapacity();
         }

      }
   }

  public E pollFirst() {
      int var1 = this.head;
      Object var2 = this.elements[var1];
      if (var2 == null) {
         return null;
      } else {
         this.elements[var1] = null;
         this.head = var1 + 1 & this.elements.length - 1;
         return var2;
      }
   }

   public E pollLast() {
      int var1 = this.tail - 1 & this.elements.length - 1;
      Object var2 = this.elements[var1];
      if (var2 == null) {
         return null;
      } else {
         this.elements[var1] = null;
         this.tail = var1;
         return var2;
      }
   }

   public E removeFirst() {
      Object var1 = this.pollFirst();
      if (var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1;
      }
   }

   public E removeLast() {
      Object var1 = this.pollLast();
      if (var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1;
      }
   }

  public E getFirst() {
      Object var1 = this.elements[this.head];
      if (var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1;
      }
   }

   public E getLast() {
      Object var1 = this.elements[this.tail - 1 & this.elements.length - 1];
      if (var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1;
      }
   }

   private void doubleCapacity() {
      assert this.head == this.tail;

      int var1 = this.head;
      int var2 = this.elements.length;
      int var3 = var2 - var1;
      int var4 = var2 << 1;
      if (var4 < 0) {
         throw new IllegalStateException("Sorry, deque too big");
      } else {
         Object[] var5 = new Object[var4];
         System.arraycopy(this.elements, var1, var5, 0, var3);
         System.arraycopy(this.elements, 0, var5, var3, var1);
         this.elements = var5;
         this.head = 0;
         this.tail = var2;
      }
   }
>>>>>>> efc277de51b07139aacad5c9d6ca6428c2576d9e
