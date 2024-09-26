package 每日一题二;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class 坐上公交的最晚时间 {
    /* 原始方法，先安排所有乘客，再从最后一个上车的开始往前找位置 */
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int pi=0;
        for (int i = 0; i <buses.length; i++) {
            int c=capacity;
            while (pi<passengers.length && passengers[pi]<=buses[i]){
                if (c>0){
                    c--;
                    pi++;
                }else {
                    break;
                }
            }
            if (i==buses.length-1){
                if (pi==0)
                    return buses[buses.length-1];
                if (c>0 && passengers[pi-1]!=buses[buses.length-1])
                    return buses[buses.length-1];
            }
        }
        int r=passengers[pi-1]-1;
        for (int i=pi-2;i>=0;){
            if (r>passengers[i]){
                return r;
            } else if (r == passengers[i]) {
                r--;
                i--;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        坐上公交的最晚时间 a = new 坐上公交的最晚时间();
        System.out.println(a.latestTimeCatchTheBus(new int[]{3},new int[]{4},1));
    }
}
