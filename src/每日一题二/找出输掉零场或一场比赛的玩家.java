package 每日一题二;

import java.util.*;

public class 找出输掉零场或一场比赛的玩家 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int[] match : matches) {
            map.merge(match[0],0,(ov,nv) -> ov );
            map.merge(match[1],1, (ov,nv) -> ++ov );
        }
        List<List<Integer>> r=new ArrayList<>();
        r.add(new ArrayList<>());
        r.add(new ArrayList<>());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==0){
                r.get(0).add(entry.getKey());
            } else if (entry.getValue() == 1) {
                r.get(1).add(entry.getKey());
            }
        }
        r.get(0).sort(Comparator.comparingInt(o -> o));
        r.get(1).sort(Comparator.comparingInt(o -> o));
        return r;
    }
}
