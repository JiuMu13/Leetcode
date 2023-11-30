package 其他练习;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
对于任意小写/大写英文字母字符，其 ASCII 码的二进制都形如 01xxxxxx；
对于任意数字字符，其 ASCII 码的二进制都形如 0011xxxx
 */
public class 字母与数字 {
    public String[] findLongestSubarray(String[] array) {
        int n=array.length;
        int[] f=new int[n];//字母为1，数字为-1
        for (int i=0;i<n;i++){
            f[i]=(array[i].charAt(0)>>6 & 1)*2-1;
        }
        int[] suf=new int[n+1];
        for (int i=1;i<=n;i++){
            suf[i]=suf[i-1]+f[i-1];
        }
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        int resultl=0;
        int resultr=0;
        for (int i=1;i<=n;i++){
            if (map.containsKey(suf[i])){
                if (i-map.get(suf[i])>resultr-resultl){
                    resultl=map.get(suf[i]);
                    resultr=i;
                }
            }else {
                map.put(suf[i],i);
            }
        }
        return Arrays.copyOfRange(array,resultl,resultr);
    }

    public static void main(String[] args) {
        字母与数字 t=new 字母与数字();
        String[] ss={"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        System.out.println(Arrays.toString(t.findLongestSubarray(ss)));
    }
}
