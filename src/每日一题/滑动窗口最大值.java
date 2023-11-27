package 每日一题;

import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //双端队列，存储nums数组下标
        Deque<Integer> dq = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
            //如果窗口超出，头指针后移
            if (dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[dq.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] n = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] s;
        滑动窗口最大值 t = new 滑动窗口最大值();
        s = t.maxSlidingWindow(n, k);
        for (int i = 0; i < s.length; i++)
            System.out.println(s[i]);
    }
}
