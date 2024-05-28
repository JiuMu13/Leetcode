package 其他练习.数位dp;

import java.util.Arrays;

public class 最大为N的数字组合 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        this.digits=digits;
        cs=String.valueOf(n).toCharArray();
        for (int[] ints : dp)
            Arrays.fill(ints,-1);

    }
    String[] digits;
    int[] dp;
    char[] cs;
    private int f(int i,boolean lim,boolean hasNum){
        if (i==cs.length)
            return 1;
        if (!lim && hasNum && dp[i]!=-1)
            return dp[i];

    }
}
