package 第377场周赛;

import java.util.*;

public class 移除栅栏得到的正方形田地的最大面积 {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        long s=-1;
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        Set<Integer> k=new HashSet<>();
        for (int i=-1;i< vFences.length;i++){
            int startw;
            if (i==-1)
                startw=1;
            else startw=vFences[i];
            for (int j=i+1;j<=vFences.length;j++){
                int endw;
                if (j==vFences.length)
                    endw=n;
                else
                    endw=vFences[j];
                int h=endw-startw;
                k.add(h);
            }
        }
        for (int i=-1;i< hFences.length;i++){
            int starth;
            if (i==-1)
                starth=1;
            else starth=hFences[i];
            if (m-starth<=s)
                break;
            for (int j=i+1;j<=hFences.length;j++){
                int endh;
                if (j==hFences.length)
                    endh=m;
                else
                    endh=hFences[j];
                int h=endh-starth;
                if (h<=s)
                    continue;
                if (k.contains(h)){
                    s=Math.max(s,h);
                    continue;
                }
            }
        }
        if (s==-1)
            return -1;
        long mod=(long)1e9+7;
        return (int)(s*s%mod);
    }

    public static void main(String[] args) {
        移除栅栏得到的正方形田地的最大面积 t=new 移除栅栏得到的正方形田地的最大面积();
        System.out.println(t.maximizeSquareArea(6,7,new int[]{2},new int[]{4}));
    }
}
