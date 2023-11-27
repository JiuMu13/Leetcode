package 每日一题;

import java.util.*;

public class 统计无向图中无法互相到达点对数 {
    int[] p;
    Map<Integer,Integer> map;
    public long countPairs(int n, int[][] edges) {
        p=new int[n];
        for (int i=0;i<n;i++){
            p[i]=i;
        }
        map=new HashMap<>();
        for (int i=0;i<edges.length;i++){
            merge(edges[i][0],edges[i][1]);
        }
        for (int i=0;i<n;i++)
            find(i);
        for (int i=0;i<n;i++){
            map.put(p[i], map.get(p[i]) == null ? 1 : map.get(p[i]) + 1);
        }
        List<Integer> set=new ArrayList<>(map.values());
        long sum=0;
        for (Integer e:set) {
            sum += e;
        }
        long result=0;
        for (Integer e:set){
            sum-=e;
            result+=sum*e;
        }
        return result;
    }
    private int find(int x){
        if (p[x]!=x)
            p[x]=find(p[x]);
        return p[x];
    }
    private void merge(int x,int y){
        if (find(x)!=find(y)) {
            p[find(y)] = find(x);
        }
    }

    public static void main(String[] args) {
        统计无向图中无法互相到达点对数 t=new 统计无向图中无法互相到达点对数();
        int[][] s={{1,0},{3,1},{0,4},{2,1}};
        System.out.println(t.countPairs(5,s));
    }
}
