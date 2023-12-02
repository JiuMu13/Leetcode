package 每日一题;

import java.util.Arrays;
import java.util.Comparator;
//o(n)写法：差分数组
public class 拼车 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[][] tripTo= Arrays.copyOf(trips,trips.length);
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        Arrays.sort(tripTo, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int currCap=0;
        int f=0,t=0,n=trips.length;
        while (f<n && t<n){
            if (trips[f][1]<tripTo[t][2]){
                currCap+=trips[f++][0];
            }else if (trips[f][1] > tripTo[t][2]){
                currCap -= tripTo[t++][0];
            }else {
                currCap += trips[f++][0];
                currCap -= tripTo[t++][0];
            }
            if (currCap>capacity){
                return false;
            }
        }
        while (f<n){
            currCap+=trips[f++][0];
            if (currCap>capacity){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        拼车 t=new 拼车();
        int[][] ss={{2,1,5},{3,5,7}};
        System.out.println(t.carPooling(ss,3));
    }
}
