package 第370场周赛;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
//todo 未完成
public class 平衡子序列的最大和 {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n=nums.length;
        int[] t=new int[n];
        for (int i=0;i<n;i++){
            t[i]=nums[i]-i;
        }
        for (int i=0;i<n;i++){
            
        }
        return -1;
    }

    public static void main(String[] args) {
        平衡子序列的最大和 t=new 平衡子序列的最大和();
        int[] s={-2,-1};
        System.out.println(t.maxBalancedSubsequenceSum(s));
    }
}
