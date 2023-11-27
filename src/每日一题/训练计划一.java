package 每日一题;

import java.util.Arrays;

public class 训练计划一 {
    public int[] trainingPlan(int[] actions) {
        int[] result=new int[actions.length];
        int f=0;
        int[] o=new int[actions.length];
        int f2=0;
        for (int i=0;i<actions.length;i++)
            if (actions[i]%2!=0)  result[f++]=actions[i];
            else  o[f2++]=actions[i];
        System.arraycopy(o,0,result,f,f2);
        return result;
    }
}
