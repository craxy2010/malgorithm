public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return solve(p, q);
    }
    public boolean solve(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null && q != null || p != null && q == null) return false;
        
        boolean bVal = p.val == q.val;
        boolean bLeft = p.left == null && q.left == null || solve(p.left, q.left);
        boolean bRight = p.right == null && q.right == null || solve(p.right, q.right);
        
        if(bVal && bLeft && bRight) return true;
        else return false;
    }
}
