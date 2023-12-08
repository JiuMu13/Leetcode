package 每日一题;

import java.util.Arrays;
import java.util.Comparator;
//线性DP
public class 出租车的最大盈利 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] f=new long[n+1];
        int m=rides.length;
        Arrays.sort(rides, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int currf=0;
        for(int i=1;i<=n;i++){
            long t=0;
            while(currf<m && rides[currf][1]==i){
                t=Math.max(t,f[rides[currf][0]]+rides[currf][1]-rides[currf][0]+rides[currf][2]);
                currf++;
            }
            f[i]=Math.max(f[i-1],t);
            if (currf>=m)
                return f[i];
        }
        return f[n];
    }
}
