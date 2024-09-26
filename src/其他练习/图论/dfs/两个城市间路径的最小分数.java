package 其他练习.图论.dfs;


import java.util.*;

public class 两个城市间路径的最小分数 {
    public static void main(String[] args) {
        System.out.println(new 两个城市间路径的最小分数().minScore(4,new int[][]{{1,2,9},{2,3,6},{2,4,5},{1,4,7}}));
    }
    public int minScoreBFS(int n, int[][] roads) {
        boolean[] f=new boolean[n+1];
        List<int[]>[] g=new List[n+1];
        Arrays.setAll(g,e->new ArrayList<>());
        for (int[] road : roads) {
            g[road[0]].add(new int[]{road[1],road[2]});
            g[road[1]].add(new int[]{road[0],road[2]});
        }
        Deque<int[]> q=new ArrayDeque<>();
        q.addFirst(new int[]{1,Integer.MAX_VALUE});
        int r=Integer.MAX_VALUE;
        while (!q.isEmpty()){
            int[] t = q.removeLast();
            f[t[0]]=true;
            for (int[] e : g[t[0]]) {
                if (!f[e[0]]){
                    r=Math.min(e[1],r);
                    q.addFirst(e);
                }
            }
        }
        return r;
    }

    public int minScore(int n, int[][] roads) {
        boolean[] f=new boolean[n+1];
        List<int[]>[] g=new List[n+1];
        Arrays.setAll(g,e->new ArrayList<>());
        for (int[] road : roads) {
            g[road[0]].add(new int[]{road[1],road[2]});
            g[road[1]].add(new int[]{road[0],road[2]});
        }
        dfs(1,g,f);
        return r;
    }
    int r=Integer.MAX_VALUE;
    private void dfs(int curr,List<int[]>[] g,boolean[] f){
        f[curr]=true;
        for (int[] t : g[curr]) {
            r=Math.min(r,t[1]);
            if (!f[t[0]])
                dfs(t[0],g,f);
        }
    }
}
