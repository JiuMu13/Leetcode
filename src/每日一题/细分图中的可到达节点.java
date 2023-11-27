package 每日一题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 细分图中的可到达节点 {
    private class Edge{
        int from;
        int to;
        int w;

        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        //建图
        LinkedList<Edge>[] g=new LinkedList[n];
        for (int i = 0; i <n ; i++)     g[i]=new LinkedList<>();
        for (int i = 0; i <edges.length ; i++) {
            g[edges[i][0]].add(new Edge(edges[i][0], edges[i][1], edges[i][2] + 1));
            g[edges[i][1]].add(new Edge(edges[i][1], edges[i][0], edges[i][2] + 1));
        }
        //
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE/2);
        boolean[] st=new boolean[n];
        dist[0]=0;
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()){
            int t=q.peek();
            q.poll();
            st[t]=false;
            for (Edge e:g[t]) {
                if (dist[e.to]>dist[e.from]+e.w){
                    dist[e.to]=dist[e.from]+e.w;
                    if (!st[e.to]){
                        q.offer(e.to);
                        st[e.to]=true;
                    }
                }
            }
        }
        int result=0;
        for (int i=0;i<n;i++){
            if (dist[i]<=maxMoves)
                result++;
        }
        for (int i = 0; i <edges.length ; i++) {
            int a=maxMoves-dist[edges[i][0]]>0?maxMoves-dist[edges[i][0]]:0;
            int b=maxMoves-dist[edges[i][1]]>0?maxMoves-dist[edges[i][1]]:0;
            result+=Math.min(edges[i][2],a+b);
        }
        return result;
    }

    public static void main(String[] args) {
        细分图中的可到达节点 t=new 细分图中的可到达节点();
        int[][] s={{0,1,10},{0,2,1},{1,2,2}};
        System.out.println(t.reachableNodes(s,6,3));
    }
}
