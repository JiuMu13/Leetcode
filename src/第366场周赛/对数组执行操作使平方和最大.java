package 第366场周赛;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class 对数组执行操作使平方和最大 {
    public int maxSum(List<Integer> nums, int k) {
        long MOD =(long)1e9+7;
        int[] cnt = new int[30];
        for (int x : nums) {
            for (int i = 0; i < 30; i++) {
                cnt[i] += (x >> i) & 1;
            }
        }
        long result = 0;
        int x;
        while (k > 0) {
            x = 0;
            for (int i = 0; i < 30; i++) {
                if (cnt[i] > 0) {
                    cnt[i]--;
                    x |= 1 << i;
                }
            }
            result = (result + (long) x * x) % MOD;
            k--;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        对数组执行操作使平方和最大 t=new 对数组执行操作使平方和最大();
    }
}
