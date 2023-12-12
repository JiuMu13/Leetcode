package 每日一题;

import java.util.*;

public class 下一个更大元素四 {
    //注释为双索引优先队列写法，
    public int[] secondGreaterElement(int[] nums) {
        int n=nums.length;
        //PriorityQueue<int[]> pq=new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
        Deque<int[]> stack=new ArrayDeque<>();
        int[] r=new int[n];
        Arrays.fill(r,-1);
        PriorityQueue<int[]> pq2=new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
        for (int i=0;i<n;i++){
            while (!pq2.isEmpty() && nums[i]>pq2.peek()[0]){
                int[] t=pq2.poll();
                r[t[1]]=nums[i];
            }
//            while (!pq.isEmpty() && nums[i]>pq.peek()[0]){
//                int[] t=pq.poll();
//                pq2.offer(t);
//            }
//            pq.offer(new int[]{nums[i],i});
            while (!stack.isEmpty() && nums[i]>stack.peekLast()[0]){
                pq2.offer(stack.pollLast());
            }
            stack.add(new int[]{nums[i],i});
        }
        return r;
    }

    public static void main(String[] args) {
        下一个更大元素四 t=new 下一个更大元素四();
        System.out.println(Arrays.toString(t.secondGreaterElement(new int[]{2,4,0,9,6})));
    }
}
