package 每日一题;

import java.util.*;
//dfs+树形dp
public class 最小化旅行的价格总和 {
    List<Integer>[] g;
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        g=new List[n];
        for (int i=0;i<n;i++) g[i]=new ArrayList<>();
        for (int[] e:edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        for (int[] e:trips){
            lx(e[0],-1,e[1]);
        }
        int f=0;
        int[] result=dp(0,-1,price);
        return Math.min(result[0],result[1]);
    }
    int[] map= new int[50];
    private int lx(int n,int last,int to){
        if (n==to) {
            map[n]++;
            return 0;
        }
        if (g[n].size()==1 && g[n].get(0)==last){
            return -1;
        }
        for (int e:g[n]){
            if (e==last)
                continue;
            int t=lx(e,n,to);
            if (t!=-1) {
                map[n]++;
                return 0;
            }
        }
        return -1;
    }
    private int[] dp(int n,int last,int[] price){
        int ori=map[n]*price[n];
        int half=ori/2;
        for (int e:g[n]){
            if (e==last)
                continue;
            int[] t=dp(e,n,price);
            ori+=Math.min(t[0],t[1]);
            half+=t[0];
        }
        return new int[]{ori,half};
    }


    public static void main(String[] args) {
        int[][] edges={{2,5},{3,4},{4,1},{1,7},{6,7},{7,0},{0,5},{5,8}};
        int[] price={4,4,6,4,2,4,2,14,8};
        int[][] trips={{1,5},{2,7},{4,3},{1,8},{2,8},{4,3},{1,5},{1,4},{2,1},{6,0},{0,7},
                {8,6},{4,0},{7,5},{7,5},{6,0},{5,1},{1,1},{7,5},{1,7},{8,7},{2,3},{4,1},
                {3,5},{2,5},{3,7},{0,1},{5,8},{5,3},{5,2}};
//        int[][] edges={{0,1},{1,2},{1,3}};
//        int[] price={2,2,10,6};
//        int[][] trips={{0,3},{2,1},{2,3}};
        最小化旅行的价格总和 t=new 最小化旅行的价格总和();
        System.out.println(t.minimumTotalPrice(9,edges,price,trips));

    }
}
