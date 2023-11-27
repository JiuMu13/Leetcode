package 每日一题;

import java.util.Arrays;

public class 得到K个半回文串的最少修改次数 {
    public int minimumChanges(String s, int k) {
        int n=s.length();
        char[] cs=s.toCharArray();
        int[][] f=new int[n+1][k+1];
        int[][] c=new int[n][n];
        for (int i=0;i<n;i++){
            Arrays.fill(f[i],Integer.MAX_VALUE/2);
        }
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                int min=Integer.MAX_VALUE;
                for (int d=1;d<j-i+1;d++){
                    if ((j-i+1)%d!=0)
                        continue;
                    int count=0;
                    for (int h=0;h<d;h++) {
                        int l=i+h;
                        int r=j-(d-1)+h;
                        while (l <= r) {
                            if (cs[l] != cs[r]) {
                                count++;
                            }
                            l += d;
                            r -= d;
                        }
                    }
                    min = Math.min(min, count);
                }
                c[i][j]=min;
            }
        }
        for (int i=0;i<n;i++)
            c[i][i]=Integer.MAX_VALUE/2;
        //处理子字符串
        for (int i=0;i<n;i++){
            f[i][1]=c[0][i];
        }
        for (int i=0;i<n;i++){
            for (int j=1;j<=(i+1)/2 && j<=k;j++){
                for (int h=1;h<=i ;h++){
                    f[i][j]=Math.min(f[i][j],f[i-h][j-1]+c[i-h+1][i]);
                }
            }
        }
        return f[n-1][k];
    }
    public static void main(String[] args) {
        得到K个半回文串的最少修改次数 t=new 得到K个半回文串的最少修改次数();
//        System.out.println(t.minimumChanges("abcdef",2));
        System.out.println(t.minimumChanges("acba",2));

    }
}
