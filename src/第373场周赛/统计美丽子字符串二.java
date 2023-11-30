package 第373场周赛;

import java.util.*;

public class 统计美丽子字符串二 {
    public int beautifulSubstrings(String s, int k) {
        Set<Character> set =new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int n=s.length();
        int[] sf=new int[n];
        for (int i=0;i<s.length();i++){
            if (set.contains(s.charAt(i))){
                sf[i]=1;
            }else {
                sf[i]=-1;
            }
        }
        int nk=yinshi(4*k);
        int[] pre=new int[n+1];
        pre[0]=n;
        int result=0;
        for (int i=1;i<=n;i++){
            pre[i]=pre[i-1]+sf[i-1];//元音为1，辅音为-1
        }
        Map<Integer,Integer> map=new HashMap<>();//
        map.put((0<<17 | pre[0]),1);
        for (int i=1;i<=n;i++){
            if (map.containsKey( (i)%nk<<17 | pre[i] )){
                int t=map.get((i)%nk<<17 | pre[i]);//将i%nk和pre[i]用一个数来表示
                result+=t;
                map.put((i)%nk<<17 | pre[i],t+1);
            }else {
                map.put((i)%nk<<17 | pre[i],1);
            }
        }
        return result;
    }
    int yinshi(int n){
        int r=1;
        for (int i=2;i<=n/i;i++){
            if (n%i==0){
                int e=0;
                while (n%i==0){
                    n/=i;
                    e++;
                }
                e=(e+1)/2;
                r*=Math.pow(i,e);
            }
        }
        if (n>1)
            r*=n;
        return r;
    }
    public static void main(String[] args) {
        统计美丽子字符串二 t=new 统计美丽子字符串二();
        System.out.println(t.beautifulSubstrings("ihroyeeb",5));
    }
}
