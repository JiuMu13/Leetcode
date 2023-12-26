package 每日一题;

import java.util.Arrays;

public class 参加考试的最大学生数 {
    public int maxStudents(char[][] seats) {
        int m=seats.length;
        int n=seats[0].length;
        int[][] dp=new int[m+1][1<<n];
        for (int i=0;i<=m;i++)
            Arrays.fill(dp[i],-1);
        Arrays.fill(dp[0],0);
        int[] ss=new int[m+1];
        for (int i=1;i<=m;i++){
            for (int k=0;k<n;k++){
                if (seats[i-1][k]=='.')
                    ss[i]+=1<<k;
            }
            for (int j=0;j<1<<n;j++){
                if ((ss[i]|j)>ss[i])//不能坐在坏椅子上
                    continue;
                boolean f=true;
                for (int k=0;k<n-1;k++){
                    if ((j&(1<<k))!=0 && (j&(1<<k+1))!=0)
                        f=false;
                }
                if (!f)//不能坐在相邻椅子上
                    continue;
                for(int last=0;last< (1<<n);last++){
                    if (dp[i-1][last]==-1)
                        continue;
                    if ((last&(j<<1))!=0 || (last&(j>>1))!=0)
                        continue;
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][last]+count(j));
                }
            }
        }
        int r=0;
        for (int i=0;i<1<<n;i++){
            r=Math.max(r,dp[m][i]);
        }
        return r;
    }
    private int count(int n){
        int r=0;
        while (n!=0){
            if ((n&1)==1)   r++;
            n>>=1;
        }
        return r;
    }

    public static void main(String[] args) {
        参加考试的最大学生数 t=new 参加考试的最大学生数();
        char[][] c={{'.','#','#','.'},{'.','.','.','#'},{'.','.','.','.'},{'#','.','#','#'}};
//        char[][] c={{'#','.','#','#','.','#'},{'.','#','#','#','#','.'},{'#','.','#','#','.','#'}};
//        char[][] c={{'.','.','#','#'},{'.','#','.','.'},{'#','.','.','#'},{'#','#','#','.'}};
        System.out.println(t.maxStudents(c));

    }
}
