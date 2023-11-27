package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数 {
    public int romanToInt(String s) {
        int sum=0;
        char[] ss=s.toCharArray();
        Map<String,Integer> map=new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        for (int i=0;i<ss.length;i++){
            if (ss[i]=='I'){
                if (i+1<ss.length && ss[i+1]=='V'){
                    sum+=4;
                    i++;
                }else if (i+1<ss.length && ss[i+1]=='X'){
                    sum+=9;
                    i++;
                }else {
                    sum+=1;
                }
            }else if(ss[i]=='X'){
                if (i+1<ss.length && ss[i+1]=='L'){
                    sum+=40;
                    i++;
                }else if (i+1<ss.length && ss[i+1]=='C'){
                    sum+=90;
                    i++;
                }else {
                    sum+=10;
                }
            }else if(ss[i]=='C'){
                if (i+1<ss.length && ss[i+1]=='D'){
                    sum+=400;
                    i++;
                }else if (i+1<ss.length && ss[i+1]=='M'){
                    sum+=900;
                    i++;
                }else {
                    sum+=100;
                }
            }else {
                sum+=map.get(""+ss[i]);
            }
        }
        return sum;
    }
}
