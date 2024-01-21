package 其他练习;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        //特判：当所给字符串为空时，直接返回空数组
        if (digits.length()==0)
            return new ArrayList<>();
        //用0-7八个List存储2-9与字母的映射关系
        List<Character>[] lists=new List[8];
        for (int i=0;i<8;i++)
            lists[i]=new ArrayList<>();
        int t='a';
        for (int i=0;i<6;i++){
            lists[i].add((char)(t++));
            lists[i].add((char)(t++));
            lists[i].add((char)(t++));
        }
        lists[5].add('s');
        t++;
        for (int i=6;i<8;i++){
            lists[i].add((char)(t++));
            lists[i].add((char)(t++));
            lists[i].add((char)(t++));
        }
        lists[7].add('z');

        //递归处理
        List<StringBuilder> r = dg(digits,lists);
        List<String> rs=new ArrayList<>();
        //翻转字符串，并添加到结果集合
        for (StringBuilder e : r) {
            rs.add(e.reverse().toString());
        }
        return rs;
    }


    private List<StringBuilder> dg(String s,List<Character>[] lists){
        if (s.length()==1) {
            int listIndex=s.charAt(0)-'0'-2;
            List<StringBuilder> r=new ArrayList<>();
            for (int i=0;i<lists[listIndex].size();i++) {
                r.add( new StringBuilder().append(lists[listIndex].get(i)) );
            }
            return r;
        }
        List<StringBuilder> r=new ArrayList<>();
        int listIndex=s.charAt(0)-'0'-2;
        for (int i=0;i<lists[listIndex].size();i++){
            List<StringBuilder> dg = dg(s.substring(1), lists);
            for (int j=0;j<dg.size();j++){
                dg.set(j,dg.get(j).append(lists[listIndex].get(i)));
            }
            r.addAll(dg);
        }
        return r;
    }

    public static void main(String[] args) {
        电话号码的字母组合 t=new 电话号码的字母组合();
        System.out.println(t.letterCombinations("23"));
    }
}
