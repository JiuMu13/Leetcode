package 每日一题;

public class 最长交替子数组 {
    public static int alternatingSubarray(int[] nums) {
        int t = 0;
        int r = 0;
        int count = 1;
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (t == 0) {
                if (nums[i] - curr == 1) {
                    t = nums[i] - curr;
                    count++;
                    curr = nums[i];
                } else {
                    curr = nums[i];
                    count = 1;
                }
            } else {
                if (nums[i] - curr == t * -1) {
                    t *= -1;
                    count++;
                    curr = nums[i];
                } else {
                    t = 0;
                    count = 1;
                    i--;
                }
            }
            r = Math.max(r, count);
        }
        return r>1?r:-1;
    }

    public static void main(String[] args) {
        System.out.println(alternatingSubarray(new int[]{2,3,4,3,4}));
    }
}
