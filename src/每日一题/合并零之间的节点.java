package 每日一题;

public class 合并零之间的节点 {
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode mergeNodes(ListNode head) {
            ListNode curr=head;
            ListNode result=new ListNode(),rcurr=result;
            // System.out.println(head.next.val);
            while(curr.val==0 && curr.next!=null){
                curr=curr.next;
                int sum=0;
                while(curr.val!=0){
                    sum+=curr.val;
                    curr=curr.next;
                }
                rcurr.next=new ListNode(sum,null);
                rcurr=rcurr.next;
            }
            return result.next;
        }
    }
}
