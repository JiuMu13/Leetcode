package 每日一题二;

import java.util.HashMap;
import java.util.Map;

public class 公司命名 {
    public long distinctNames(String[] ideas) {
        int[] size = new int[26]; // 集合大小
        int[][] intersection = new int[26][26]; // 交集大小
        Map<String, Integer> groups = new HashMap<>(); // 后缀 -> 首字母
        for (String s : ideas) {
            int b = s.charAt(0) - 'a';
            size[b]++; // 增加集合大小
            String suffix = s.substring(1);
            int mask = groups.getOrDefault(suffix, 0);
            groups.put(suffix, mask | 1 << b); // 把 b 加到 mask 中
            for (int a = 0; a < 26; a++) { // a 是和 s 有着相同后缀的字符串的首字母
                if ((mask >> a & 1) > 0) { // a 在 mask 中
                    intersection[b][a]++; // 增加交集大小
                    intersection[a][b]++;
                }
            }
        }

        long ans = 0;
        for (int a = 1; a < 26; a++) { // 枚举所有组对
            for (int b = 0; b < a; b++) {
                int m = intersection[a][b];
                ans += (long) (size[a] - m) * (size[b] - m);
            }
        }
        return ans * 2; // 乘 2 放到最后
    }

    public static void main(String[] args) {
        System.out.println(new 公司命名().distinctNames(new String[]{"abbb","iccc","rbbb"}));
    }
}
