package 其他练习;

public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode left,TreeNode right){
        if (left==null && right==null)
            return true;
        if (left==null || right==null)
            return false;
        boolean f1= dfs(left.left,right.right);
        boolean f2= dfs(left.right,right.left);
        return f1 && f2 && left.val==right.val;
    }
}
