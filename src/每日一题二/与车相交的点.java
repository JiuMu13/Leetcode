package 每日一题二;

import java.util.List;

public class 与车相交的点 {
    /**
     * 排序解法
     * @param nums
     * @return
     */
    public int numberOfPoints1(List<List<Integer>> nums) {
        nums.sort(((o1, o2) -> o1.get(0)-o2.get(0)));
        int curr=0;
        int sum=0;
        for (List<Integer> num : nums) {
            int st=num.get(0);
            int ed=num.get(1);
            if (st<=curr){
                sum+= Math.max(ed - curr, 0);
            }else {
                sum+=ed-st+1;
            }
            curr=Math.max(curr,ed);
        }
        return sum;
    }

    /**
     * 差分数组
     * @param nums
     * @return
     */
    public int numberOfPoints2(List<List<Integer>> nums) {
        int[] pre=new int[101];
        for (List<Integer> num : nums) {
            pre[num.get(0)]++;
            pre[num.get(1)+1]--;
        }
        int t=0;
        int sum=0;
        for (int i : pre) {
            t+=i;
            if (t>0)
                sum++;
        }
        return sum;
    }
}
