package 第366场周赛;

import java.util.Map;

public class 执行操作使两个字符串相等 {
    public int minOperations(String s1, String s2, int x) {
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        int[] g=new int[c1.length];
        int count=0;
        for (int i=0;i<c1.length;i++)
            if (c1[i]!=c2[i])
                g[count++]=i*2;
        //以上处理字符串
        if (count%2!=0)
            return -1;
        if(count==0)
            return 0;
        int f0=0,f1=x,oldf;
        for (int i=1;i<count;i++){
            oldf=f1;
            if(i==1)
                f1=Math.min(f1+x,g[i]-g[i-1]);
            else
                f1=Math.min(f1+x,f0+g[i]-g[i-1]);
            f0=oldf;
        }
        return f1/2;
    }
}
