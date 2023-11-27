package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 重复的DNA序列 {
    public List<String> findRepeatedDnaSequences(String s) {
        char[] cs=s.toCharArray();
        if (cs.length<=10)
            return new ArrayList<String>();
        Map<Integer,Integer> map=new HashMap<>();
        int p=5;//a=1,g=2,c=3,t=4
        int pt=1;
        int zc=0;
        for (int i=0;i<10;i++){
            int t=0;
            switch (cs[i]){
                case 'A':
                    t=1;
                    break;
                case 'G':
                    t=2;
                    break;
                case 'C':
                    t=3;
                    break;
                case 'T':
                    t=4;
                    break;
            }
            zc=zc*p+t;
            pt*=p;
        }
        map.put(zc,1);
        pt=pt/p;
        Map<Integer,Integer> r=new HashMap<>();
        r.put(zc,9);
        List<Integer> l=new ArrayList<>();
        for (int i=10;i<cs.length;i++){
            zc=zc%pt*p;
            int t=0;
            switch (cs[i]){
                case 'A':
                    t=1;
                    break;
                case 'G':
                    t=2;
                    break;
                case 'C':
                    t=3;
                    break;
                case 'T':
                    t=4;
                    break;
            }
            zc+=t;
            if (map.containsKey(zc)){
                map.put(zc,map.get(zc)+1);
                if (map.get(zc)==2)
                    l.add(r.get(zc));
            }else {
                map.put(zc, 1);
                r.put(zc,i);
            }
        }
        List<String> result=new ArrayList<>();
        for (Integer e:l){
            result.add(s.substring(e-9,e+1));
        }
        return result;
    }

    public static void main(String[] args) {
        重复的DNA序列 t=new 重复的DNA序列();
        System.out.println(t.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
