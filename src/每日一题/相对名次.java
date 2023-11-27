package 每日一题;

import java.util.Arrays;
import java.util.Comparator;

public class 相对名次 {
    public String[] findRelativeRanks(int[] score) {
        Integer[] ls=new Integer[score.length];
        for (int i=0;i<score.length;i++){
            ls[i]=score[i];
        }
        Arrays.sort(ls, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1-integer;
            }
        });
        String[] result=new String[score.length];
        for (int i=0;i<score.length;i++){
            String t;
            int n=bisection(score[i],ls);
            if (n==0)
                t="Gold Medal";
            else if (n==1)
                t="Silver Medal";
            else if(n==2)
                t="Bronze Medal";
            else
                t=""+(n+1);
            result[i]=t;
        }
        return result;
    }
    private int bisection(int n,Integer[] ls){
        int l=0,r=ls.length-1;
        while (l<r){
            int mid=(l+r+1)/2;
            if (n>ls[mid])
                r=mid-1;
            else
                l=mid;
        }
        return l;
    }

    public static void main(String[] args) {
        相对名次 t=new 相对名次();
        System.out.println(t.findRelativeRanks(new int[]{5,4,3,2,1}));
    }
}
