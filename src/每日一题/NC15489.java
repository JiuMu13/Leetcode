package 每日一题;

import java.util.Scanner;

public class NC15489 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] s=new String[n+1];
        for (int i=1;i<s.length;i++){
            s[i]=sc.next();
        }
        int cx=sc.nextInt();
        int[][] cxz=new int[cx][2];
        for (int i=0;i<cx;i++){
            cxz[i][0]=sc.nextInt();
            cxz[i][1]=sc.nextInt();
        }
        for (int i=0;i<cx;i++){
            String la=s[cxz[i][0]];
            String fi=s[cxz[i][1]];
            System.out.println(kmp((fi+"*"+la).toCharArray()));
        }
    }
    public static int kmp(char[] s){
        int[] next=new int[s.length];
        next[0]=-1;
        for (int i=1,j=-1;i<s.length;i++){
            while (j!=-1 && s[i]!=s[j+1])
                j=next[j];
            if (s[i]==s[j+1])
                j++;
            next[i]=j;
        }
        return next[s.length-1]+1;
    }
}
