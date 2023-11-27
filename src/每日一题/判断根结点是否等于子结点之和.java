package 每日一题;

public class 判断根结点是否等于子结点之和 {

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
    class Solution {
        public boolean checkTree(TreeNode root) {
            return root.right.val+root.left.val==root.val;
        }
    }
}
