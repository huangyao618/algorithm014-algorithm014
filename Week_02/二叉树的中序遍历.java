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
    public List<Integer> res  = null;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        //inOrder(root);
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(true) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()) break;
                root = stack.pop();//先弹出来，
                res.add(root.val);
                root = root.right;
        }
        return res;
    }
    //递归的中序遍历
    public void inOrder(TreeNode root) {
        if(root==null) return;
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }
}