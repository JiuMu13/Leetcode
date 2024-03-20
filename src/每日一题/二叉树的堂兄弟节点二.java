package 每日一题;

import java.util.ArrayDeque;
import java.util.Deque;

public class 二叉树的堂兄弟节点二 {
    public TreeNode replaceValueInTree(TreeNode root) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        Deque<Integer> del=new ArrayDeque<>();
        TreeNode flag=new TreeNode();
        stack.addFirst(root);
        stack.addFirst(flag);
        int currRow=0;
        int lastRow=0;
        while (!stack.isEmpty()){
            TreeNode t=stack.removeLast();
            t.val=lastRow-(del.isEmpty()?0:del.removeLast());
            int tdel=0;
            if (t.left!=null){
                stack.addFirst(t.left);
                currRow+=t.left.val;
                tdel+=t.left.val;
            }
            if (t.right!=null){
                stack.addFirst(t.right);
                currRow+=t.right.val;
                tdel+=t.right.val;
            }
            if (t.left!=null){
                del.addFirst(tdel);
            }
            if (t.right!=null){
                del.addFirst(tdel);
            }
            if (stack.peekLast()==flag){
                lastRow=currRow;
                currRow=0;
                stack.removeLast();
                stack.addFirst(flag);
            }
        }
        return root;
    }

}
