package 每日一题;

import java.util.Arrays;
import java.util.Comparator;

public class 全部开花的最早一天 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        class flower{
            int pt;
            int gt;
            public flower(int pt, int gt) {
                this.pt = pt;
                this.gt = gt;
            }
//            @Override
//            public String toString() {
//                return "flower{" +
//                        "pt=" + pt +
//                        ", gt=" + gt +
//                        '}';
//            }
        }
        flower[] f=new flower[plantTime.length];
        for (int i = 0; i <plantTime.length ; i++) {
            f[i]=new flower(plantTime[i],growTime[i]+1);
        }
        Arrays.sort(f, new Comparator<flower>() {
            @Override
            public int compare(flower f1, flower f2) {
                return f2.gt-f1.gt;
            }
        });
//        System.out.println( Arrays.toString(f));
        int spt=0,sgt=0;
        for (int i = 0; i <plantTime.length; i++) {
            spt+=f[i].pt;
            sgt=sgt-f[i].pt>0?Math.max(sgt-f[i].pt,f[i].gt):f[i].gt;
        }
        return sgt+spt-1;
    }

    public static void main(String[] args) {
        全部开花的最早一天 t=new 全部开花的最早一天();
        int[] pt=new int[]{1,4,3};
        int[] gt=new int[]{2,3,1};
        System.out.println(t.earliestFullBloom(pt,gt));
    }
}
