package 每日一题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

public class 规定时间内到达终点的最小花费 {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n=passingFees.length;
        int[][] f=new int[maxTime+1][n];
        for (int[] e:f) {
            Arrays.fill(e,Integer.MAX_VALUE/2);
        }
        f[0][0]=passingFees[0];
        int result=Integer.MAX_VALUE;
        for (int t=1;t<=maxTime;t++){
            for (int j=0;j<edges.length;j++){
                int a=edges[j][0],b=edges[j][1],costtime=edges[j][2];
                if (costtime<=t) {
                    f[t][b] = Math.min(f[t][b], f[t-costtime][a]+passingFees[b]);
                    f[t][a] = Math.min(f[t][a],f[t-costtime][b]+passingFees[a]);
                }
            }
            result=Math.min(result,f[t][n-1]);
        }
        if (result>=Integer.MAX_VALUE/2)
            return -1;
        return result;
    }



}
