package 第373场周赛;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 统计美丽子字符串一 {
    public int beautifulSubstrings(String s, int k) {
        Set<Character> set =new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        boolean[] sf=new boolean[s.length()];
        for (int i=0;i<s.length();i++){
            if (set.contains(s.charAt(i))){
                sf[i]=true;
            }
        }
        int count0;
        int count1;
        int result=0;
        for (int i=0;i<s.length();i++){
            count0=0;
            count1=0;
            for (int j=i;j<s.length();j++){
                if (sf[j])
                    count1++;
                else
                    count0++;
                if (count0==count1 && (count0*count1)%k==0)
                    result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        统计美丽子字符串一 t=new 统计美丽子字符串一();
        System.out.println(t.beautifulSubstrings("baeyh",2));
    }
}
