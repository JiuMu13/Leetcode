package 其他练习.图论.Dijkstra;

import java.util.*;

public class 概率最大的路径 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]>[] g=new List[n];
        Arrays.setAll(g,e->new ArrayList<>());
        for (int i=0;i< edges.length;i++) {
            g[edges[i][0]].add(new double[]{edges[i][1],succProb[i]});
            g[edges[i][1]].add(new double[]{edges[i][0],succProb[i]});
        }
        PriorityQueue<double[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o2[1]==o1[1])
                return 0;
            if (o2[1]-o1[1]>0)
                return 1;
            return -1;
        });
        q.add(new double[]{start_node,1});
        boolean[] f=new boolean[n];
        double[] dist=new double[n];
        dist[start_node]=1;
        while (!q.isEmpty()){
            double[] poll = q.poll();
            int v=(int)poll[0];
            double w=poll[1];
            if (f[v])
                continue;
            f[v]=true;
            for (double[] e : g[v]) {
                int ev=(int)e[0];
                double ew=e[1];
                if (dist[ev]<w*ew){
                    dist[ev]=w*ew;
                    q.add(new double[]{ev,dist[ev]});
                }
            }
        }
        return dist[end_node];
    }
}
