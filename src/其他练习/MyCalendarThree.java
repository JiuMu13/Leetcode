package 其他练习;

public class MyCalendarThree {
    class Node{
        Node left,right;
        int val;
        int lazy;
    }
    Node root=new Node();
    public void update(Node node,int cl,int cr,int l,int r,int val){
        if (l<=cl && cr<=r){
            node.val+=val;
            node.lazy+=val;
            return;
        }
        int mid=(cl+cr)>>1;
        pushDown(node);
        if (l<=mid) update(node.left,cl,mid,l,r,val);
        if (r>=mid+1) update(node.right,mid+1,cr,l,r,val);
        node.val=Math.max(node.left.val,node.right.val);
    }
    private void pushDown(Node node){
        if (node.left==null) node.left=new Node();
        if (node.right==null) node.right=new Node();
        if (node.lazy==0) return;
        node.left.val+=node.lazy;
        node.right.val+=node.lazy;
        node.left.lazy+=node.lazy;
        node.right.lazy+=node.lazy;
        node.lazy=0;
    }
    public int query(Node node,int cl,int cr,int l,int r){
        if (l<=cl && cr<=r){
            return node.val;
        }
        int mid=(cl+cr)>>1;
        pushDown(node);
        int max=0;
        if (l<=mid) max=query(node.left,cl,mid,l,r);
        if (r>=mid+1) max=Math.max(max,query(node.right,mid+1,cr,l,r));
        return max;
    }
    public MyCalendarThree() {

    }

    public int book(int startTime, int endTime) {
        update(root,0,(int)1e9,startTime,endTime-1,1);
        return root.val;
    }

    public static void main(String[] args) {
        MyCalendarThree t=new MyCalendarThree();
        System.out.println(t.book(10,20));
    }
}
