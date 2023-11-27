package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class 统计出现过一次的公共字符串 {
    public int countWords(String[] words1, String[] words2) {
        Map<String,Integer> map=new HashMap<>();
        int result=0;
        for (String s:words1){
            if (!map.containsKey(s))
                map.put(s,1);
            else
                map.put(s,map.get(s)+1);
        }
        Map<String,Integer> map2=new HashMap<>();
        for (String s:words2){
            if (!map2.containsKey(s))
                map2.put(s,1);
            else
                map2.put(s,map2.get(s)+1);
        }
        for (String s:words2){
            if (map.containsKey(s) && map.get(s)==1 && map2.get(s)==1)
                result++;
        }
        return result;
    }
}
