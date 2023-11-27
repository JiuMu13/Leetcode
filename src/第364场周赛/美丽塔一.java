package 第364场周赛;

import java.util.ArrayList;
import java.util.List;

public class 美丽塔一 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long result=-1;
        long max;
        List<Integer> T=new ArrayList<>();
        T.addAll(maxHeights);
         for (int i=0;i<maxHeights.size();i++){
             max=0;
             maxHeights.clear();
             maxHeights.addAll(T);
             for (int l=i-1;l>=0;l--){
                 if (maxHeights.get(l)>maxHeights.get(l+1)){
                     maxHeights.set(l,maxHeights.get(l+1));
                 }
                 max+=maxHeights.get(l);
             }

             for (int r=i+1;r<maxHeights.size();r++){
                 if (maxHeights.get(r)>maxHeights.get(r-1)){
                     maxHeights.set(r,maxHeights.get(r-1));
                 }
                 max+=maxHeights.get(r);
             }
             max+=maxHeights.get(i);
             result=Math.max(max,result);
         }
         return result;
    }

    public static void main(String[] args) {
        美丽塔一 t=new 美丽塔一();
        List<Integer> list=new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(3);
        list.add(9);
        list.add(2);
        list.add(7);
        System.out.println(t.maximumSumOfHeights(list));
    }
}
