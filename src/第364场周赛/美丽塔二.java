package 第364场周赛;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
做法：
维护两个单调栈，建立前缀和数组，和后缀和数组。遍历找出最大值
时间复杂度：O（nlogn）
 */
public class 美丽塔二 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long[] pre=new long[maxHeights.size()];//前缀和数组,pre[i]表示第i位及其前面的所有元素和
        long[] suf=new long[maxHeights.size()];//后缀和数组
        Stack<Integer> stack=new Stack<>(); //创建一个栈，将其维护成为单调栈；存储的元素为下标值
        //从左到i补充前缀和数组
        for (int i=0;i<maxHeights.size();i++){
            long f=maxHeights.get(i);
            while (!stack.empty() && f<=maxHeights.get(stack.peek())) {
                stack.pop();
            }
            if (!stack.empty() )
                pre[i]=pre[stack.peek()]+(i-stack.peek())*f;
            else
                pre[i]=f*(i+1);
            stack.push(i);
        }
        stack=new Stack<>();
        for (int i=maxHeights.size()-1;i>=0;i--){
            long f=maxHeights.get(i);
            while (!stack.empty() && f<=maxHeights.get(stack.peek())) {
                stack.pop();
            }
            if (!stack.empty() )
                suf[i]=suf[stack.peek()]+(stack.peek()-i)*f;
            else
                suf[i]=f*(maxHeights.size()-i);
            stack.push(i);
        }
        long max=0;
        for (int i=0;i<maxHeights.size();i++){
            max=Math.max(max,pre[i]+suf[i]-maxHeights.get(i));
        }
        return max;
    }
    public static void main(String[] args) {
        美丽塔二 t=new 美丽塔二();
        List<Integer> list=new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(3);
        list.add(9);
        list.add(2);
        list.add(7);
        System.out.println(t.maximumSumOfHeights(list));
    }
}
