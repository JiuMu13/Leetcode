package 每日一题;

import java.util.Map;

public class 最长平衡子字符串 {
    public int findTheLongestBalancedSubstring(String s) {
        char[] cs=s.toCharArray();
        int r=0;
        for(int i=0;i<cs.length;){
            int t='0';
            int count0=0;
            int count1=0;
            while(i<cs.length && cs[i]==t ){
                i++;
                count0++;
            }
            t='1';
            while(i<cs.length && cs[i]==t ){
                i++;
                count1++;
            }
            r=Math.max(r,2* Math.min(count0,count1));
        }
        return r;
    }
}
