package 每日一题;

import java.util.Arrays;

public class 拿出最少数目的魔法豆 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n=beans.length;
        long sum=0;
        long r=0;
        for (int i=n-1;i>=0;i--){
            sum+=beans[i];
            r=Math.max(r,(long)(n-i)*beans[i]);
        }
        return sum-r;
    }
}
