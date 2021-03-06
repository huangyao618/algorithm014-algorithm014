class Solution {
    //p,q可以分成两种情况，位于同一课子树上，或分别位于一个左右子树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root==null||p==root||q==root)   return root;
      TreeNode  left = lowestCommonAncestor(root.left,p,q);
      TreeNode right = lowestCommonAncestor(root.right,p,q);
      if(left!=null&&right!=null) return root;
      if(left!=null) return left;
      if(right!=null) return right;
      return null;
    }
}