package 第377场周赛;

import java.util.*;

public class 转换字符串的最小成本二 {
    /*
    字符串哈希实现
     */
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n=original.length;
        Map<Long,Integer> map=new HashMap<>();
        int P=131;
        long mod=(long) 1e9+7;
        long[] ori=new long[n];
        for (int j=0;j<n;j++){
            long t=0;
            char[] cs=original[j].toCharArray();
            for (int i=0;i<cs.length;i++)
                t=(t*P+cs[i])%mod;
            ori[j]=t;
        }
        long[] cha=new long[n];
        for (int j=0;j<n;j++){
            long t=0;
            char[] cs=changed[j].toCharArray();
            for (int i=0;i<cs.length;i++)
                t=(t*P+cs[i])%mod;
            cha[j]=t;
        }
        int f=0;
        for (int i=0;i<ori.length;i++)
            if (!map.containsKey(ori[i]))
                map.put(ori[i],f++);
        for (int i=0;i<cha.length;i++)
            if (!map.containsKey(cha[i]))
                map.put(cha[i],f++);
        int[][] g=new int[f][f];
        for (int i=0;i<f;i++)
            Arrays.fill(g[i],Integer.MAX_VALUE>>1);
        for (int i=0;i<n;i++)
            g[map.get(ori[i])][map.get(cha[i])]=Math.min(g[map.get(ori[i])][map.get(cha[i])],cost[i]);
        for (int k=0;k<f;k++){
            for (int i=0;i<f;i++){
                for (int j=0;j<f;j++){
                    g[i][j]=Math.min(g[i][j],g[i][k]+g[k][j]);
                }
            }
        }
        int len=source.length();
        char[] csou=source.toCharArray();
        char[] ctar=target.toCharArray();
        long[] dp=new long[len+1];
        Arrays.fill(dp,Long.MAX_VALUE);
        dp[0]=0;
        for (int i=0;i<source.length();i++){
            if (csou[i]==ctar[i])
                dp[i+1]=Math.min(dp[i+1],dp[i]);
            long t=0;
            long s=0;
            for (int j=i;j<source.length();j++){
                t=(t*P+ctar[j])%mod;
                s=(s*P+csou[j])%mod;
                if ( dp[i]!=Long.MAX_VALUE && map.containsKey(s) && map.containsKey(t)
                        && g[map.get(s)][map.get(t)]<Integer.MAX_VALUE>>1){
                    dp[j+1]=Math.min(dp[j+1],dp[i]+g[map.get(s)][map.get(t)]);
                }
            }
        }
        return dp[source.length()]==Long.MAX_VALUE?-1:dp[source.length()];
    }

    public static void main(String[] args) {
        转换字符串的最小成本二 t=new 转换字符串的最小成本二();
        String s1="abcdefgh";
        String s2="acdeeghh";
        String[] c1=new String[]{"bcd","fgh","thh"};
        String[] c2=new String[]{"cde","thh","ghh"};
        int[] a=new int[]{1,3,5};
        System.out.println(t.minimumCost(s1,s2,c1,c2,a));
    }
}
