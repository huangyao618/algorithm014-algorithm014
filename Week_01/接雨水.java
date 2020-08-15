class Node{
    int val;
    int index;
    public Node(int val,int index){
        this.val = val;
        this.index = index;
    }
}
class Solution {
    //��������������ÿһ�����ӣ��������ұ߼���ߵ����߶ȣ��߽磩����
     public int trap(int[] height) {
         if(height==null||height.length<3) {
             return 0;
         }
        // PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());//�ռ任ʱ��
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
                 for(int j=i;j<len;j++){
                     right = Math.max(right,height[j]);
                 }
                 sum = sum + ((right>height[i])?(Math.min(left,right) - height[i]):0);
               //  queue.remove(height[i]);
             }
         }
         return sum;
     }
    //ʹ��˫ָ������¼��ǰ������߽���ұ߽�
    /*
    public int trap(int[] height) {
        int len =  height.length;
        if(len<3){
            return 0;
        }
        int left = 0;
        int right = len -1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]<leftMax){
                    ans = ans + leftMax - height[left];
                }else{
                    leftMax = height[left];
                }
                left++;
            }else{
                 if(height[right]<rightMax){
                    ans =ans + rightMax - height[right];
                }else{
                    rightMax =height[right];
                }
                right--;               
            }
        }
        return ans;
    }
    */
    //ά��һ����������ջ�������ҵ�ÿһ�����ӵ���߽�
    /*
       public int trap(int[] height) {
           if(height==null||height.length<3){
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
                       if(stack.isEmpty()) {//����ֵǰ��û��ֵ�����ڴ�������ݵ�������ô�����Ϊ�����϶�װ����ˮ
                           break;
                       }
                       sum = sum + (Math.min(height[i],stack.peek().val)-temp.val)*(i-stack.peek().index - 1);
                   }
                   //��С�ڵ�ǰֵ��������󣬰ѵ�ǰֵ����ջ
                    stack.push(new Node(height[i],i));
               }
           }
           return sum;
       } 
       */
}