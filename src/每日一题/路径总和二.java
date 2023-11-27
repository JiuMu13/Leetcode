package 每日一题;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
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

public class 路径总和二 {
    List<Integer> p=new ArrayList<>();
    List<List<Integer>> list=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
          dfs(root,targetSum);
          return list;
    }
    private void dfs(TreeNode n,int sum){
        if (n==null)
            return;
        if (n.left!=null){
              p.add(n.val);
              dfs(n.left,sum-n.val);
              p.remove(p.size()-1);
          }
          if (n.right!=null){
              p.add(n.val);
              dfs(n.right,sum-n.val);
              p.remove(p.size()-1);
          }
          if(n.left==null && n.right==null) {
              if(sum-n.val==0) {
                  p.add(n.val);
                  List<Integer> t=new ArrayList<>(p);
                  list.add(t);
                  p.remove(p.size()-1);
              }
          }
    }

    public static void main(String[] args) {

    }
}
