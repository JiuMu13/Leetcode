package 其他练习.未分类;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class 左移右移 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int)st.nval;
        st.nextToken();
        int m = (int)st.nval;
        int[] s=new int[2*m+n+30];
        int currl=m-1;
        int currr=m+n;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i,m-1+i);
            s[m-1+i]=i;
        }
//        System.out.println(Arrays.toString(s));
//        System.out.println(map);
        int c=m;
        while (c>0){
            st.nextToken();
            if (st.sval.equals("L")){
                st.nextToken();
                int tt = (int)st.nval;
                Integer i = map.get(tt);
                s[i]=-1;
                s[currl]=tt;
                map.put(tt,currl--);
            }else {
                st.nextToken();
                int tt = (int)st.nval;
                Integer i = map.get(tt);
                s[i]=-1;
                s[currr]=tt;
                map.put(tt,currr++);
            }
            c--;
        }
        for (int i = currl+1; i <currr ; i++) {
            if (s[i]!=-1){
                System.out.print(s[i]+" ");
            }
        }
    }
}
