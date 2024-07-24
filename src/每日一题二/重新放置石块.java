package 每日一题二;

import java.util.*;

public class 重新放置石块 {

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        List<Integer> r=new ArrayList<>();
        for (Integer i : set) {
            r.add(i);
        }
        r.sort((o1, o2) -> o1-o2);
        return r;
    }

    public static void main(String[] args) {
        new 重新放置石块().relocateMarbles(new int[]{1,6,7,8},new int[]{1,7,2},new int[]{2,9,5});
    }

}
