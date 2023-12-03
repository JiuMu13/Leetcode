package 第374场周赛;

import java.util.ArrayList;
import java.util.List;

public class 找出峰值 {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<mountain.length-1;i++){
            int curr=mountain[i],last=mountain[i-1],next=mountain[i+1];
            if (curr>last && curr>next)
                result.add(i);
        }
        return result;
    }
}
