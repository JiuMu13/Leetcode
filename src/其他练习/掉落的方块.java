package 其他练习;

import java.util.ArrayList;
import java.util.List;

public class 掉落的方块 {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> result=new ArrayList<>();
        for (int i=0;i<positions.length;i++){
            int left=positions[i][0],len=positions[i][1];
            int t=query(root,1,(int)1e9,left,left+len-1);
            update(root,1,(int)1e9,left,left+len-1,t+len);
            result.add(root.val);
        }
        return result;
    }
    class Node{
        Node left,right;
        int val;
        int lazy;
    }
    Node root=new Node();
    public void update(Node node,int cl,int cr,int l,int r,int val){
        if (l<=cl && cr<=r){
            node.val=val;
            node.lazy=val;
            return;
        }
        pushDown(node);
        int mid=(cl+cr)>>1;
        if (l<=mid) update(node.left,cl,mid,l,r,val);
        if (r>=mid+1) update(node.right,mid+1,cr,l,r,val);
        node.val=Math.max(node.left.val,node.right.val);
    }
    private void pushDown(Node node){
        if (node.left==null)    node.left=new Node();
        if (node.right==null)   node.right=new Node();
        if (node.lazy==0)   return;
        node.left.val=node.lazy;
        node.right.val=node.lazy;
        node.left.lazy=node.lazy;
        node.right.lazy=node.lazy;
        node.lazy=0;
    }
    public int query(Node node,int cl,int cr,int l,int r){
        if (l<=cl && cr<=r){
            return node.val;
        }
        pushDown(node);
        int mid=(cl+cr)>>1,max=0;
        if (l<=mid) max=query(node.left,cl,mid,l,r);
        if (r>=mid+1) max=Math.max(max,query(node.right,mid+1,cr,l,r));
        return max;
    }
}
