package 每日一题;

import java.util.Arrays;

//动态规划解法
public class 分割数组的最大值 {
    public static int splitArray(int[] nums, int k) {
        int n=nums.length;
        int[][] dp=new int[n][k+1];
        int[] pre=new int[n+1];
        for (int i=1;i<=n;i++)
            pre[i]=pre[i-1]+nums[i-1];
        for (int[] e:dp)
            Arrays.fill(e,Integer.MAX_VALUE);

        for (int i=0;i<=n-k;i++){
            dp[i][1]=pre[i+1];
        }

        for (int i=0;i<n;i++){
            for (int j=1;j<k;j++){
                for (int h=i+1;h<n;h++){
                    if (dp[i][j]!=Integer.MAX_VALUE)
                        dp[h][j+1]=Math.min(dp[h][j+1],Math.max(dp[i][j],pre[h+1]-pre[i+1]));
                }
            }
        }
        return dp[n-1][k];
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7,2,5,10,8},2));
    }
}

//二分查找解法
class Solution {

    public int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;

        // 计算「子数组各自的和的最大值」的上下界
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        // 使用「二分查找」确定一个恰当的「子数组各自的和的最大值」，
        // 使得它对应的「子数组的分割数」恰好等于 m
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;

            int splits = split(nums, mid);
            if (splits > m) {
                // 如果分割数太多，说明「子数组各自的和的最大值」太小，此时需要将「子数组各自的和的最大值」调大
                // 下一轮搜索的区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是上一轮的反面区间 [left, mid]
                right = mid;
            }
        }
        return left;
    }

    /***
     *
     * @param nums 原始数组
     * @param maxIntervalSum 子数组各自的和的最大值
     * @return 满足不超过「子数组各自的和的最大值」的分割数
     */
    private int split(int[] nums, int maxIntervalSum) {
        // 至少是一个分割
        int splits = 1;
        // 当前区间的和
        int curIntervalSum = 0;
        for (int num : nums) {
            // 尝试加上当前遍历的这个数，如果加上去超过了「子数组各自的和的最大值」，就不加这个数，另起炉灶
            if (curIntervalSum + num > maxIntervalSum) {
                curIntervalSum = 0;
                splits++;
            }
            curIntervalSum += num;
        }
        return splits;
    }
}
