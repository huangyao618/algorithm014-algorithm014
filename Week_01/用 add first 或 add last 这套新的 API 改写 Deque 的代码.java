//ԭ��API-------ArrayDeque��ʵ�֣�����ѭ������+��̬���������С�ķ�ʽʵ�ַ���
//�䱾�����ʹ��addFist��addLast������������ָ���¼����������head��¼���鵱ǰͷ�����ڵ������±꣬tail��¼���鵱ǰβ������һ��λ�����ڵ������±�
//ע��head��¼�ĵ�ǰͷ��������tail��¼����β������һ��������λ�õ����������������ݺ�head��tail������ͬʱ��ôѭ���������β�������ˣ���ʱ����Ҫ
//�������С���ж�̬������
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