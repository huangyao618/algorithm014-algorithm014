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
    ԭ��������������ǣ���->������->����������������ǣ�������->��->������
    ��ô�������Ǵ���������ĸ��ڵ㵽�������ȥѰ����ͬ�Ľڵ㣬��ô��������иýڵ�����Ϊ��������������
    �Ҳ��Ϊ�������������ǽ������仯Ϊ��һ���ظ��������⣬�������������������ظ���������
    ��Ҫ����ĵط�������������з�Ϊ��������ʱ�����ǿ��Խ��������Ҳ���ж�Ӧ�Ĺ�ģ���֣���������и��ڵ�����������Ľڵ���Ŀ���Ͷ�Ӧǰ������иø��ڵ�ǰ���ж��ٸ��ڵ��Ƕ�Ӧ���������Ľڵ㣬��ô���ǿ��԰���Щ��������Ľڵ������������ָ�����
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
    ������ʵ�֣�
        ������������������ҵķ�ʽ���������������ѵ�ǰ�ڵ�һһ��ջ����ǰ�ڵ������������Ľڵ�ʱ��˵����ǰ���������˱߽磻
        ��Ϊ�����������->��->�ң���ô��һ����Ƕ����������Ľڵ㣬Ȼ�󵯳��ڵ㣬ֱ���ýڵ㲻���������������һ����Ӧ�ڵ�
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) { 
        int len = preorder.length;
        if(len==0) return null;//�߽�����
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
                    //��Ϊ��������У���������˳�������������������˳���෴������һ�����ˣ���ջ����һ������ֱ����ǰ����Ԫ�ز����������������һ��Ԫ�ػ�ջΪ�գ���ô�͵���������
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