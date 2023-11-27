package 每日一题;

import java.util.Arrays;
import java.util.Comparator;

public class H指数 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result=0;
        for (int i=citations.length-1,j=1;i>=0;i--,j++){
            if (citations[i]>j){
                //当前h最大为j
                if (j>result)
                    result=j;
            }else{
                //当前h最大为c[i]
                if (citations[i]>result) {
                    result = citations[i];
                    break;
                }
            }
        }
        return result;
    }
}
