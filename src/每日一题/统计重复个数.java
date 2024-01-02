package 每日一题;

public class 统计重复个数 {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            int len1=s1.length();
            int len2=s2.length();
            char[] cs1=s1.toCharArray();
            char[] cs2=s2.toCharArray();
            int m=0;
            for (int i=0,f1=0,f2=0,j=0;i<n1;){
                if (cs1[f1]==cs2[f2]){
                    f2++;
                }
                if (f2==len2){
                    j++;
                    if (j==n2){
                        m++;
                        j=0;
                    }
                    f2=0;
                }
                if (++f1==len1){
                    f1=0;
                    i++;
                }
            }
            return m;
        }

    public static void main(String[] args) {
        统计重复个数 t=new 统计重复个数();
        System.out.println(t.getMaxRepetitions("acb",4,"ab",2));
    }
}
