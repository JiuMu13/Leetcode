package 每日一题;

public class 环形链表二 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode f,doublef;
        f=head;
        doublef=head;
        if (head==null)
            return null;
        while (doublef!=null){
            doublef=doublef.next;
            if (doublef!=null){
                doublef=doublef.next;
            }else
                break;
            f=f.next;
            if (f==doublef){
                break;
            }
        }
        if (doublef==null){
            return null;
        }
        ListNode r=head;
        while (f!=r){
            f=f.next;
            r=r.next;
        };
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-15));
        System.out.println(-15>>1);
    }
}
