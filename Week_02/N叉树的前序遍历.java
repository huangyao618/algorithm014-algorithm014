/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    /*
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        helper(root,list);
        return list;
    }
    public void helper(Node root,List<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);
        List<Node> tempList = root.children;
        for(Node temp:tempList){
            helper(temp,list);
        }
    }
    */
   
        public List<Integer> preorder(Node root) {
            List<Integer> list = new ArrayList<>();
            LinkedList<Node> stack = new LinkedList<>();
            if(root==null){
                return list;
            }
            stack.addLast(root);
            while(!stack.isEmpty()){
                Node temp = stack.removeLast();
                list.add(temp.val);
                List<Node> children_ =temp.children;
                Collections.reverse(children_);
                for(Node node:children_){
                    stack.addLast(node);
                }
            }
            return list;
        }
}