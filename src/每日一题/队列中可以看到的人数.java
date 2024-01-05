package 每日一题;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
//从右向左构建单调栈
public class 队列中可以看到的人数 {
    public int[] canSeePersonsCount(int[] heights) {
        int n=heights.length;
        Deque<Integer> stack=new ArrayDeque<>();
        int[] result=new int[n];
        for (int i=n-1;i>=0;i--){
            int count=0;
            while (!stack.isEmpty() && stack.peek()<heights[i]){
                stack.pop();
                count++;
            }
//            System.out.println(i+":  "+stack.size()+"  count:"+count);
            result[i]=count+(stack.isEmpty()?0:1);
            stack.push(heights[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        队列中可以看到的人数 t=new 队列中可以看到的人数();
        int[] s={10,6,8,5,11,9};
        System.out.println(Arrays.toString(t.canSeePersonsCount(s)));
    }
}
