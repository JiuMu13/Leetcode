package 其他练习.图论.bfs;

import 其他练习.数位dp.统计特殊整数;

import java.util.*;

public class 图中的最短环 {
    public static void main(String[] args) {
//        int shortestCycle = new 图中的最短环().findShortestCycle(7, new int[][]{{0,1},{1,2},{2,0},{3,4},{4,5},{5,6},{6,3}});
        int shortestCycle = new 图中的最短环().findShortestCycle(4, new int[][]{{0,1},{0,2}});
        System.out.println(shortestCycle);
    }
    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        Queue<int[]> q = new ArrayDeque<>();
        int r = Integer.MAX_VALUE;
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            q.add(new int[]{i,-1});
            Arrays.fill(w,-1);
            w[i]=0;
            while (!q.isEmpty()) {
                int[] remove = q.remove();
                int v=remove[0],last=remove[1];
                for (Integer e : g[v]) {
                    if (w[e]==-1) {
                        w[e]=w[v]+1;
                        q.add(new int[]{e,v});
                    } else if (e!=last){
                        r = Math.min(r, w[v]+w[e]+1);
                    }
                }
            }
        }
        return r==Integer.MAX_VALUE?-1:r;
    }
}
