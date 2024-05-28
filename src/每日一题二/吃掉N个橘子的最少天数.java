package 每日一题二;

import java.util.*;

public class 吃掉N个橘子的最少天数 {
    public static int minDays(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        map.put(n, 0);
        pq.add(n);
        while (!pq.isEmpty()) {
            Integer t = pq.poll();
            if (t == 1) {
                map.put(0, Math.min(map.getOrDefault(0, Integer.MAX_VALUE), map.get(1) + 1));
                continue;
            }
            if (t == 2) {
                map.put(0, Math.min(map.getOrDefault(0, Integer.MAX_VALUE), map.get(2) + 2));
                continue;
            }
            if (!pq.contains(t / 3))
                pq.add(t / 3);
            map.put(t / 3, Math.min(map.getOrDefault(t / 3, Integer.MAX_VALUE), map.get(t) + 1 + (t % 3)));

            if (!pq.contains(t / 2))
                pq.add(t / 2);
            map.put(t / 2, Math.min(map.getOrDefault(t / 2, Integer.MAX_VALUE), map.get(t) + 1 + (t % 2)));
        }
        return map.get(0);
    }

    public static void main(String[] args) {
        System.out.println(minDays(429));
    }
}
