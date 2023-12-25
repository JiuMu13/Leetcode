package 第120场双周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 树中每个节点放置的金币数目 {
    public long[] placedCoins(int[][] edges, int[] cost) {
        int n=cost.length;
        List<Integer>[] g=new List[n];
        for (int i=0;i<n;i++)
            g[i]=new ArrayList<>();
        for (int[] e:edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        r=new long[n];
        dfs(0,-1,g,cost);
        return r;
    }
    long[] r;
    //7个长度，0为有几个值，1为总花费，2,3,分别为最小的两个，4,5,6为最大的三个
    private long[] dfs(int n,int last,List<Integer>[] g,int[] cost){
        if (g[n].size()==1 && last!=-1){
            this.r[n]=1;
            return new long[]{1,1,cost[n]};
        }
        long[] r=new long[7];
        r[0]=1;
        r[2]=cost[n];
        for (Integer e:g[n]){
            if (e==last)
                continue;
            long[] t=dfs(e,n,g,cost);
            if (r[0]+t[0]<=5){
                int nn=(int)(r[0]+t[0]);
                long[] bj=new long[nn];
                int i;
                for (i=0;i<r[0];i++){
                    bj[i]=r[2+i];
                }
                for (int f=0;i<r[0]+t[0];i++,f++){
                    bj[i]=t[2+f];
                }
                Arrays.sort(bj);
                for (int j=0;j<nn;j++)
                    r[2+j]=bj[j];
                r[0]=r[0]+t[0];
            }else {
                int nn=(int)(r[0]+t[0]);
                long[] bj=new long[nn];
                int i;
                for (i=0;i<r[0];i++){
                    bj[i]=r[2+i];
                }
                for (int f=0;i<r[0]+t[0];i++,f++){
                    bj[i]=t[2+f];
                }
                Arrays.sort(bj);
                r[2]=bj[0];
                r[3]=bj[1];
                r[4]=bj[nn-3];
                r[5]=bj[nn-2];
                r[6]=bj[nn-1];
                r[0]=5;
            }
        }
        long currc;
        int len=(int)r[0];
        if (r[0]>=3){
            if (r[2]*r[3]*r[2+len-1]>=r[2+len-1]*r[2+len-2]*r[2+len-3])
                currc=r[2]*r[3]*r[2+len-1];
            else
                currc=r[2+len-1]*r[2+len-2]*r[2+len-3];
            if (currc<0)
                currc=0;
        }else
            currc=1;
        r[1]+=currc;
        this.r[n]=r[1];
        return r;
    }

    public static void main(String[] args) {
        树中每个节点放置的金币数目 t=new 树中每个节点放置的金币数目();
        int[][] ss={{0,1},{0,2},{2,3}};
        int[] s={10000,-10000,10000,-10000};
        System.out.println(t.placedCoins(ss,s));
    }
}
