/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //���ǿ��Կ����½�һ�������������������������������еģ�������ǿ������������������Сֵ����׷�ӣ�
        ListNode newHead0 = new ListNode(-1);
        ListNode newHead = newHead0;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                newHead.next = l1;
                l1 = l1.next;
            }else{
                newHead.next = l2;
                l2 = l2.next;
            }
            newHead = newHead.next;
        }
        newHead.next = (l1==null)?l2:l1;
        return newHead0.next;
    }
    */
    //�ݹ��˼����Դ�ڣ�����ÿ��ֻ��Ҫ�ҳ���������˲�����Сֵ��Ȼ������Сֵ���ڽڵ�����׷�Ӻ�̽ڵ㣻��ô�����̽ڵ���Ǹ��º�������������˲��ڵ���Сֵ���������γ���һ���ظ��Ĺ��̣����εݹ飨ѭ������ȥ���ܵõ����
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         //�ݹ�ʵ������
         if(l1==null){
             return l2;
         }
         if(l2==null){
             return l1;
         }
         if(l1.val<l2.val){//���ڽڵ�l1�ڵ��׷�ӣ�
             l1.next = mergeTwoLists(l1.next,l2);
             return l1;
         }else{
             l2.next = mergeTwoLists(l1,l2.next);
             return l2;
         }
     }
}