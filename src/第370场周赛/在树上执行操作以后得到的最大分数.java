package 第370场周赛;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 在树上执行操作以后得到的最大分数 {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n=edges.length+1;
        List<List<Integer>> l=new ArrayList<>();
        for (int i=0;i<n;i++)
            l.add(new ArrayList<>());
        for (int[] e:edges){
            l.get(e[0]).add(e[1]);
            l.get(e[1]).add(e[0]);
        }
        long del=dfs(0,-1,l,values);
        long sum=0;
        for (int e:values)
            sum+=e;
        return sum-del;
    }
    private long dfs(int x,int last,List<List<Integer>> l,int[] values){
        if (l.get(x).size()==1 && last!=-1)
            return values[x];
        long min=0;
        for (Integer e:l.get(x)){
            if (e!=last)
                min+=dfs(e,x,l,values);
        }
        if (min>values[x])
            return values[x];
        else
            return min;
    }
}
