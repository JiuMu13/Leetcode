package 其他练习.数位dp;

import java.util.Arrays;

public class 二出现的次数 {
    public int numberOf2sInRange(int n) {
        cs=String.valueOf(n).toCharArray();
        dp=new int[cs.length][cs.length];
        for (int[] ints : dp)
            Arrays.fill(ints,-1);
        return f(0,0,true,false);
    }
    int[][] dp;
    char[] cs;
    private int f(int i,int c2,boolean lim,boolean hasNum){
        if (i==cs.length)
            return c2;
        if (!lim && dp[i][c2]!=-1)
            return dp[i][c2];
        int r=0;
        if (!hasNum)
            r=f(i+1,0,false,false);
        int up=lim?cs[i]-'0':9;
        for (int d=hasNum?0:1;d<=up;d++){
            r+=f(i+1,c2+(d==2?1:0),lim && up==d,true);
        }
        if (!lim)
            dp[i][c2]=r;
        return r;
    }
}
