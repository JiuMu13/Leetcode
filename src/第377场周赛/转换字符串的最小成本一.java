package 第377场周赛;

import java.util.Arrays;

public class 转换字符串的最小成本一 {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] g=new long[26][26];
        for (int i=0;i<26;i++)
            Arrays.fill(g[i],Long.MAX_VALUE/2);
        for (int i=0;i<original.length;i++){
            if (g[original[i]-'a'][changed[i]-'a']>cost[i])
            g[original[i]-'a'][changed[i]-'a']=cost[i];
        }
        for (int k=0;k<26;k++){
            for (int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    g[i][j]=Math.min(g[i][j],g[i][k]+g[k][j]);
                }
            }
        }
        long r=0;
        for (int i=0;i<source.length();i++){
            int s=source.charAt(i)-'a',t=target.charAt(i)-'a';
            if (s==t)
                continue;
            if (g[s][t]<Long.MAX_VALUE/2)
                r+=g[s][t];
            else
                return -1;
        }
        System.out.println();
        return r;
    }

    public static void main(String[] args) {
        转换字符串的最小成本一 t=new 转换字符串的最小成本一();
        char[] s1=new char[]{'a','b','c','c','e','d'};
        char[] s2=new char[]{'b','c','b','e','b','e'};
        int[] c=new int[]{2,5,5,1,2,20};
        System.out.println(t.minimumCost("abcd","acbe",s1,s2,c));
    }
}
