package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;

class 统计树中的合法路径数目 {
    ArrayList<Integer>[] list;
    static boolean[] isNPrimeNumber;
    int[] hads;
    boolean[] dfsf;
    boolean[] dff;
    static {
        isNPrimeNumber=new boolean[100010];//判断当前值是否为质数，从1到n，以下标为值
        isNPrimeNumber[1]=true;
        //标记所有的质数
        for (int i=2;i<=100000;i++)
            for (int j=2;j*j<=i;j++)
                if (i%j==0)
                    isNPrimeNumber[i]=true;
    }
    public long countPaths(int n, int[][] edges) {
        //建树
        list=new ArrayList[n+1];//从1到n
        Arrays.setAll(list, e -> new ArrayList<>());
        for (int i=0;i<edges.length;i++){
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        //
        hads=new int[n+1];
        dfsf=new boolean[n+1];
        dff=new boolean[n+1];
        //
        long result=0,curr,sum;
        boolean dd;
        for (int i=1;i<=n;i++){
            dd=true;
            if (!isNPrimeNumber[i]){
                sum=0;
                curr=dfs(i);
                for (Integer e:list[i]) {
                    if (isNPrimeNumber[e]){
                        dd=false;
                        curr-=hads[e];
                        sum+=hads[e]*curr;
                        tc(e,hads[e]);
                    }
                }
                if (dd)
                    hads[i]=0;
                result+=hads[i]+sum;
            }
        }
        return result;
    }
    private int dfs(int n){
        if (hads[n]!=0)
            return hads[n];
        dfsf[n]=true;
        if (isNPrimeNumber[n])
            hads[n]=1;
        for (int i=0;i<list[n].size();i++)
            if (isNPrimeNumber[list[n].get(i)] && !dfsf[list[n].get(i)])
                hads[n]+=dfs(list[n].get(i));
        dfsf[n]=false;
        return hads[n];
    }
    public void tc(int n,int v){
        if(dff[n])
            return;
        hads[n]=v;
        dff[n]=true;
        for (int i=0;i<list[n].size();i++) {
            if (isNPrimeNumber[list[n].get(i)] && !dfsf[list[n].get(i)]){
                tc(list[n].get(i),v);
            }
        }
    }

    public static void main(String[] args) {
        统计树中的合法路径数目 t=new 统计树中的合法路径数目();
        int[][] s={{7,4},{3,4},{5,4},{1,5},{6,4},{9,5},{8,7},{2,8}};
        System.out.println(t.countPaths(9,s));
    }
}