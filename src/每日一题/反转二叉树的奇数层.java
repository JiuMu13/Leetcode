package 每日一题;

import java.util.ArrayDeque;
import java.util.Deque;

public class 反转二叉树的奇数层 {
    //bfs
    public TreeNode reverseOddLevels(TreeNode root) {
        int curr=0,sum=1,ceng=0;
        Deque<TreeNode> deque=new ArrayDeque<>();
        Deque<TreeNode> currC=new ArrayDeque<>();
        Deque<Integer> currCV=new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            if (curr==sum){
                if (ceng%2!=0){
                    while (!currC.isEmpty()){
                        currC.removeFirst().val=currCV.removeLast();
                        System.out.println("11");
                    }
                }
                ceng++;
                curr=0;
                sum*=2;
            }
            TreeNode node=deque.remove();
            if (node.left!=null){
                deque.add(node.left);
                deque.add(node.right);
            }
            curr++;
            if (ceng%2!=0){
                currC.add(node);
                currCV.add(node.val);
            }
        }
        if (curr==sum){
            if (ceng%2!=0){
                while (!currC.isEmpty()){
                    currC.removeFirst().val=currCV.removeLast();
                }
            }
        }
        return root;
    }

    //dfs
    class Solution {
        public TreeNode reverseOddLevels(TreeNode root) {
            dfs(root.left, root.right, true);
            return root;
        }

        private void dfs(TreeNode node1, TreeNode node2, boolean odd) {
            if (node1 == null) return;
            if (odd) swap(node1, node2);
            dfs(node1.left, node2.right, !odd);
            dfs(node1.right, node2.left, !odd);
        }

        private void swap(TreeNode n1, TreeNode n2) {
            int t = n1.val;
            n1.val = n2.val;
            n2.val = t;
        }
    }
}
