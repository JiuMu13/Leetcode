package 第369场周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 收集所有金币可获得的最大积分 {
    int k;
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        int n=edges.length+1;
        this.k=k;
        int[][] f=new int[15][n];//1.表示进行了i次右移操作2.表示前n个节点
        for (int i=0;i<15;i++)
            Arrays.fill(f[i],-1);
        List<Integer>[] tree=new List[n];
        for (int i=0;i<n;i++){
            tree[i]=new ArrayList<>();
        }
        for (int[] s:edges){
            tree[s[0]].add(s[1]);
            tree[s[1]].add(s[0]);
        }
        return dfs(0,0,tree,-1,f,coins);
    }
    private int dfs(int n,int y,List<Integer>[] tree,int ff,int[][] f,int[] coins){
        if (f[y][n]!=-1){
            return f[y][n];
        }
        int result1= (coins[n]>>y) - k;
        int result2=coins[n]>>(y+1);
        for (Integer e:tree[n]){
            if (e==ff)
                continue;
            result1+=dfs(e,y,tree,n,f,coins);
            if (y<13)//因为最大数为10000，当进行大于13次减半操作时，结果都为0
                result2+=dfs(e,y+1,tree,n,f,coins);
        }
        return f[y][n]=Math.max(result1,result2);
    }
}
