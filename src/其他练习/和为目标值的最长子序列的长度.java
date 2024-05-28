package 其他练习;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class 和为目标值的最长子序列的长度 {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for (Integer num : nums) {
            for (int i=target;i>=num;i--){
                if (dp[i-num]!=-1)
                    dp[i]= Math.max(dp[i],dp[i-num]+1);
            }
        }
        return dp[target];
    }
}
