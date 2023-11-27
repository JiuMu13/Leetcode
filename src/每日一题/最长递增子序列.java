package 每日一题;

public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][2];//0代表以第i位结尾的最大长度，1代表最大值
        dp[0][0]=1;
        dp[0][1]=nums[0];
        for(int i=1;i<nums.length;i++){
            int length=0;
            for (int j=0;j<i;j++){
                if (nums[i]>dp[j][1]) {
                    length = dp[j][0] + 1;
                    if (length > dp[i][0]) {
                        dp[i][0] = length;
                        dp[i][1] = nums[i];
                    }
                }
            }
            if (dp[i][0]==0){
                dp[i][0]=1;
                dp[i][1]=nums[i];
            }
        }
        int result=0;
        for (int i=0;i<nums.length;i++){
            result=Math.max(result,dp[i][0]);
        }
        return result;
    }

    public static void main(String[] args) {
        最长递增子序列 t=new 最长递增子序列();
        int[] n={3,1,2};
        System.out.println(t.lengthOfLIS(n));
    }
}
