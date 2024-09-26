package 其他练习.未分类;

import java.util.Arrays;

public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        dp[0]=0;
        for (int i=0;i<n;i++){
            for (int j=coins[i];j<=amount;j++){
                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[amount]>=Integer.MAX_VALUE/2?-1:dp[amount];
    }
}
