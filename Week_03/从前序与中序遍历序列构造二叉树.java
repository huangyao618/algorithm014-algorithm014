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
    /*
    原理：由于先序遍历是：根->左子树->右子树，中序遍历是：左子树->根->右子树
    那么首先我们从先序遍历的根节点到中序遍历去寻找相同的节点，那么中序遍历中该节点左侧的为其左子树，而其
    右侧的为其右子树；我们进而将其化为了一个重复的子问题，在左子树或右子树中重复上述过程
    需要留意的地方：当中序遍历中分为左右子树时，我们可以将先序遍历也进行对应的规模划分，中序遍历中根节点左侧左子树的节点数目，就对应前序遍历中该根节点前面有多少个节点是对应于左子树的节点，那么我们可以把这些先序遍历的节点随左子树划分给它。
    */
    /*
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if(len==0) return null;
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<len;i++) {
            map.put(inorder[i],i);
        }
        return myBuildTree(map,preorder,0,len-1,inorder,0,len-1);
    }
    public TreeNode myBuildTree(Map<Integer,Integer> map,int[] preorder,int p_start,int p_end,int[] inorder,int i_start,int i_end) {
        if(p_start>p_end) return null;
        int root_index = map.get(preorder[p_start]);  
        int num = root_index - i_start;
        TreeNode root = new TreeNode(inorder[root_index]);
        root.left = myBuildTree(map,preorder,p_start+1,p_start+num,inorder,i_start,root_index-1);
        root.right = myBuildTree(map,preorder,p_start+num+1,p_end,inorder,root_index+1,i_end);
        return root;
    }
    */
    /*
    迭代法实现：
        先利用先序遍历根左右的方式建立二叉树，并把当前节点一一入栈；当前节点等于中序遍历的节点时候，说明当前左子树到了边界；
        因为中序遍历是左->根->右，那么第一点就是二叉数最左侧的节点，然后弹出节点，直到该节点不等于中序遍历的下一个对应节点
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) { 
        int len = preorder.length;
        if(len==0) return null;//边界条件
        int pre = 0;
        int in = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = new TreeNode(preorder[pre]);
        TreeNode root = curNode;
        stack.push(curNode);
        pre++;   
        while(pre<preorder.length) {
            if(curNode.val==inorder[in]) {
                while(!stack.isEmpty()&&stack.peek().val==inorder[in]) {
                    //因为中序遍历中，的左子树顺序与先序遍历的左子树顺序相反；所以一个后退（出栈），一个递增直到当前弹出元素不等于中序遍历的下一个元素或栈为空；那么就到了右子树
                    curNode = stack.pop();
                    in++;
                }
                curNode.right = new TreeNode(preorder[pre++]);
                curNode = curNode.right;
                stack.push(curNode);
            }else {
                curNode.left = new TreeNode(preorder[pre++]);
                curNode = curNode.left;
                stack.push(curNode);
            }
        } 
        return root; 
    }
}