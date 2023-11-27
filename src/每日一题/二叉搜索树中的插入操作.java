package 每日一题;

public class 二叉搜索树中的插入操作 {
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
          if (root==null){
              return new TreeNode(val,null,null);
          }
          TreeNode curr=root;
          TreeNode pre=root;
          while (curr!=null){
              if (val<curr.val){
                  pre=curr;
                  curr=curr.left;
              } else{
                  pre=curr;
                  curr=curr.right;
              }
          }
          curr=new TreeNode(val,null,null);
          if (val>pre.val){
              pre.right=curr;
          }else {
              pre.left=curr;
          }
          return root;
    }

}
