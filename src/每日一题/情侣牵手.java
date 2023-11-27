package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class 情侣牵手 {
    public int minSwapsCouples(int[] row) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<row.length;i++){
            map.put(row[i],i);
        }
        int result=0;
        for(int i=0;i<row.length;i+=2){
            if ( Math.abs(row[i]-row[i+1])==1 && (row[i]+row[i+1])%4==1){
                continue;
            }else {
                int f;
                if (row[i]%2==0){
                    f=map.get(row[i]+1);
                }else {
                    f=map.get(row[i]-1);
                }
                int t=row[f];
                row[f]=row[i+1];
//                row[i+1]=t;
                map.put(row[f],f);
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        情侣牵手 t=new 情侣牵手();
        int[] n={0,2,4,6,7,1,3,5};
        System.out.println(t.minSwapsCouples(n));
    }
}
