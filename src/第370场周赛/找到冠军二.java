package 第370场周赛;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 找到冠军二 {
    Set<Integer> result=new HashSet<>();
    boolean[] f;
    public int findChampion(int n, int[][] edges) {
        List<Integer>[] l=new List[n];
        f=new boolean[n];
        for (int i=0;i<n;i++){
            l[i]=new ArrayList<Integer>();
        }
        for (int[] e:edges){
            l[e[1]].add(e[0]);
        }
        for (int i=0;i<n;i++)
            dfs(i,l);
        if (result.size()>1)
            return -1;
        else
            return result.iterator().next();
    }
    private void dfs(int x,List[] l){
        if (f[x])
            return;
        f[x]=true;
        if (l[x].size()==0)
            result.add(x);
        for (Object e:l[x]){
            dfs((int)e,l);
        }
    }

    public static void main(String[] args) {
        找到冠军二 t=new 找到冠军二();
        int[][] s={{0,1},{1,2}};
        t.findChampion(3,s);
    }
}
