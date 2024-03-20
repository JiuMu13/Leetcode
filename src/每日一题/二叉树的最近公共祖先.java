package 每日一题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l=new ArrayList<>();
        dfs(root,l,p,q);
        if (r1.size()<r2.size()){
            List<TreeNode> t=r1;
            r1=r2;
            r2=t;
        }
        TreeNode last=null;
        for (int i=0;i<r1.size();i++){
            if (i+1>r2.size() || r1.get(i)!=r2.get(i)){
                return last;
            }
            last=r1.get(i);
        }
        return null;
    }
    List<TreeNode> r1=new ArrayList<>();
    List<TreeNode> r2=new ArrayList<>();
    private void dfs(TreeNode node,List<TreeNode> curr,TreeNode p,TreeNode q){
        curr.add(node);
        if (node==p)
            r1.addAll(curr);
        if (node==q)
            r2.addAll(curr);
        if (node.left!=null)
            dfs(node.left,curr,p,q);
        if (node.right!=null)
            dfs(node.right,curr,p,q);
        curr.remove(curr.size()-1);
    }
}
