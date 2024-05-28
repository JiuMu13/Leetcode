package 每日一题二;

public class 找出可整除性得分最大的整数 {
    public int maxDivScore(int[] nums, int[] divisors) {
        int r=0;
        int n=Integer.MAX_VALUE;
        for (int divisor : divisors) {
            int t = 0;
            for (int num : nums) {
                if (num % divisor == 0)
                    t++;
            }
            if (t > r) {
                n = divisor;
                r = t;
            } else if (t == r && n > divisor) {
                n = divisor;
            }
        }
        return n;
    }
}
