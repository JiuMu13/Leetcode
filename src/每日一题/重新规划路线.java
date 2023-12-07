package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 重新规划路线 {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] g=new List[n];
        for (int i=0;i<n;i++){
            g[i]=new ArrayList<>();
        }
        for (int[] e:connections) {
            g[e[0]].add(new int[]{0,e[1]});
            g[e[1]].add(new int[]{1,e[0]});
        }
        return dfs(0,-1,g);
    }
    private int dfs(int n,int last,List<int[]>[] g){
        int r=0;
        for (int[] e:g[n]){
            if (e[1]==last)
                continue;
            if (e[0]==0)
                r++;
            r+=dfs(e[1],n,g);
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] g={{1,2},{2,3},{4,5},{3,5},{2,0},{1,6},{2,7},{7,8},{3,9}};
        重新规划路线 t=new 重新规划路线();
        System.out.println(t.minReorder(10,g));
    }
}
