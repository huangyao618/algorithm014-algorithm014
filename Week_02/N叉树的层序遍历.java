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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = null;
        while(!queue.isEmpty()) {
            list = new ArrayList<>();
            int len = queue.size();
            for(int i=0;i<len;i++) {
                Node temp = queue.poll();
                list.add(temp.val);
                for(Node node:temp.children) {
                    queue.offer(node);
                }
            }
            res.add(list);
        } 
        return res;    
    }
}