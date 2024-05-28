package 每日一题二;

import java.util.Arrays;

public class 完成所有任务的最少时间 {
    public static int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks,((o1, o2) -> o1[1]-o2[1]));
        int n=tasks[tasks.length-1][1]+1;
        int[] pre=new int[n];
        boolean[] f=new boolean[n];
        for (int[] task : tasks) {
            int star=task[0],end=task[1],time=task[2];
            int t=time-(pre[end]-pre[star-1]);
            if (t>0){
                for (int i=end+1;i<n;i++){
                    pre[i]+=t;
                }
                for (int i=end; t>0 && i>=star;i--){
                    if (!f[i]){
                        pre[i]+=t;
                        f[i]=true;
                        t--;
                    }else {
                        pre[i]+=t;
                    }
                }
            }
        }
        return pre[n-1];
    }

    public static void main(String[] args) {
        int[][] s=new int[][]{{13,19,4},{8,19,5},{3,19,9}};
        System.out.println(findMinimumTime(s));
    }
}
