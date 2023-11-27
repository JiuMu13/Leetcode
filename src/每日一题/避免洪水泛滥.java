package 每日一题;

import java.util.*;

public class 避免洪水泛滥 {
    public int[] avoidFlood(int[] rains) {
        int n=rains.length;
        int[] result=new int[n];
        Arrays.fill(result,-1);
        Map<Integer,Integer> m=new HashMap<>(n);
        List<Integer> chou=new ArrayList<>(n);
        for (int i=0;i<n;i++){
            if (rains[i]==0){
                chou.add(i);
            }else {
                if (!m.containsKey(rains[i])) {
                    m.put(rains[i], i);
                } else {
                    if (chou.size() > 0 ) {
                        int d=0;
                        while (d<chou.size() && chou.get(d)<m.get(rains[i])){d++;}
                        if (d<chou.size()) {
                            result[chou.remove(d)] = rains[i];
                            m.put(rains[i],i);
                        }
                        else return new int[0];
                    } else
                        return new int[0];
                }
            }
        }
        for (int i=0;i<chou.size();i++)
            result[chou.get(i)]=1;
        return result;
    }

    public static void main(String[] args) {
        避免洪水泛滥 t=new 避免洪水泛滥();
        int[] s={1,2,3,4};
    }


}
