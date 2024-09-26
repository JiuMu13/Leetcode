package 其他练习.图论.Dijkstra;

import java.util.*;

public class 访问消失节点的最少时间 {
    public static void main(String[] args) {
        new 访问消失节点的最少时间().minimumTime(7,new int[][]{{1,4,3},{3,4,2},{2,5,5},{3,3,10}},new int[]{10,1,13,1,7,1,19});
    }
    /* 堆优化的dijkstra */
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] g=new List[n];
        for (int i = 0; i < g.length; i++) {
            g[i]=new ArrayList<>();
        }
        for (int[] edge : edges) {
            g[edge[0]].add(new int[]{edge[1],edge[2]});
            g[edge[1]].add(new int[]{edge[0],edge[2]});
        }
        int[] dist=new int[n];
        boolean[] f=new boolean[n];
        Arrays.fill(dist,-1);
        dist[0]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>(((o1, o2) -> o1[1]-o2[1]));
        pq.add(new int[]{0,0});
        while (!pq.isEmpty()){
            int[] ints = pq.poll();
            int t=ints[0];
            int d=ints[1];
            if (f[t])
                continue;
            f[t]=true;
            for (int[] e : g[t]) {
                int tt=d+e[1];
                if (tt<disappear[e[0]] && (tt< dist[e[0]] || dist[e[0]]==-1) ){
                    dist[e[0]]=tt;
                    pq.add(new int[]{e[0],tt});
                }
            }
        }
        return dist;
    }
}
