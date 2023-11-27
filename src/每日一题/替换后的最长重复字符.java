package 每日一题;

import java.util.*;

public class 替换后的最长重复字符 {
    class MaxMap{
        HashMap<Character,Integer> map;
        char maxKey;
        public MaxMap() {
            map=new HashMap<>();
            for (int i = 0; i < 26 ; i++) {
                map.put((char)('A'+i),0);
            }
            maxKey='A';
        }
        public void add(char x){
            map.put(x,map.get(x)+1);
            if (map.get(maxKey)<map.get(x)) {
                maxKey = x;
            }
        }
        public int getMax(){
            return map.get(maxKey);
        }
        public void delete(char x){
            map.put(x,map.get(x)-1);
            if (x==maxKey) {
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > map.get(maxKey))
                        maxKey = entry.getKey();
                }
            }
        }
    }
    public int characterReplacement(String s, int k) {
        MaxMap maxMap=new MaxMap();
        char[] cs=s.toCharArray();
        int r=-1;
        int result=0;
        for (int l=0;l<cs.length;l++){
            while ( r-l+1 - maxMap.getMax()<=k && r<cs.length-1){
                //右指针可以后移
                maxMap.add(cs[++r]);
            }
            if (r==cs.length-1){
                if (r-l+1 - maxMap.getMax()<=k)
                    result=Math.max(result,r-l+1);
                else
                    result=Math.max(result,r-l);
                break;
            }
            result=Math.max(result,r-l);
            maxMap.delete(cs[l]);
        }
        return result;
    }

    public static void main(String[] args) {
        替换后的最长重复字符 t = new 替换后的最长重复字符();
        String s = "ABBB";
        System.out.println(t.characterReplacement(s, 2));
    }

}
