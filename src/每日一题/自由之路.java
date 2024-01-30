package 每日一题;

import java.util.Arrays;
import java.util.Map;

public class 自由之路 {

    public int findRotateSteps(String ring, String key) {
        int n1=ring.length();
        int n2=key.length();
        char[] cs=ring.toCharArray();
        char[] ck=key.toCharArray();
        int[][] dp=new int[n2][n1];
        for (int i=0;i<n2;i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE/2);
        for (int i=0;i<n1;i++)
            if (cs[i]==ck[0]) {
                dp[0][i] = i > n1 / 2 ? n1 - i : i;
                dp[0][i]++;
            }
        for (int i=1;i<n2;i++){
            for (int j=0;j<n1;j++){
                if (cs[j]==ck[i]){
                    for (int h=0;h<n1;h++){
                        if (dp[i-1][h]!=Integer.MAX_VALUE/2){
                            dp[i][j]=Math.min(dp[i][j],dp[i-1][h]+((h-j+n1)%n1>n1/2?(j-h+n1)%n1:(h-j+n1)%n1)+1);

                        }
                    }
                }
            }
        }
        int r=Integer.MAX_VALUE;
        for (int i=0;i<n1;i++)
            r=Math.min(r,dp[n2-1][i]);
        return r;
    }

    public static void main(String[] args) {
        自由之路 t=new 自由之路();
        System.out.println(t.findRotateSteps("godding","gd"));
    }
}
