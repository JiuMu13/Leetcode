package 其他练习;


public class 打家劫舍三 {
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

    public int rob(TreeNode root) {
        int[] r=dp(root);
        return Math.max(r[0],r[1]);
    }
    private int[] dp(TreeNode n){
        if (n==null)
            return new int[]{0,0};
        int curr0=0;
        int curr1=n.val;
        int[] rl=dp(n.left);
        int[] rr=dp(n.right);
        curr1+=rl[0]+rr[0];
        curr0+=Math.max(rl[0],rl[1])+Math.max(rr[0],rr[1]);
        return new int[]{curr0,curr1};
    }
}
