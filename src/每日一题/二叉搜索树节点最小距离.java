package 每日一题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 二叉搜索树节点最小距离 {
    List<Integer> list=new ArrayList();
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        Collections.sort(list);
        System.out.println(list);
        int result=1000000;
        for(int i=list.size()-1;i>0;i--){
            int t=list.get(i)-list.get(i-1);
            if(t==0)
                return 0;
            result=Math.min(result,t);
        }
        return result;
    }
    private void dfs(TreeNode x){
        list.add(x.val);
        if(x.left==null && x.right==null)
            return;
        if(x.left!=null){
            dfs(x.left);
        }else
            dfs(x.right);
    }

}
