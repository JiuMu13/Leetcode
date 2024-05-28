package 其他练习.数位dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class 最大为N的数字组合 {
    public static void main(String[] args) {
        System.out.println(new 最大为N的数字组合().atMostNGivenDigitSet(new String[]{"1","3","5","7"},100));
    }
    public int atMostNGivenDigitSet(String[] digits, int n) {
        this.digits=new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            this.digits[i]=Integer.valueOf(digits[i]);
        }
        cs=String.valueOf(n).toCharArray();
        this.dp=new int[cs.length];
        Arrays.fill(dp,-1);
        return f(0,true,false);
    }
    int[] digits;
    int[] dp;
    char[] cs;
    private int f(int i,boolean lim,boolean hasNum){
        if (i==cs.length)
            return hasNum?1:0;
        if (!lim && hasNum && dp[i]!=-1)
            return dp[i];
        int r=0;
        if (!hasNum)
            r=f(i+1,false,false);
        int up=lim?cs[i]-'0':9;
        for (Integer digit : digits) {
            if (digit<=up){
                r+=f(i+1,lim && digit==up,true);
            }
        }
        if (!lim && hasNum)
            dp[i]=r;
        return r;
    }
}
