package 每日一题;

import java.util.Scanner;

public class 判断一个数的数字计数是否等于数位的值 {
    public static boolean digitCount(String num) {
        int[] numf=new int[10];
        for (int i=0;i<num.length();i++)
        {
            numf[i]=num.charAt(i)-'0';
        }
        for(int i=0;i<num.length();i++)
        {
            numf[num.charAt(i)-'0']--;
        }
        for (int i=0;i<numf.length;i++)
        {
            if (numf[i]!=0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String num=sc.next();
        System.out.println(digitCount(num));
    }
}
