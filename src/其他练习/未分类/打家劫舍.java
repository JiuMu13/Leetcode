package 其他练习.未分类;

public class 打家劫舍 {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        dp[1]=nums[0];
        for (int i=2;i<n+1;i++){
            dp[i]=Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }
        return Math.max(dp[n],dp[n-1]);
    }

}
