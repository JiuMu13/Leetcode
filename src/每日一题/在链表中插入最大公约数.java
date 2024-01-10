package 每日一题;

public class 在链表中插入最大公约数 {
    public class ListNode {
        int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr=head;
        while (curr.next!=null){
            ListNode newNode = new ListNode();
            newNode.next=curr.next;
            newNode.val=gcd(curr.val,curr.next.val);
            curr.next=newNode;
            curr=newNode.next;
        }
        return head;
    }
    private int gcd(int m,int n){
        return n==0?m:gcd(n,m%n);
    }
}
