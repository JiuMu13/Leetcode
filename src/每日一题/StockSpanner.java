package 每日一题;

import java.util.LinkedList;
import java.util.List;

public class StockSpanner {
    List<Integer> max;
    List<Integer> zz;
    int day;
    public StockSpanner() {
        max=new LinkedList<>();
        zz=new LinkedList<>();
    }

    public int next(int price) {
        day++;
        int result;
        while (!max.isEmpty() && price>=max.get(0)) {
            max.remove(0);
            zz.remove(0);
        }
        if (!max.isEmpty()){
            result=day-zz.get(0);
        }
        else
            result=day;
        max.add(0,price);
        zz.add(0,day);
        return result;
    }
}
