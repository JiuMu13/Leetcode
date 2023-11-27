package 第368场周赛;

import java.util.Stack;

public class 元素和最小的山形三元组一二 {
    public int minimumSum(int[] nums) {
        int n=nums.length;
        int[] suf=new int[n+1];
        suf[n]=Integer.MAX_VALUE;
        for (int i=n-1;i>=0;i--){
            suf[i]=Math.min(nums[i],suf[i+1]);
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(nums[0]);
        int result=Integer.MAX_VALUE;
        for (int i=1;i<n-1;i++){
            if (stack.peek()<nums[i]){
                if (nums[i]>suf[i+1]){
                    int t=nums[i]+stack.peek()+suf[i+1];
                    if (t<result)
                        result=t;
                }
            }else {
                stack.pop();
                stack.push(nums[i]);
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }

    public static void main(String[] args) {
        元素和最小的山形三元组一二 t=new 元素和最小的山形三元组一二();
        int[] s={8,6,1,5,3};
        System.out.println(t.minimumSum(s));
    }
}
