package 其他练习.数位dp;

import java.util.Arrays;

public class 不含连续1的非负整数 {
    public static void main(String[] args) {
        System.out.println(new 不含连续1的非负整数().findIntegers(4));
    }

    public int findIntegers(int n) {
        cs = Integer.toString(n, 2).toCharArray();
        dp = new int[cs.length][2];
        for (int[] s : dp) {
            Arrays.fill(s, -1);
        }
        return f(0, false, true);
    }

    char[] cs;
    int[][] dp;

    private int f(int i, boolean isOne, boolean lim) {
        if (i == cs.length)
            return 1;
        if (!lim && dp[i][isOne ? 1 : 0] != -1)
            return dp[i][isOne ? 1 : 0];
        int r = 0;
        int up = lim ? cs[i] - '0' : 1;


        r += f(i + 1, false, lim && 0 == up);
        if (!isOne && up==1)
            r += f(i + 1, true, lim);

        if (!lim)
            dp[i][isOne ? 1 : 0] = r;
        return r;
    }
}
