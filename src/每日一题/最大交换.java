package 每日一题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 最大交换 {
    public int maximumSwap(int num) {

        char[] cs=(""+num).toCharArray();
        List<Integer> l=new ArrayList<>();
        int[] t=new int[cs.length];

        for (int i=0;i<cs.length;i++){
            l.add(cs[i]-'0');
            t[i]=cs[i]-'0';
        }

        Collections.sort(l,(o1,o2)->o2-o1);

        int n=l.size();
        for (int i=0;i<n;i++){
            if(t[i]!=l.get(i)){
                int f=t[i];
                t[i]=l.get(i);
                for (int j=cs.length-1;j>=0;j--){
                    if (t[j]==t[i]){
                        t[j]=f;
                        break;
                    }
                }
                break;
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int e:t)
            sb.append(""+e);
        return Integer.parseInt(sb.toString());
    }
}
