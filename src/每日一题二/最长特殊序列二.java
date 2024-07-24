package 每日一题二;

import java.util.*;

public class 最长特殊序列二 {

    public static void main(String[] args) {
        System.out.println(new 最长特殊序列二().findLUSlength(new String[]{"a","b","c","d","e","f","a","b","c","d","e"}));
    }
    public int findLUSlength(String[] strs) {
        int r=-1;
        for (int i=0;i<strs.length;i++){
            boolean f=true;
            for (int j=0;j<strs.length;j++){
                if (i==j)
                    continue;
                if (compare(strs[j],strs[i])){
                    f=false;
                    break;
                }
            }
            if (f)
                r=Math.max(r,strs[i].length());
        }
        return r;
    }
    private boolean compare(String p,String c){
        char[] cp=p.toCharArray(),cc=c.toCharArray();
        int lp=0,lc=0;
        while (lp<cp.length && lc<cc.length){
            if (cp[lp]==cc[lc]){
                lp++;
                lc++;
            }else {
                lp++;
            }
        }
        return lc==cc.length;
    }
}
