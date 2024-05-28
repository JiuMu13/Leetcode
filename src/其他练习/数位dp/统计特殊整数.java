package 其他练习.数位dp;

import java.util.Arrays;

public class 统计特殊整数 {
    public static void main(String[] args) {
        new 统计特殊整数().countSpecialNumbers(20);

    }
    public int countSpecialNumbers(int n) {
        cs = String.valueOf(n).toCharArray();
        int len=cs.length;
        dp=new int[len][1<<11];
        for (int[] ints : dp)
            Arrays.fill(ints,-1);
        return f(0,0,false,true);
    }
    char[] cs;
    int[][] dp;
    private int f(int i,int mask,boolean hasNum,boolean limit){
        if (i==cs.length)
            return hasNum?1:0;
        if (!limit && hasNum && dp[i][mask]!=-1){
            return dp[i][mask];
        }
        int r=0;
        //前导零情况
        if (!hasNum){
            r=f(i+1,mask,false,false);
        }
        int up=limit?cs[i]-'0':9;
        for (int n=hasNum?0:1;n<=up;n++){
            if (((mask>>n)&1)==0){
                r+=f(i+1,mask+(1<<n),true,limit && n==up );
            }
        }
        if (!limit && hasNum)
            dp[i][mask]=r;
        return r;
    }
}
