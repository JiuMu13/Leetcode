package 每日一题;

import java.util.PriorityQueue;

public class 魔塔游戏 {
    public static int magicTower(int[] nums) {
        long sum=0;
        for (int e : nums) {
            sum+=e;
        }
        if (sum<0)
            return -1;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int r=0;
        long curr=0;
        for (int e:nums){
            if (e<0){
                if (curr+e<0){
                    if (pq.size()==0 || e<pq.peek()){
                        r++;
                        continue;
                    }else{
                        curr-=pq.poll();
                        r++;
                        pq.offer(e);
                    }
                }else {
                    pq.offer(e);
                }
            }
            curr+=e;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(magicTower(new int[]{-9635,71923,-37495,8366,54303,-86422,-48303,-47858,98424}));
    }
}
