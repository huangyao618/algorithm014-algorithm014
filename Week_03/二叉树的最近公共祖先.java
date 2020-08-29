class Solution {
    //p,q���Էֳ����������λ��ͬһ�������ϣ���ֱ�λ��һ����������
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