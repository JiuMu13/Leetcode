package 第373场周赛;

import java.util.*;
//排序+分组循环
//        Integer[] ids = new Integer[n];
//        for (int i = 0; i < n; i++) {
//        ids[i] = i;
//        }
//        Arrays.sort(ids, (i, j) -> nums[i] - nums[j]);
public class 交换得到字典序最小的数组 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] t = Arrays.copyOf(nums, nums.length);
        Arrays.sort(t);
        Map<Integer, Integer> ls = new HashMap<>();
        Map<Integer, List<Integer>> location = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (location.containsKey(nums[i])) {
                location.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                location.put(nums[i], list);
            }
        }
        for (int i = 0; i < t.length; i++) {
            ls.put(t[i], i);
        }
        int[] result = new int[nums.length];
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < t.length; ) {
            int begin = i;
            for (int e : location.get(t[i])) {
                l.add(e);
                i++;
            }
            while (i < t.length && t[i] - t[i - 1] <= limit) {
                for (int e : location.get(t[i])) {
                    l.add(e);
                    i++;
                }
            }
            Collections.sort(l);
            for (int e : l) {
                result[e] = t[begin++];
            }
            l.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        交换得到字典序最小的数组 t = new 交换得到字典序最小的数组();
        int[] s = {1, 7, 6, 18, 2, 1};
        System.out.println(Arrays.toString(t.lexicographicallySmallestArray(s, 2)));
    }
}
