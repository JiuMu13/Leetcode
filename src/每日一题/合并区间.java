package 每日一题;

import java.util.Arrays;
import java.util.Comparator;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        int j=0;
        int[][] s=new int[intervals.length][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
//        for (int i=0;i<intervals.length;i++){
//            int min=i;
//            for (int h=i+1;h<intervals.length;h++){
//                if (intervals[h][0]<intervals[min][0])
//                    min=h;
//            }
//            if (min!=i){
//                int[] temp=intervals[i];
//                intervals[i]=intervals[min];
//                intervals[min]=temp;
//            }
//        }
        int l=intervals[0][0];
        int r=intervals[0][1];
        for (int i=0;i<intervals.length;i++){
            if (intervals[i][0]<=r){
                if (intervals[i][1]>r)
                    r=intervals[i][1];
            }else{
                s[j][0]=l;
                s[j++][1]=r;
                l=intervals[i][0];
                r=intervals[i][1];
            }
        }
        s[j][0]=l;
        s[j][1]=r;
        int[][] ss=new int[j+1][2];
        for (int i=0;i<=j;i++){
            ss[i][0]=s[i][0];
            ss[i][1]=s[i][1];
        }
        return ss;
    }

    public static void main(String[] args) {
        int[][] s={{1,4},{0,4}};
        合并区间 t=new 合并区间();
        int[][] ss=t.merge(s);
        for (int i=0;i<ss.length;i++){
            System.out.println(ss[i][0]+"  "+ss[i][1]);
        }
    }
}
