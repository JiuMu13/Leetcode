package 每日一题;

import java.util.ArrayList;

class RangeModule {
    private class Node{
        int left;
        int right;
        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public ArrayList<Node> l;
    public RangeModule() {
        l=new ArrayList<>();
    }
    public void addRange(int left, int right) {
        if (l.size()==0) {
            l.add(new Node(left, right));
            return;
        }
        int i=-1;
        boolean f=false;
        for (;i+1<l.size();){
            i++;
            Node e=l.get(i);
//            System.out.println(e);
            if (right<e.left){
                l.add(i,new Node(left,right));
                f=true;
                break;
            }else {
                if (right<e.right){
                    if (left<e.left) {
                        l.set(i, new Node(left, e.right));
//                        System.out.println(l);
                        f=true;
                        break;
                    }else {
                        f=true;
                        break;
                    }
                }else {
                    if (left>e.right){
                        continue;
                    }else {
                        if (left>e.left)
                            left=e.left;
//                        System.out.println(l);
                        l.remove(i);
                        i--;
//                        System.out.println(l);
                    }
                }
            }
        }
        if (!f){
            l.add(new Node(left,right));
        }
    }

    public boolean queryRange(int left, int right) {
        for (Node e:l){
            if (e.right>=right) {
                if (e.left<=left)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    public void removeRange(int left, int right) {
        int i=-1;
        for (;i+1<l.size();){
            i++;
            Node e=l.get(i);
            if (right<=e.left)
                break;
            else {
                if (right>=e.right){
                    if (left<=e.left){
                        l.remove(i);
                        i--;
                    }else if(left<e.right){
                        l.set(i,new Node(e.left,left));
                    }
                }else {
                    if (left>e.left){
                        l.set(i,new Node(right,e.right));
                        l.add(i,new Node(e.left,left));
                        break;
                    }else {
                        l.set(i,new Node(right,e.right));
                        break;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        RangeModule t=new RangeModule();
        t.addRange(6,7);
        t.addRange(8,9);
        System.out.println("++++++++++++++++++++++++");
        t.addRange(1,8);
        System.out.println(t.l);
        System.out.println(t.queryRange(2,4));
    }
}
