package 每日一题;

import java.util.Arrays;

public class 切割后面积最大的蛋糕 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        int hmax=horizontalCuts[0];
        for (int i=1;i<horizontalCuts.length;i++){
            int t=horizontalCuts[i]-horizontalCuts[i-1];
            if (t>hmax)
                hmax=t;
        }
        if (h-horizontalCuts[horizontalCuts.length-1]>hmax)
            hmax=h-horizontalCuts[horizontalCuts.length-1];
        Arrays.sort(verticalCuts);
        int wmax=verticalCuts[0];
        for (int i=1;i<verticalCuts.length;i++){
            int t=verticalCuts[i]-verticalCuts[i-1];
            if (t>wmax)
                wmax=t;
        }
        if (w-verticalCuts[verticalCuts.length-1]>wmax)
            wmax=w-verticalCuts[verticalCuts.length-1];
        int mod=(int) 1e9+7;
        return (int)((long)hmax*wmax%mod);
    }

    public static void main(String[] args) {
        切割后面积最大的蛋糕 t=new 切割后面积最大的蛋糕();
        int[] s1={2};
        int[] s2={2};
        System.out.println(t.maxArea(1000000000,1000000000,s1,s2));
    }
}
