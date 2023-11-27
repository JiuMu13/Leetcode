package 每日一题;

public class 掷骰子等于目标和的方法数 {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] f=new int[n+1][target+1];//1代表投的骰子数2代表投的点数和
        int mod=(int)1e9+7;
        for (int j=1;j<=k && j<=target;j++){
            f[1][j]=1;
        }
        for (int i=2;i<n+1;i++){
            for (int j=1;j<=target;j++){
                for (int h=1;h<=k && h<j;h++){
                    f[i][j]=(f[i][j]+f[i-1][j-h])%mod;
//                    System.out.println(f[i][j]+"  i"+i+"  j"+j);
                }
            }
        }
        return f[n][target];
    }

    public static void main(String[] args) {
        掷骰子等于目标和的方法数 t=new 掷骰子等于目标和的方法数();
        System.out.println(t.numRollsToTarget(2,6,7));
    }
}
