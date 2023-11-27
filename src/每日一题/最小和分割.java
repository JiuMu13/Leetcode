package 每日一题;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class 最小和分割 {
    public int splitNum(int num) {
        List<Integer> list=new LinkedList<>();
        while (num!=0){
            list.add(num%10);
            num/=10;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer-t1;
            }
        });
        int i=0;
        while ( i<list.size()  &&  list.get(i++)==0);
        int r1=list.remove(i-1),r2=list.remove(0);
        while (!list.isEmpty()){
            if (r1<r2) {
                r1 *= 10;
                r1 += list.remove(0);
            }
            else {
                r2*=10;
                r2+=list.remove(0);
            }
        }
        return r1+r2;
    }

    public static void main(String[] args) {
        最小和分割 t=new 最小和分割();
        System.out.println(t.splitNum(100));
    }
}
