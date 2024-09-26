package 每日一题二;

import java.util.ArrayList;
import java.util.List;

public class 最佳观光组合 {
    /* 分别维护前后缀和数组 */
    public int maxScoreSightseeingPair1(int[] values) {
        int n=values.length;
        int[] pre=new int[n];
        int[] suf=new int[n];
        pre[0]=values[0];
        suf[n-1]=values[n-1];
        for(int i=1;i<n;i++){
            pre[i]=Math.max(pre[i-1]-1,values[i]);
            suf[n-1-i]=Math.max(suf[n-i]-1,values[n-1-i]);
        }
        int max=0;
        for (int i = 1; i < n; i++)
            max=Math.max(max,pre[i-1]-1+suf[i]);
        return max;
    }
    /* 枚举右，维护左 */
    public int maxScoreSightseeingPair2(int[] values) {
        int ml=Integer.MIN_VALUE;
        int mr=0;
        for(int i=0;i< values.length;i++){
            mr=Math.max(mr,ml+values[i]-i);
            ml=Math.max(ml,values[i]+i);
        }
        return mr;
    }
}
