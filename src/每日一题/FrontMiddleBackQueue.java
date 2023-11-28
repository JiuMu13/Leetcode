package 每日一题;

class FrontMiddleBackQueue {
    private class Node{
        Node pre;
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    Node head;
    Node last;
    Node mid;
    int size;
    public FrontMiddleBackQueue() {
        size=0;
    }

    public void pushFront(int val) {
        Node t=new Node(val);
        if (size==0){
            head=t;
            last=t;
            mid=t;
        }else {
            head.pre=t;
            head.pre.next=head;
            head=head.pre;
            if (size%2!=0){
                mid=mid.pre;
            }
        }
        if (last.next!=null)
            last=last.next;
        size++;
    }

    public void pushMiddle(int val) {
        Node t=new Node(val);
        if (size==0){
            head=t;
            last=t;
            mid=t;
        }else {
            if (size%2==0){
                t.next=mid.next;
                t.pre=mid;
                mid.next.pre=t;
                mid.next=t;
                mid=t;
            }else {
                t.next=mid;
                t.pre=mid.pre;
                if (mid.pre!=null){
                    mid.pre.next=t;
                }
                mid.pre=t;
                mid=t;
            }
        }
        if (head.pre!=null)
            head=head.pre;
        size++;
    }

    public void pushBack(int val) {
        Node t=new Node(val);
        if (size==0){
            head=t;
            last=t;
            mid=t;
        }else {
            last.next=t;
            last.next.pre=last;
            last=last.next;
            if (size%2==0){
                mid=mid.next;
            }
        }
        size++;
    }

    public int popFront() {
        if (size==0)
            return -1;
        if (size%2==0){
            mid=mid.next;
        }
        int r=head.val;
        head=head.next;
        if (head!=null)
            head.pre=null;
        size--;
        return r;
    }

    public int popMiddle() {
        if (size==0)
            return -1;
        int r=mid.val;
        Node t;
        if (size%2==0){
            t=mid.next;
            if(size==2)
                head=t;
        }else {
            t=mid.pre;
        }
        if (mid.pre!=null){
            mid.pre.next=mid.next;
        }
        if (mid.next!=null){
            mid.next.pre=mid.pre;
        }

        mid=t;
        size--;
        return r;
    }

    public int popBack() {
        if (size==0)
            return -1;
        if (size%2!=0){
            mid=mid.pre;
        }
        int r=last.val;
        last=last.pre;
        if (last!=null)
            last.next=null;
        size--;
        return r;
    }

    public static void main(String[] args) {
//        FrontMiddleBackQueue t=new FrontMiddleBackQueue();
//        t.pushMiddle(1);
//        System.out.println("head:"+t.head.val+"mid:"+t.mid.val+"last:"+t.last.val);
//        t.pushMiddle(2);
//        System.out.println("head:"+t.head.val+"mid:"+t.mid.val+"last:"+t.last.val);
//        t.popMiddle();
//        System.out.println("head:"+t.head.val+"mid:"+t.mid.val+"last:"+t.last.val);
//        t.pushMiddle(3);
//        System.out.println("head:"+t.head.val+"mid:"+t.mid.val+"last:"+t.last.val);
//        t.pushFront(4);
//        System.out.println("head:"+t.head.val+"mid:"+t.mid.val+"last:"+t.last.val);
//        System.out.println(t.popMiddle());
//        System.out.println(t.popBack());
//        t.popBack();
//        t.popFront();
    }
}
