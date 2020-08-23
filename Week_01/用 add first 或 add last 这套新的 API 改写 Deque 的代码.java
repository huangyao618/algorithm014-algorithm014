<<<<<<< HEAD
//Ô­ÉúAPI-------ArrayDequeµÄÊµÏÖ£¬»ùÓÚÑ­»·Êý×é+¶¯Ì¬À©ÔöÊý×é´óÐ¡µÄ·½Ê½ÊµÏÖ·½·¨
//Æä±¾Éí¾ÍÊÇÊ¹ÓÃaddFistºÍaddLast·½·¨£¬ÓÃÁ½¸öÖ¸Õë¼ÇÂ¼Êý×éË÷Òý£¬head¼ÇÂ¼Êý×éµ±Ç°Í·²¿ËùÔÚµÄË÷ÒýÏÂ±ê£¬tail¼ÇÂ¼Êý×éµ±Ç°Î²²¿µÄÏÂÒ»¸öÎ»ÖÃËùÔÚµÄË÷ÒýÏÂ±í
//×¢Òâhead¼ÇÂ¼µÄµ±Ç°Í·²¿Ë÷Òý£¬tail¼ÇÂ¼µÄÊÇÎ²²¿µÄÏÂÒ»¸ö´ý²åÈëÎ»ÖÃµÄË÷Òý£»¶ø²åÈëÊý¾ÝºóheadºÍtailË÷ÒýÏàÍ¬Ê±ÄÇÃ´Ñ­»·Êý×éµÄÊ×Î²¾ÍÏàÁ¬ÁË£¬ÕâÊ±¾ÍÐèÒª
//¶ÔÊý×é´óÐ¡½øÐÐ¶¯Ì¬µÄÀ©Ôö
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
//åŽŸç”ŸAPI-------ArrayDequeçš„å®žçŽ°ï¼ŒåŸºäºŽå¾ªçŽ¯æ•°ç»„+åŠ¨æ€æ‰©å¢žæ•°ç»„å¤§å°çš„æ–¹å¼å®žçŽ°æ–¹æ³•
//å…¶æœ¬èº«å°±æ˜¯ä½¿ç”¨addFistå’ŒaddLastæ–¹æ³•ï¼Œç”¨ä¸¤ä¸ªæŒ‡é’ˆè®°å½•æ•°ç»„ç´¢å¼•ï¼Œheadè®°å½•æ•°ç»„å½“å‰å¤´éƒ¨æ‰€åœ¨çš„ç´¢å¼•ä¸‹æ ‡ï¼Œtailè®°å½•æ•°ç»„å½“å‰å°¾éƒ¨çš„ä¸‹ä¸€ä¸ªä½ç½®æ‰€åœ¨çš„ç´¢å¼•ä¸‹è¡¨
//æ³¨æ„headè®°å½•çš„å½“å‰å¤´éƒ¨ç´¢å¼•ï¼Œtailè®°å½•çš„æ˜¯å°¾éƒ¨çš„ä¸‹ä¸€ä¸ªå¾…æ’å…¥ä½ç½®çš„ç´¢å¼•ï¼›è€Œæ’å…¥æ•°æ®åŽheadå’Œtailç´¢å¼•ç›¸åŒæ—¶é‚£ä¹ˆå¾ªçŽ¯æ•°ç»„çš„é¦–å°¾å°±ç›¸è¿žäº†ï¼Œè¿™æ—¶å°±éœ€è¦
//å¯¹æ•°ç»„å¤§å°è¿›è¡ŒåŠ¨æ€çš„æ‰©å¢ž
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
