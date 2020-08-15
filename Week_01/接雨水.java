class Node {
    int val;
    int index;
    public Node(int val,int index) {
        this.val = val;
        this.index = index;
    }
}
class Solution {
    //暴力方法，遍历每一个柱子，求柱子右边及左边的最大高度（边界）即可
     public int trap(int[] height) {
         if(height==null||height.length<3) {
             return 0;
         }
        // PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());//空间换时间
         int len = height.length;
        //for(int temp:height) { queue.add(temp); }
         int sum = 0;
         int left = 0;
         int right = 0;
         for(int i=0;i<len;i++) {
             if(height[i]>left) {
                 left = height[i];
                 //queue.remove(height[i]);
             }else {
                 //right = queue.peek();
                 right = 0;
                 for(int j=i;j<len;j++) {
                     right = Math.max(right,height[j]);
                 }
                 sum = sum + ((right>height[i])?(Math.min(left,right) - height[i]):0);
               //  queue.remove(height[i]);
             }
         }
         return sum;
     }
    //使用双指针来记录当前柱子左边界和右边界
    /*
    public int trap(int[] height) {
        int len =  height.length;
        if(len<3) {
            return 0;
        }
        int left = 0;
        int right = len -1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while(left<right) {
            if(height[left]<height[right]) {
                if(height[left]<leftMax) {
                    ans = ans + leftMax - height[left];
                }else{
                    leftMax = height[left];
                }
                left++;
            }else {
                 if(height[right]<rightMax) {
                    ans =ans + rightMax - height[right];
                }else {
                    rightMax =height[right];
                }
                right--;               
            }
        }
        return ans;
    }
    */
    //维护一个单调不增栈，，已找到每一个柱子的左边界
    /*
       public int trap(int[] height) {
           if(height==null||height.length<3) {
               return 0 ;
           }
           int len = height.length;
           int sum = 0;
           Deque<Node> stack = new ArrayDeque<>();
           stack.push(new Node(height[0],0));
           for(int i=1;i<len;i++) {
               if(height[i]<=stack.peek().val) {
                   stack.push(new Node(height[i],i));
               }else {
                   while(!stack.isEmpty()&&height[i]>stack.peek().val) {
                       Node temp = stack.pop();
                       if(stack.isEmpty()) {//处理值前面没有值（大于待处理坑洼的项），则不用处理，因为这样肯定装不了水
                           break;
                       }
                       sum = sum + (Math.min(height[i],stack.peek().val)-temp.val)*(i-stack.peek().index - 1);
                   }
                   //把小于当前值都处理完后，把当前值都入栈
                    stack.push(new Node(height[i],i));
               }
           }
           return sum;
       } 
       */
}
