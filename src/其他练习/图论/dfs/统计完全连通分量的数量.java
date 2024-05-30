package 其他练习.图论.dfs;

import java.util.*;

public class 统计完全连通分量的数量 {
    public static void main(String[] args) {
        System.out.println(new 统计完全连通分量的数量().countCompleteComponents(6,new int[][]{{0,1},{0,2},{1,2},{3,4}}));
    }
    public static  int countCompleteComponentsBFS(int n, int[][] edges) {
        boolean[][] g=new boolean[n][n];
        boolean[] f=new boolean[n];
        for (int[] edge : edges) {
            g[edge[0]][edge[1]]=true;
            g[edge[1]][edge[0]]=true;
        }
        Queue<Integer> q=new ArrayDeque<>();
        int r=0;
        for (int i=0;i<n;i++){
            if (!f[i]){
                f[i]=true;
                q.add(i);
                int c=-1;
                int cf=-1;
                while (!q.isEmpty()){
                    Integer t = q.remove();
                    cf++;
                    int ct=0;
                    for (int j=0;j<n;j++) {
                        if (g[t][j])
                            ct++;
                        if (!f[j] && g[t][j] ) {
                            f[j]=true;
                            q.add(j);
                        }
                    }
                    if (c==-1)
                        c=ct;
                    else if (c!=ct){
                        c=-2;
                    }
                }
                if (c>=0 && c==cf)
                    r++;
            }
        }
        return r;
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] g=new List[n];
        boolean[] f=new boolean[n];
        Arrays.setAll(g,e->new ArrayList<>());
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        int r=0;
        for (int i=0;i<n;i++){
            if (!f[i]) {
                e=0;
                v=0;
                dfs(i, g, f);
                if (v*v-v==e)
                    r++;
            }
        }
        return r;
    }
    int e;
    int v;
    private void dfs(int curr,List<Integer>[] g,boolean[] f){
        f[curr]=true;
        v++;
        for (Integer i : g[curr]) {
            e++;
            if (!f[i])
                dfs(i,g,f);
        }
    }
}
