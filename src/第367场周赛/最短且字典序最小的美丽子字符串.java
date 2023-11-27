package 第367场周赛;

public class 最短且字典序最小的美丽子字符串 {
    public String shortestBeautifulSubstring(String s, int k) {
        int l=0,r=0;
        char[] cs=s.toCharArray();
        int n=cs.length;
        int count=0;

        while (r<n && count<k)
            if (cs[r++]=='1')
                count++;
        if (count<k)
            return "";
        //l=0,r=下一个指向
        if (count==k)
            while (cs[l]=='0')
                l++;
        int resultR=r-1,resultL=l;
        l++;
        for ( ; r<n ; l++,r++ ){
            if (cs[r]=='1')
                count++;
            if (cs[l-1]=='1')
                count--;
            while (count>k){
                if (cs[l]=='1') {
                    count--;
                    l++;
                }
            }
            if (count==k)
                while (cs[l]=='0')
                    l++;
            if (count==k){
                if ( resultR-resultL>r-l || s.substring(resultL,resultR).compareTo(s.substring(l,r))>0){
                    resultL=l;
                    resultR=r;
                }
            }

        }
        return s.substring(resultL,resultR+1);
    }

    public static void main(String[] args) {
        最短且字典序最小的美丽子字符串 t=new 最短且字典序最小的美丽子字符串();
        System.out.println(t.shortestBeautifulSubstring("100011001",3));
    }
}
