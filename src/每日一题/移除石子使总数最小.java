package 每日一题;

import java.util.*;

public class 移除石子使总数最小 {
    //法一：优先队列
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1, o2) -> o2 - o1);
        int sum=0;
        for (int i=0;i<piles.length;i++) {
            pq.offer(piles[i]);
            sum+=piles[i];
        }
        for (int i=0;i<k;i++){
            int t=pq.poll();
            if (t==1)
                break;
            sum-=t/2;
            pq.offer(t-t/2);
        }
        return sum;
    }

    //法二：构造哈希表记录元素，因为元素是不断变小的，所以只需找到piles数组的最大值遍历一遍即可得到结果
}
