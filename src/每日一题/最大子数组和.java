package 每日一题;

//动态规划
//也可以用前缀和，需求出最小前缀和的数组
public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];//以i结尾的最大子数组
        dp[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            int f=dp[i-1]>0?dp[i-1]:0;
            dp[i]=f+nums[i];
        }
        int result=Integer.MIN_VALUE;
        for (int e:dp){
            result=Math.max(result,e);
        }
        return result;
    }

    public static void main(String[] args) {
        最大子数组和 t=new 最大子数组和();
        int[] n={-2,1,-3,4,-1,2,1,-100,4};
        System.out.println(t.maxSubArray(n));
    }
}
