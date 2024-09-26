package 其他练习.未分类;

public class 任意子数组和的绝对值的最大值 {
    public int maxAbsoluteSum(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][2];
        dp[0][0]=nums[0]>0?0:nums[0];
        dp[0][1]=nums[0]<0?0:nums[0];
        int min=nums[0]>0?0:nums[0];
        int max=nums[0]<0?0:nums[0];
        for (int i=1;i<n;i++){
            dp[i][0]=Math.min(dp[i-1][0]+nums[i],nums[i]);
            dp[i][1]=Math.max(dp[i-1][1]+nums[i],nums[i]);
            if (dp[i][0]<min)
                min=dp[i][0];
            if (dp[i][1]>max)
                max=dp[i][1];
        }
        return Math.max(Math.abs(min),max);
    }

    public static void main(String[] args) {
        System.out.println(new 任意子数组和的绝对值的最大值().maxAbsoluteSum(new int[]{}));
    }
}
