package 每日一题二;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 好子数组的最大分数 {
    public int maximumScore(int[] nums, int k) {
        Deque<Integer> stack=new ArrayDeque<>();
        int n=nums.length;
        int[] l=new int[n];
        int[] r=new int[n];
        Arrays.fill(r,n);
        for (int i=0;i<n;i++){
            while (!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                int f=stack.pop();
                r[f]=i;//比nums[f]小的右边第一个数
            }
            if (stack.isEmpty()){
                l[i]=-1;
            }else {
                l[i]=stack.peek();//比nums[f]小的左边第一个数
            }
            stack.push(i);
        }
        int result=0;
        for (int i=0;i<n;i++){
            if(l[i]+1<=k && r[i]-1>=k){
                int f=nums[i]*(r[i]-l[i]-1);
                if (result<f)
                    result=f;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new 好子数组的最大分数().maximumScore(new int[]{1,4,3,7,4,5},3));
    }
}
