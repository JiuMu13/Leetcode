package 其他练习.未分类;

class MyCalendar {
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
        if (l <= cl && cr <= r) return node.val;
        pushDown(node);
        int mid = (cl + cr) >> 1, ans = 0;
        if (l <= mid) ans = query(node.left, cl, mid, l, r);
        if (r > mid) ans = Math.max(ans, query(node.right, mid + 1, cr, l, r));
        return ans;
    }
    public MyCalendar() {

    }
    public boolean book(int start, int end) {
        if (query(root,0,(int)1e9,start,end-1)!=0){
            return false;
        }else{
            update(root,0,(int)1e9,start,end-1,1);
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendar t=new MyCalendar();
        System.out.println(t.book(10,20));
        System.out.println(t.book(15,25));
        System.out.println(t.book(25,30));
    }
}
