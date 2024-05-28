package 每日一题二;

import java.util.*;

public class 爱生气的书店老板 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n=customers.length;
        int[] q=new int[n+1];
        int left=0,right=0;
        int sum=0;
        int result=0;
        for (int i=0;i<n;i++) {
            int t=grumpy[i]*customers[i];
            q[right++]=t;
            sum+=t;
            if (right-left==minutes){
                result=Math.max(result,sum);
                sum-=q[left++];
            }
        }
        for (int i=0;i<n;i++) {
            if (grumpy[i]==0)
                result+=customers[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new 爱生气的书店老板().maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3));
    }
}
