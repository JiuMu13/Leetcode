package 每日一题;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class SmallestInfiniteSet {
    int curr;//当前最小整数
    PriorityQueue<Integer> pq;
    Set<Integer> set;
    public SmallestInfiniteSet() {
        curr=1;
        pq=new PriorityQueue<>();
        set=new HashSet<>();
    }

    public int popSmallest() {
        if (!pq.isEmpty()){
            set.remove(pq.peek());
            return pq.poll();
        }

        return curr++;
    }

    public void addBack(int num) {
        if (num<curr) {
            if (!set.contains(num)) {
                pq.offer(num);
                set.add(num);
            }
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.offer(1);
        pq.offer(1);
        while (!pq.isEmpty())
            System.out.println(pq.poll());
    }
}
