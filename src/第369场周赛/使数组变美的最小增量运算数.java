package 第369场周赛;

public class 使数组变美的最小增量运算数 {
    public static long minIncrementOperations(int[] nums, int k) {
        int n=nums.length;
        long[][] f=new long[n][2];//0代表当前不补，1代表当前补齐
        f[0][1]=k>nums[0]?k-nums[0]:0;
        f[1][1]=f[0][0]+k>nums[1]?k-nums[1]:0;
        for (int i=2;i<n;i++){
            f[i][0]=Math.min(f[i-1][1],f[i-2][1]);
            if (k>nums[i])
                f[i][1]=Math.min(f[i-1][0],f[i-1][1])+k-nums[i];
            else
                f[i][1]=Math.min(f[i-1][0],f[i-1][1]);
        }
        return Math.min(f[n-1][0],f[n-1][1]);
    }
    public static void main(String[] args) {
        System.out.println(minIncrementOperations(new int[]{0,1,3,3},5));
    }
}
