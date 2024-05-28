package 其他练习.数位dp;

import java.util.Arrays;

public class 旋转数字 {
    static int[] t = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
    int[][] dp;
    char[] cs;

    public int rotatedDigits(int n) {
        String ns=Integer.toString(n);
        dp=new int[ns.length()][2];
        cs=ns.toCharArray();
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
        return dg(0,0,true);
    }
    private int dg(int i,int dif,boolean lim){
        if (i==cs.length)
            return dif;
        if (!lim && dp[i][dif]>=0) return dp[i][dif];
        int res=0;
        int up=lim?cs[i]-'0':9;
        for (int j=0;j<=up;j++){
            if (t[j]!=-1)
                res+=dg(i+1,dif|t[j],lim && j==up);
        }
        if (!lim) dp[i][dif]=res;
        return res;
    }
}
