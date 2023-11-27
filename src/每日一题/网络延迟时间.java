package 每日一题;

import java.util.Arrays;

public class 网络延迟时间 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] g=new int[n+1][n+1];
        for (int i=1;i<=n;i++)
            Arrays.fill(g[i],Integer.MAX_VALUE/2);
        int result=0;
        for (int i=1;i<=n;i++)
            g[i][i]=0;
        for (int i=0;i<times.length;i++)
            g[times[i][0]][times[i][1]] = times[i][2];

        for (int h=1;h<=n;h++)
            for (int i=1;i<=n;i++)
                for (int j=1;j<=n;j++)
                    g[i][j] = Math.min(g[i][j], g[i][h] + g[h][j]);


        for (int i=1;i<=n;i++){
            result=Math.max(result,g[k][i]);
        }
        return result>=Integer.MAX_VALUE/2?-1:result;
    }

    public static void main(String[] args) {
        网络延迟时间 t=new 网络延迟时间();
        int[][] s={{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(t.networkDelayTime(s,4,2));
    }
}
