package 第371场周赛;

import java.util.*;

public class 高访问员工 {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String,List<Integer>> map=new HashMap<>();
        for (List<String> e:access_times){
            if (map.containsKey(e.get(0))){
                map.get(e.get(0)).add(Integer.parseInt(e.get(1)));
            }else {
                List<Integer> l=new ArrayList<>();
                l.add(Integer.parseInt(e.get(1)));
                map.put(e.get(0),l);
            }
        }
        List<String> result=new ArrayList<>();
        for (Map.Entry<String,List<Integer>> e:map.entrySet()){
            List<Integer> l=e.getValue();
            Collections.sort(l);
            for (int i=0;i<l.size();i++){
                int count=0;
                if(i+1<l.size()){
                    int h=l.get(i+1)/100-l.get(i)/100;
                    if (h<=1){
                        int c=l.get(i+1)-l.get(i)-h*40;
                        if (c<60) {
                            count++;
                        }
                    }
                }
                if (i+2<l.size()){
                    int h=l.get(i+2)/100-l.get(i)/100;
                    if (h<=1){
                        int c=l.get(i+2)-l.get(i)-h*40;
                        if (c<60) {
                            count++;
                        }
                    }
                }
                if (count>=2){
                    result.add(e.getKey());
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        高访问员工 t=new 高访问员工();
        List<List<String>> ll=new ArrayList<>();
        List<String> l=new ArrayList<>();
        Collections.addAll(l,"a","1010");
        ll.add(l);
//        l=new ArrayList<>();
//        Collections.addAll(l,"b","0457");
//        ll.add(l);
        l=new ArrayList<>();
        Collections.addAll(l,"a","1105");
        ll.add(l);
        l=new ArrayList<>();
        Collections.addAll(l,"a","1114");
        ll.add(l);
//        l=new ArrayList<>();
//        Collections.addAll(l,"b","0540");
//        ll.add(l);
        t.findHighAccessEmployees(ll);
    }
}
