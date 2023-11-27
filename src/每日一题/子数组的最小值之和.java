package 每日一题;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class 子数组的最小值之和 {
    public int sumSubarrayMins(int[] arr) {
        int  n=arr.length;
        int[] weight=new int[n];
//        Stack<Integer> stack=new Stack<>();
        //使用栈时推荐使用Deque,因为Stack是线程安全的，在效率上要比Deque慢很多
        Deque<Integer> stack=new ArrayDeque<>();
        for (int i=0;i<n;i++){
            while (!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            if (!stack.isEmpty())
                weight[i]=i-stack.peek();
            else
                weight[i]=i+1;
            stack.push(i);
            System.out.println(weight[i]);
        }
        stack.clear();
        /*
        可利用一次循环完成
        将右边界的判定放在第一个循环的while中
        while (st.size() > 1 && arr[st.peek()] >= arr[i])
            right[st.pop()] = i; // i 恰好是栈顶的右边界
         */
        for (int i=n-1;i>=0;i--){
            while (!stack.isEmpty() && arr[i]<arr[stack.peek()]){
                stack.pop();
            }
            if (!stack.isEmpty())
                weight[i]*=stack.peek()-i;
            else
                weight[i]*=n-i;
            stack.push(i);
        }
        long result=0;
        int mod=(int)1e9+7;
        for (int i=0;i<n;i++){
            result+=(long)weight[i]*arr[i];
            result=result%mod;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        子数组的最小值之和 t=new 子数组的最小值之和();
        int[] s={71,55,82,55};
        System.out.println(t.sumSubarrayMins(s));
    }
}
