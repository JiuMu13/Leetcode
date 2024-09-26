package 其他练习.未分类;
//线段树练习
class RecentCounter {
    class Node{
        Node left,right;
        int val;
        int lazy;
    }
    Node root=new Node();
    public void update(Node node,int l,int r,int L,int R,int val){
        if (l<=L && r>=R){
            node.val+=(r-l+1)*val;
            node.lazy+=val;
            return;
        }
        int mid=(L+R)>>1;
        pushDown(node,mid-L+1,R-mid);
        if (l<=mid) update(node.left,l,r,L,mid,val);
        if (r>=mid+1) update(node.right,l,r,mid+1,R,val);
        node.val=node.left.val+node.right.val;
    }
    private void pushDown(Node node,int leftq,int rightq){
        if (node.left==null) node.left=new Node();
        if (node.right==null) node.right=new Node();
        if (node.lazy==0)
            return;
        node.left.val+=leftq*node.lazy;
        node.right.val+=rightq*node.lazy;
        node.left.lazy+=node.lazy;
        node.right.lazy+=node.lazy;
        node.lazy=0;
    }
    public int query(Node node,int l,int r,int L,int R){
        if (l<=L && r>=R){
            return node.val;
        }
        int mid=(L+R)>>1;
        pushDown(node,L,R);
        int sum=0;
        if (l<=mid) sum+=query(node.left,l,r,L,mid);
        if (r>=mid+1) sum+=query(node.right,l,r,mid+1,R);
        return sum;
    }
    public RecentCounter() {

    }

    public int ping(int t) {
        update(root,t,t,1,(int)1e9,1);
        return query(root,t-3000,t,1,(int)1e9);
    }
}
