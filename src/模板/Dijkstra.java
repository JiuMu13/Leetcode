package 模板;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void main(String[] args) {
        int n=10;//节点个数
        int[] dist=new int[n];
        boolean[] f=new boolean[n];
        Arrays.fill(dist,Integer.MAX_VALUE/2);
        int[][] g=new int[n][n];
        List<Integer>[] l=new List[n];//邻接表
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{0,0});
        dist[0]=0;
        while (!pq.isEmpty()){
            int[] t=pq.poll();
            int k=t[0],v=t[1];
            if (f[k])
                continue;
            f[k]=true;
            for (Integer i : l[k]) {
                if (dist[i]>v+g[k][i]){
                    dist[i]=v+g[k][i];
                    pq.add(new int[]{i,dist[i]});
                }
            }
        }
    }
}
