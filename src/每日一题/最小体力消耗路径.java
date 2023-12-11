package 每日一题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
//还可使用二分法或并查集解题
public class 最小体力消耗路径 {
    //堆优化版的Dijkstra
    public int minimumEffortPath1(int[][] heights) {
        int r=heights.length;
        int c=heights[0].length;
        int[][] dist=new int[r+1][c+1];
        boolean[][] st=new boolean[r+1][c+1];
        for (int i=0;i<r+1;i++)
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        dist[1][1]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
        pq.offer(new int[]{1,1,0});
        while (!pq.isEmpty()){
            int[] t=pq.poll();
            int x=t[0],y=t[1],w=t[2];
            if (st[x][y]) continue;
            st[x][y]=true;
            int f;
            if (x-1>0&&y>0&& dist[x-1][y]>(f=Math.max(w,Math.abs(heights[x-1-1][y-1]-heights[x-1][y-1])))){
                dist[x-1][y]=f;     pq.offer(new int[]{x-1,y,f});
            }
            if (x+1<r+1&&y>0&& dist[x+1][y]>(f=Math.max(w,Math.abs(heights[x+1-1][y-1]-heights[x-1][y-1])))){
                dist[x+1][y]=f;     pq.offer(new int[]{x+1,y,f});
            }
            if (x>0&&y-1>0&& dist[x][y-1]>(f=Math.max(w,Math.abs(heights[x-1][y-1-1]-heights[x-1][y-1])))){
                dist[x][y-1]=f;     pq.offer(new int[]{x,y-1,f});
            }
            if (x>0&&y+1<c+1&& dist[x][y+1]>(f=Math.max(w,Math.abs(heights[x-1][y+1-1]-heights[x-1][y-1])))){
                dist[x][y+1]=f;     pq.offer(new int[]{x,y+1,f});
            }
        }
        return dist[r][c];
    }

    public static void main(String[] args) {
        最小体力消耗路径 t=new 最小体力消耗路径();
        int[][] s={{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(t.minimumEffortPath1(s));
    }
}
