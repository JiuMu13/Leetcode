package 每日一题;


public class 从二叉搜索树到更大和树 {
    private int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }
    private void dfs(TreeNode n){
        if (n==null)
            return;
        dfs(n.right);
        sum+=n.val;
        n.val=sum;
        dfs(n.left);
    }
}
