package 每日一题;

import java.util.ArrayList;

//class RangeModule {
//    private class Node{
//        int left;
//        int right;
//        public Node(int left, int right) {
//            this.left = left;
//            this.right = right;
//        }
//    }
//    public ArrayList<Node> l;
//    public RangeModule() {
//        l=new ArrayList<>();
//    }
//    public void addRange(int left, int right) {
//        if (l.size()==0) {
//            l.add(new Node(left, right));
//            return;
//        }
//        int i=-1;
//        boolean f=false;
//        for (;i+1<l.size();){
//            i++;
//            Node e=l.get(i);
////            System.out.println(e);
//            if (right<e.left){
//                l.add(i,new Node(left,right));
//                f=true;
//                break;
//            }else {
//                if (right<e.right){
//                    if (left<e.left) {
//                        l.set(i, new Node(left, e.right));
////                        System.out.println(l);
//                        f=true;
//                        break;
//                    }else {
//                        f=true;
//                        break;
//                    }
//                }else {
//                    if (left>e.right){
//                        continue;
//                    }else {
//                        if (left>e.left)
//                            left=e.left;
////                        System.out.println(l);
//                        l.remove(i);
//                        i--;
////                        System.out.println(l);
//                    }
//                }
//            }
//        }
//        if (!f){
//            l.add(new Node(left,right));
//        }
//    }
//
//    public boolean queryRange(int left, int right) {
//        for (Node e:l){
//            if (e.right>=right) {
//                if (e.left<=left)
//                    return true;
//                else
//                    return false;
//            }
//        }
//        return false;
//    }
//
//    public void removeRange(int left, int right) {
//        int i=-1;
//        for (;i+1<l.size();){
//            i++;
//            Node e=l.get(i);
//            if (right<=e.left)
//                break;
//            else {
//                if (right>=e.right){
//                    if (left<=e.left){
//                        l.remove(i);
//                        i--;
//                    }else if(left<e.right){
//                        l.set(i,new Node(e.left,left));
//                    }
//                }else {
//                    if (left>e.left){
//                        l.set(i,new Node(right,e.right));
//                        l.add(i,new Node(e.left,left));
//                        break;
//                    }else {
//                        l.set(i,new Node(right,e.right));
//                        break;
//                    }
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//        RangeModule t=new RangeModule();
//        t.addRange(6,7);
//        t.addRange(8,9);
//        System.out.println("++++++++++++++++++++++++");
//        t.addRange(1,8);
//        System.out.println(t.l);
//        System.out.println(t.queryRange(2,4));
//    }
//}
class RangeModule {
    int n=(int)1e9;
    public RangeModule() {

    }

    public void addRange(int left, int right) {
        update(root,1,n,left,right-1,1);
    }

    public boolean queryRange(int left, int right) {
        return query(root,1,n,left,right-1);
    }

    public void removeRange(int left, int right) {
        update(root,1,n,left,right-1,-1);
    }

    class Node{
        Node left,right;
        boolean cnt;
        int lazy;//1为增，-1为减
    }
    Node root=new Node();
    void update(Node node,int l,int r,int L,int R,int lazy){
        if (l>=L && r<=R){
            node.cnt=lazy==1;
            node.lazy=lazy;
            return;
        }

        pushDown(node);

        int mid=(l+r)/2;
        if (L<=mid) update(node.left,l,mid,L,R,lazy);
        if (R>=mid+1) update(node.right,mid+1,r,L,R,lazy);

        node.cnt=node.left.cnt&&node.right.cnt;
    }
    public boolean query(Node node,int l,int r,int L,int R){
        if (L<=l && R>=r)
            return node.cnt;
        int mid=(l+r)/2;
        pushDown(node);
        boolean sum=true;
        if (L<=mid) sum=sum&&query(node.left,l,mid,L,R);
        if (R>=mid+1) sum=sum&&query(node.right,mid+1,r,L,R);
        return sum;
    }
    private void pushDown(Node node){
        if (node.left==null) node.left=new Node();
        if (node.right==null) node.right=new Node();
        if (node.lazy==0) return;
        node.left.cnt=node.right.cnt=node.lazy==1;
        node.left.lazy=node.right.lazy=node.lazy;
        node.lazy=0;
    }

}
