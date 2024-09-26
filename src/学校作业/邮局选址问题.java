package 学校作业;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 邮局选址问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x=new int[n];
        int[] y=new int[n];
        long sumx=0,sumy=0;
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            sumx+=x[i];
            y[i] = sc.nextInt();
            sumy+=y[i];
        }
        Arrays.sort(x);
        Arrays.sort(y);
        long cx=0;
        for (int i = -10000; i <= 10000; i++) {

        }
    }
}
