package 每日一题二;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

public class 使数组连续的最少操作数 {
    public int minOperations(int[] nums) {
        int n= nums.length;
        if (n==1)
            return 0;
        Arrays.sort(nums);
        int curr=0;
        for (int i = 1; i < n; i++) {
            if (nums[curr]!=nums[i]){
                curr++;
                nums[curr]=nums[i];
            }
        }
        System.out.println(curr);
        System.out.println(Arrays.toString(nums));
        int l=0,r=-1;
        int sum=0;
        int res=0;
        while (r<curr){
            if (nums[++r]-nums[l]<n){
                sum++;
            }else {
                res=Math.max(res,sum);
                while (nums[r]-nums[l]>=n){
                    l++;
                    sum--;
                }
                sum++;
            }
        }
        res=Math.max(res,sum);
        return n-res;
    }

    public static void main(String[] args) {
        System.out.println(new 使数组连续的最少操作数().minOperations(new int[]{41,33,29,33,35,26,47,24,18,28}));
    }
}
