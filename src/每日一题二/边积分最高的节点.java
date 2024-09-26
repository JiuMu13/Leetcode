package 每日一题二;

import java.util.HashMap;
import java.util.Map;

public class 边积分最高的节点 {
    public int edgeScore(int[] edges) {
        long[] c=new long[edges.length];
        for (int i = 0; i < edges.length; i++) {
            c[edges[i]]+=i;
        }
        long max=0;
        int f=-1;
        for (int i = 0; i < c.length; i++) {
            if (c[i]>max){
                max=c[i];
                f=i;
            }
        }
        return f;
    }
}
