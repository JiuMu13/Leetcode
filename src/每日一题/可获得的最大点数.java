package 每日一题;

import java.util.Map;

public class 可获得的最大点数 {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int[] suf=new int[n+2];
        int[] pre=new int[n+2];
        for (int i=0;i<n;i++){
            pre[i+1]=pre[i]+cardPoints[i];
            suf[n-i]=suf[n-i+1]+cardPoints[n-i-1];
        }
        int max=0;
        for (int i=0;i<=k;i++){
            max= Math.max(pre[i]+suf[n-(k-i)+1],max);
        }
        return max;
    }
}
