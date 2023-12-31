package 第378场周赛;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 找出出现至少三次的最长特殊子字符串一二 {
    public int maximumLength(String s) {
        int n=s.length();
        char[] cs=s.toCharArray();
        List<Integer>[] l=new List[26];
        for (int i=0;i<26;i++)
            l[i]=new ArrayList<>();
        int f=0;
        while (f<n){
            int t=cs[f];
            int begin=f;
            while (f<n && cs[f]==t){
                f++;
            }
            l[t-'a'].add(f-begin);
        }
        int max=-1;
        for (int i=0;i<26;i++){
            if (l[i].size()==0)
                continue;
            Collections.sort(l[i],(o1,o2)->o2-o1);
            if (l[i].get(0)==2){
                if (l[i].size()>=3 && l[i].get(2)==2){
                    max=Math.max(max,2);
                }else if (l[i].size()==2)
                    max=Math.max(max,1);
                continue;
            }
            if (l[i].get(0)==1 ) {
                if (l[i].size()>=3)
                    max = Math.max(max, 1);
                continue;
            }
            if (l[i].size()==1){
                max = Math.max(max, l[i].get(0)-2);
                continue;
            }else if (l[i].size()==2){
                if (l[i].get(1)>=l[i].get(0)-1)
                    max = Math.max(max, l[i].get(0)-1);
                else
                    max = Math.max(max, l[i].get(0)-2);
                continue;
            }else {
                if (l[i].get(0)==l[i].get(2))
                    max = Math.max(max, l[i].get(0));
                else if (l[i].get(1)>=l[i].get(0)-1)
                    max = Math.max(max, l[i].get(0)-1);
                else
                    max = Math.max(max, l[i].get(0)-2);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        找出出现至少三次的最长特殊子字符串一二 t=new 找出出现至少三次的最长特殊子字符串一二();
        String s="hhmmjjlinhmkllmhlmnlikllkjeeehmnliihjkljlhmilmnkkn";
        System.out.println(t.maximumLength(s));
    }
}
