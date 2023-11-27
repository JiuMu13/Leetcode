package 每日一题;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 餐厅过滤器 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list=new ArrayList<>();
        for (int i=0;i<restaurants.length;i++){
            if (restaurants[i][2]>=veganFriendly && restaurants[i][3]<=maxPrice && restaurants[i][4]<=maxDistance){
                list.add(new int[]{restaurants[i][0],restaurants[i][1]});
            }
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if (t1[1]!=t2[1])
                    return t2[1]-t1[1];
                return t2[0]-t1[0];
            }
        });
        List<Integer> result=new ArrayList<>();
        for (int[] e:list) {
            result.add(e[0]);
        }
        return result;
    }
}
