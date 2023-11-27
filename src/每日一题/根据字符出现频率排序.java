package 每日一题;

import java.util.*;
import java.util.Map.Entry;

public class 根据字符出现频率排序 {
    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap();
        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.get(ch)==null?1:map.get(ch)+1);
        }
        List<Entry<Character,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Entry<Character, Integer>>() {
            @Override
            public int compare(Entry<Character, Integer> c1, Entry<Character, Integer> c2) {
                return c2.getValue()-c1.getValue();
            }
        });
        StringBuilder sf=new StringBuilder();
        for (Entry<Character,Integer> entry:list){
            for (int i=0;i<entry.getValue();i++){
                sf.append(entry.getKey());
            }
        }
        return sf.toString();
    }
    public static void main(String[] args) {
        根据字符出现频率排序 test=new 根据字符出现频率排序();
        System.out.println(test.frequencySort("cccaaa"));
    }
}
