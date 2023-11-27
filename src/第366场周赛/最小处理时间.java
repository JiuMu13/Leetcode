package 第366场周赛;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//AC
public class 最小处理时间 {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        processorTime.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t1-t2;
            }
        });
        tasks.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2-t1;
            }
        });
        int result=-1;
        for (int i=0,j=0;i<tasks.size();i++){
            if (processorTime.get(j)+tasks.get(i)>result)
                result=processorTime.get(j)+tasks.get(i);
            if ((i+1)%4==0)
                j++;
        }
        return result;
    }
}
