package 每日一题;

import com.sun.source.tree.Tree;

public class 路径总和 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //递归
        //判断树是否为空
        if(root==null)
            return false;
        //判断是否是叶子结点
        //是
        if (root.left==null && root.right==null)
        {
            return targetSum==root.val;
        }
        //否
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }

}
