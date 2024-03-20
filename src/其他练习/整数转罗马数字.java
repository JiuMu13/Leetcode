package 其他练习;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class 整数转罗马数字 {
    public String intToRoman(int num) {
        int[] y={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        Map<Integer,String> map=new HashMap<>();
        map.put(1000,"M");
        map.put(900,"CM");
        map.put(500,"D");
        map.put(400,"CD");
        map.put(100,"C");
        map.put(90,"XC");
        map.put(50,"L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(9,"IX");
        map.put(5,"V");
        map.put(4,"IV");
        map.put(1,"I");

        StringBuilder sb=new StringBuilder();
        while (num>0){
            for (int e : y){
                if (num/e>0){
                    sb.append(map.get(e));
                    num-=e;
                    break;
                }
            }
        }
        return sb.toString();
    }
}
