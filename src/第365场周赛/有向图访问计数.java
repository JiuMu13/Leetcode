package 第365场周赛;

import java.util.Arrays;
import java.util.List;
//超时
public class 有向图访问计数 {
    int[] hs;
    boolean[] f;
    int dd;
    int count;
    List<Integer> g;
    boolean r;
    public int[] countVisitedNodes(List<Integer> edges) {
        int n=edges.size();
        hs=new int[n];
        f=new boolean[n];
        g=edges;
        int[] result=new int[n];
        Arrays.fill(hs,1);
        for (int i = 0; i <n ; i++) {
            count=0;
            dd=i;
            r=false;
            dfs(i);
        }
        for (int i=0;i<n;i++){
            int sum=0;
            int j=i;
            while (!f[j]){
                sum+=hs[j];
                j=g.get(j);
            }
            sum+=hs[j];
            result[i]=sum;
        }
        return result;
    }
    private void dfs(int x){
        if (!f[x]) {
            f[x] = true;
            count++;
            if (!f[g.get(x)]) {
                dfs(g.get(x));
            } else {
                if (g.get(x) == dd)
                    r = true;
            }
            if (r)
                hs[x] = count;
            else
                f[x] = false;
        }
    }
}
