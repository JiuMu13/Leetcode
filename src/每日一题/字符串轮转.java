package 每日一题;

public class 字符串轮转 {
    public boolean isFlipedString(String s1, String s2) {
        int[] next=new int[s2.length()];
        char[] cs1=(s1+s1.substring(0,s1.length()-1)).toCharArray();
        char[] cs2=s2.toCharArray();
        next[0]=-1;
        for (int i=1,j=-1;i<cs2.length;i++){
            while (j!=-1 && cs2[i]!=cs2[j+1])
                j=next[j];
            if (cs2[i]==cs2[j+1])
                j++;
            next[i]=j;
        }
        for (int i=0,j=-1;i<cs1.length;i++){
            while (j!=-1 && cs1[i]!=cs2[j+1])
                j=next[j];
            if (cs1[i]==cs2[j+1])
                j++;
            if (j==cs2.length-1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        字符串轮转 t=new 字符串轮转();
        System.out.println(t.isFlipedString("waterbottle","erbottlewat"));
    }
}
