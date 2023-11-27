package 每日一题;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
//更优解法：
/*
将1-9的奇偶情况压缩成二进制数，
利用位运算删除最小元素的方法，
此时若只有一个1，则
mask&(mask−1)=0
 */
public class 二叉树中的伪回文路径 {
    Set<Integer> set=new HashSet<>();
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root);
    }
    int dfs(TreeNode n){
        if (n.left==null && n.right==null){
            int t=0;
            if (set.contains(n.val))
                t=set.size()-1;
            else
                t=set.size()+1;
            if (t<=1){
                return 1;
            }else
                return 0;
        }
        if (!set.contains(n.val)){
            set.add(n.val);
        }else {
            set.remove(n.val);
        }
        int result=0;
        if (n.left!=null)
            result+=dfs(n.left);
        if (n.right!=null)
            result+=dfs(n.right);
        if (set.contains(n.val)){
            set.remove(n.val);
        }else
            set.add(n.val);
        return result;
    }
}
