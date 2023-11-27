package 每日一题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 执行K次操作后的最大分数 {
    public long maxKelements(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        PriorityQueue<Integer> minpq=new PriorityQueue<>(k);
        PriorityQueue<Integer> maxpq=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1-integer;
            }
        });
        for (int i=0; n-1-i>=0 && i<k ;i++) {
            minpq.add(nums[n - 1 - i]);
            maxpq.add(nums[n-1-i]);
        }
        long result=0;
        for (int i=0;i<k;i++){
            int t=maxpq.poll();
            result+=t;
            t=(t+2)/3;
            if (n<k){
                minpq.add(t);
                maxpq.add(t);
                n++;
            }
            else if (t>minpq.peek() ){
                maxpq.add(t);
                minpq.poll();
                minpq.add(t);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        执行K次操作后的最大分数 t=new  执行K次操作后的最大分数();
        int[] s={822539285,410243778,843804474,77808436,604773488,91882183,983148575,707291538,210570310,256880418,744202637,272026597,850035362,815964585,161539308,807997984,975169847,373595653,740848840,596578711,634140518,805359728,893113934,983095872,740000028,424404126,645488102,398147052,399134531,455173503,762937622,135977920,886567539,210644714,441883025,440353920,151652262,540667241,41680120,612170826,757875616,630417303,829178537,765944292,440167660,811916049,764614502,101017579,296944070,726251399};
        System.out.println(t.maxKelements(s,53));
    }
}
