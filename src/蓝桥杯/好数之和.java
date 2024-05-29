package 蓝桥杯;

import java.util.Arrays;
import java.util.Scanner;

//未完成
public class 好数之和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l=sc.nextInt();
        String r=sc.next();
        dp=new long[r.length()];
        Arrays.fill(dp,-1);
        cs=String.valueOf(l-1).toCharArray();
        long rl=f(0,0,true,false,false);
        cs=r.toCharArray();
        long rr=f(0,0,true,false,false);
        System.out.println(rr-rl);
    }

    static long[] dp;
    static char[] cs;

    private static long f(int i,int pre,boolean lim,boolean hasNum,boolean have){
        if (pre==2022)
            System.out.println(1);
        if (have)
            System.out.println(2);
        if (i==cs.length)
            return have?pre:0;
        if (!lim && hasNum && dp[i]!=-1)
            return dp[i];
        long r=0;
        if (!hasNum)
            r=f(i+1,0,false,false,false);
        int up=lim?cs[i]-'0':9;
        for (int d=hasNum?0:1;d<=up;d++){
            r+=f(i+1,pre*10+d,lim && d==up,true,have || (pre%1000*10+d)==2022);
        }
        if (!lim && hasNum)
            dp[i]=r;
        return r;
    }

}
