package 每日一题;

import java.util.ArrayList;
import java.util.List;

//二元一次方程求解
public class 不浪费原料的汉堡制作方案 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int t1=tomatoSlices-2*cheeseSlices;
        if (t1<0)
            return new ArrayList<>();
        if (t1%2!=0)
            return new ArrayList<>();
        int b=t1/2;
        int s=cheeseSlices-b;
        if (s<0)
            return new ArrayList<>();
        List<Integer> r=new ArrayList<>();
        r.add(b);
        r.add(s);
        return r;
    }
}
