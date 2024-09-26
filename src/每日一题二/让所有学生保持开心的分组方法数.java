package 每日一题二;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序，枚举
 */
public class 让所有学生保持开心的分组方法数 {
    public static int countWays(List<Integer> nums) {
        nums.sort(Integer::compareTo);
        int c = 1;
        int same = 0;
        int sur = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i != nums.size() - 1 && nums.get(i) == nums.get(i + 1)) {
                same++;
                continue;
            }
            if (sur <= 0 && i - same < nums.get(i))
                c++;
            sur = nums.get(i) - i;
            same = 0;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(countWays(Arrays.asList(0, 0, 1, 7, 2, 0, 6, 5)));
    }
}
