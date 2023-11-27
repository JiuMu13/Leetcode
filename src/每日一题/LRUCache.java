package 每日一题;

import java.util.*;

class LRUCache {
    Node head;
    Node last;
    //key存储value值，value存储Node
    Map<Integer,Node> map;
    private class Node{
        int data;
        int key;
        Node next;
        Node pre;
        public Node(int key,int data,Node pre,Node next){
            this.key=key;
            this.data=data;
            this.next=next;
            this.pre=pre;
        }
    }
    int N;
    public LRUCache(int capacity) {
        N=capacity;
        map=new HashMap<>();
        head=new Node(-1,-1,null,null);
        last=head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node curr=map.get(key);
            if (last!=curr) {
                curr.pre.next=curr.next;
                curr.next.pre=curr.pre;
                last.next=curr;
                curr.pre=last;
                curr.next=null;
                last=curr;
            }
            return map.get(key).data;
        }else
            return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node curr=map.get(key);
            curr.data=value;
            if (last!=curr) {
                curr.pre.next=curr.next;
                curr.next.pre=curr.pre;
                last.next=curr;
                curr.pre=last;
                curr.next=null;
                last=curr;
            }
        }else {
            last.next=new Node(key,value,last,null);
            map.put(key,last.next);
            if (N==0){
                map.remove(head.next.key);
                last=last.next;
                Node curr=head.next.next;
                head.next=curr;
                curr.pre=head;
            }else {
                last=last.next;
                N--;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache test=new LRUCache(1);
        test.put(1,1);
        test.put(2,2);
        System.out.println(test.get(2));
        test.put(3,3);

        System.out.println(test.get(2));
        test.put(4,4);
        System.out.println(test.get(1));
        System.out.println(test.get(3));
        System.out.println(test.get(4));
    }
}