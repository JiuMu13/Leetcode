package 每日一题二;

import java.util.Arrays;
import java.util.Collections;

public class 你可以工作的最大周数 {
    public static long numberOfWeeks(int[] milestones) {
        long s = 0;
        int m = 0;
        for (int x : milestones) {
            s += x;
            m = Math.max(m, x);
        }
        return m > s - m + 1 ? (s - m) * 2 + 1 : s;
    }

    public static void main(String[] args) {
        System.out.println(numberOfWeeks(new int[]{9,3,6,8,2,1}));
    }
}
