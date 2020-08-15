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
        //我们可以考虑新建一个链表，由于另外两个链表都是升序排列的，因此我们可以区两个链表起点最小值往后追加；
        ListNode newHead0 = new ListNode(-1);
        ListNode newHead = newHead0;
        while(l1!=null&&l2!=null) {
            if(l1.val<=l2.val) {
                newHead.next = l1;
                l1 = l1.next;
            }else {
                newHead.next = l2;
                l2 = l2.next;
            }
            newHead = newHead.next;
        }
        newHead.next = (l1==null)?l2:l1;
        return newHead0.next;
    }
    */
    //递归的思想来源于，我们每次只需要找出两个链表端部的最小值，然后在最小值所在节点后进行追加后继节点；那么这个后继节点就是更新后两个有序链表端部节点最小值，这样就形成了一个重复的过程，依次递归（循环）下去就能得到结果
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         //递归实现排序
         if(l1==null) {
             return l2;
         }
         if(l2==null) {
             return l1;
         }
         if(l1.val<l2.val) {//则在节点l1节点后追加，
             l1.next = mergeTwoLists(l1.next,l2);
             return l1;
         }else{
             l2.next = mergeTwoLists(l1,l2.next);
             return l2;
         }
     }
}
