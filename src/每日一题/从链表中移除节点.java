package 每日一题;

import java.util.ArrayDeque;
import java.util.Deque;

public class 从链表中移除节点 {
    public class ListNode {
        int val;
        ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNodes(ListNode head) {
        Deque<Integer> stack=new ArrayDeque<>();
        ListNode curr=head;
        while (curr!=null){
            while (!stack.isEmpty() && stack.peek()<curr.val){
                stack.pop();
            }
            stack.push(curr.val);
            curr=curr.next;
        }
        ListNode pre=new ListNode(-1,head);
        ListNode fp=pre;
        curr=head;
        while (curr!=null){
            if (!stack.isEmpty()){
                if (curr.val==stack.peekLast()){
                    stack.removeLast();
                    pre=pre.next;
                    curr=curr.next;
                }else {
                    curr=curr.next;
                    pre.next=curr;
                }
            }else {
                pre.next=null;
                break;
            }
        }
        return fp.next;
    }
}
