package 每日一题;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 回文链表 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        //法一
        Stack<Integer> s=new Stack<>();
        int f=0;
        ListNode hf=head;
        //计算链表长度
        while (head!=null)
        {
            f++;
            head=head.next;
        }
        //压入前半部分表
        for (int i=0;i<f/2;i++)
            {
                s.push(hf.val);
                hf=hf.next;
            }
        if (f%2!=0)
            hf=hf.next;
        //与后半部分表对照
        for (int i=0;i<f/2;i++)
            {
                if (hf.val!=s.pop())
                {
                    return false;
                }
                hf=hf.next;
            }
        return true;
        //法二
    }

}
