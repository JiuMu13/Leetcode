package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class HTML实体解析器 {
    public String entityParser(String text) {
        char[] cs=text.toCharArray();
        int[] f=new int[cs.length];
        int t=-1;
        for (int i=cs.length-1;i>=0;i--){
            if (cs[i]==';'){
                t=i;
            }
            f[i]=t;
        }
        StringBuilder sb=new StringBuilder();
        Map<String,String> map=new HashMap<>();
        map.put("&quot;","\"");
        map.put("&apos;","'");
        map.put("&amp;","&");
        map.put("&gt;",">");
        map.put("&lt;","<");
        map.put("&frasl;","/");
        int con=0;
        for (int i=0;i<cs.length;i++){
            if (cs[i]=='&'){
                if (f[i]!=-1){
                    String s=text.substring(i,f[i]+1);
                    if (map.containsKey(s)){
                        String ss=map.get(s);
                        i=f[i];
                        sb.append(ss);
                    }else {
                        sb.append(cs[i]);
                    }
                }else {
                    sb.append(cs[i]);
                }
            }else {
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HTML实体解析器 t=new HTML实体解析器();
        t.entityParser("&amp; is an HTML entity but &ambassador; is not.");
    }
}
