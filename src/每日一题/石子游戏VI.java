package 每日一题;

import java.util.Arrays;

public class 石子游戏VI {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n=aliceValues.length;
        int[][] both=new int[n][2];//0为值。1为索引
        for (int i=0;i<n;i++){
            both[i][0]=aliceValues[i]+bobValues[i];
            both[i][1]=i;
        }
        Arrays.sort(both,(o1,o2)-> o2[0]-o1[0]);
        int curr=0;
        boolean f=false;
        for (int i=0;i<n;i++){
            if (!f){
                curr+=aliceValues[both[i][1]];
            }else {
                curr-=bobValues[both[i][1]];
            }
            f=!f;
        }
        if (curr==0)
            return 0;
        if (curr>0)
            return 1;
        return -1;
    }

}
