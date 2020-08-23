/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> res = null;
    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        //preOrder(root);
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root == null ) return res;
        stack.push(root);
        while(true) {
            if(stack.isEmpty()) break;
            TreeNode head = stack.pop();
            res.add(head.val);
            if(head.right!=null)    stack.push(head.right);
            if(head.left!=null)     stack.push(head.left);
        }
        return res;
    }
    public void preOrder(TreeNode root) {
        if(root==null) return;
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}