public class Solution {
    int depth;
    int maxDepth;
    int left;
    public int findBottomLeftValue(TreeNode root) {
        solve(root);
        return left;
    }
    public void solve(TreeNode t){
        depth++;
        if(maxDepth < depth) {
            maxDepth = depth;
            left = t.val;
        } 
        if(t.left != null) solve(t.left);
        if(t.right != null) solve(t.right);
        depth--;
    }
}
