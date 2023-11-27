package 每日一题;

public class 最大单词长度乘积 {
    public int maxProduct(String[] words) {
        int[] sn=new int[words.length];
        for (int i=0;i<words.length;i++){
            for (int j=0;j<words[i].length();j++){
                int t=words[i].charAt(j)-'a';
                sn[i]=sn[i]|(1<<t);
            }
        }
        int result=0;
        for (int i=0;i<sn.length;i++){
            for (int j=i+1;j<sn.length;j++){
                if (sn[i]+sn[j]==(sn[i]|sn[j])){
                    if (result<words[i].length()*words[j].length())
                        result=words[i].length()*words[j].length();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        最大单词长度乘积 t=new 最大单词长度乘积();
        String[] ss={"abcw","d"};
        System.out.println(t.maxProduct(ss));
    }
}
