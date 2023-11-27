package 每日一题;

import java.util.Arrays;
import java.util.Comparator;

public class 做菜顺序 {
    public int maxSatisfaction(int[] satisfaction) {
        int n=satisfaction.length;
        int sum=0;
        Arrays.sort(satisfaction);
        int result=0;
        for (int i=n-1;i>=0;i--){
            if (result+sum+satisfaction[i]>result) {
                sum+=satisfaction[i];
                result += sum ;
            }
            else
                return result;
        }
        return result;
    }
}
