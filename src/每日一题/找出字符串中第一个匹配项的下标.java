package 每日一题;

public class 找出字符串中第一个匹配项的下标 {
    public int strStr(String haystack, String needle) {
        char[] s= haystack.toCharArray();
        char[] p=needle.toCharArray();
        int[] next=new int[p.length];
        //构建next数组
        next[0]=-1;
        for (int i=1,j=-1;i<p.length;i++){
            while (j!=-1 && p[i]!=p[j+1])
                j=next[j];
            if (p[i]==p[j+1])
                j++;
            next[i]=j;
        }
        //kmp查找
        for (int i=0,j=-1;i<s.length;i++){
            while (j!=-1 && s[i]!=p[j+1])
                j=next[j];
            if (s[i]==p[j+1])
                j++;
            if (j==p.length-1)
                return i-j;
        }
        return -1;
    }

    public static void main(String[] args) {
        String zc="bba";
        String mc="aaaaa";
        找出字符串中第一个匹配项的下标 t=new 找出字符串中第一个匹配项的下标();
        System.out.println(t.strStr(mc,zc));
    }
}
