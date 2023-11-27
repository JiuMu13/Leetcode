package 每日一题;

import java.util.Map;

public class 阈值距离内邻居最少的城市 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] d=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                d[i][j]=i==j?0:Integer.MAX_VALUE/2;
            }
        }
        for (int i=0;i<edges.length;i++){
            d[edges[i][0]][edges[i][1]]=edges[i][2];
            d[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        for (int k=0;k<n;k++){
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    d[i][j]= Math.min(d[i][j],d[i][k]+d[k][j]);
                }
            }
        }
        int result=-1;
        int f=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            int count=0;
            for (int j=0;j<n;j++){
                if (i!=j){
                    if (d[i][j]<=distanceThreshold)
                        count++;
                }
            }
            if (count<=f) {
                result = i;
                f=count;
            }
        }
        return result;
    }
}
