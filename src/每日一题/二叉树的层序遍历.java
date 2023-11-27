package 每日一题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历 {
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
      private Queue<TreeNode> q=new LinkedList<>();
      public List<List<Integer>> levelOrder(TreeNode root) {
          List<List<Integer>> result=new ArrayList<>();
          if (root==null)
              return result;
          q.offer(root);
          while (!q.isEmpty()){
              int size=q.size();
              List<Integer> list=new ArrayList<>();
              for (int i = 0; i < size; i++) {
                  TreeNode curr=q.poll();
                  list.add(curr.val);
                  if (curr.left!=null)
                      q.offer(curr.left);
                  if (curr.right!=null)
                      q.offer(curr.right);
              }
              result.add(list);
          }
          return result;
      }
}
