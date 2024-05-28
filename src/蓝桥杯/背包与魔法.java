package 蓝桥杯;

import java.util.Scanner;

public class 背包与魔法 {
    public static void main(String[] args) {
        //读入数据
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int t = 1;
        while (t <= n) {
            w[t] = sc.nextInt();
            v[t++] = sc.nextInt();
        }
        //创建dp数组，dp[a][0]为重量为a时不使用魔法所得到的价值，dp[a][1]则为使用魔法的价值
        int[][] dp = new int[m + 1][2];
        for (int i = 1; i <= n; i++) {
            //此处从m开始向0遍历，可以省去一个中间数组记录上一次的结果，相当于把上一次的结果直接覆盖了，并且不会使用到本次循环的结果
            for (int j = m; j >= w[i]; j--) {
                dp[j][0] = Math.max(dp[j-w[i]][0] + v[i],dp[j][0]);
                //此处为使用魔法的情况
                if (j-w[i]-k>=0)
                    dp[j][1]=Math.max(dp[j][1],Math.max(dp[j-w[i]][1]+v[i],dp[j-w[i]-k][0]+v[i]*2));
            }
        }
        System.out.println(Math.max(dp[m][0],dp[m][1]));
    }
}
