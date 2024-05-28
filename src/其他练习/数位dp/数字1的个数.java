package 其他练习.数位dp;


import java.util.Arrays;

public class 数字1的个数 {
    public static void main(String[] args) {
        System.out.println(new 数字1的个数().countDigitOne(30));
    }
    public int countDigitOne(int n) {
        cs=String.valueOf(n).toCharArray();
        dp=new int[cs.length][cs.length];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
        return f(0,0,true,false);
    }
    char[] cs;
    int[][] dp;

    private int f(int i,int c1,boolean lim,boolean hasNum){
        if (i==cs.length)
            return c1;
        if (!lim && hasNum && dp[i][c1]!=-1)
            return dp[i][c1];
        int r=0;
        if (!hasNum)
            r=f(i+1,c1,false,false);
        int up=lim?cs[i]-'0':9;
        for (int n=hasNum?0:1;n<=up;n++){
            r+=f(i+1,c1+(n==1?1:0),lim && n==up ,true);
        }
        if (!lim && hasNum)
            dp[i][c1]=r;
        return r;
    }
}
