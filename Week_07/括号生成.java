class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(n,n,"",list);
        return list;
    }
    public void helper(int left,int right,String res,List<String> list){
        if(left==0&&right==0){
            list.add(res);
            return;
        }
        if(left>0){
            helper(left-1,right,res+"(",list);
        }
        if(right>left){
            helper(left,right-1,res+")",list);
        }
    }
