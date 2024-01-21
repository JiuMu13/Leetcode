package 每日一题;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 构造限制重复的字符串 {
    public String repeatLimitedString(String s, int repeatLimit) {
        char[] cs=s.toCharArray();
        int[] map=new int[26];
        for (char c : cs) {
            map[c-'a']++;
        }
        int rt=25;
        StringBuilder r=new StringBuilder();

        a:for (int i=25;i>=0;i--){
            int count=0;
            while (map[i]>0){
                if (count==repeatLimit){
                    int j=i-1;
                    while (j>=0 && map[j]<=0){
                        j--;
                    }
                    if (j<0)
                        break a;
                    else {
                        map[j]--;
                        r.append((char)('a' + j));
                        count=0;
                    }
                }
                map[i]--;
                r.append((char)('a'+i));
                count++;
            }
        }
        return r.toString();
    }
}
