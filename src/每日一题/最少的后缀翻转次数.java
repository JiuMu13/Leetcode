package 每日一题;

public class 最少的后缀翻转次数 {
    public static int minFlips(String target) {
//        int sum=0,fn=1;
//        char f='0';
//        for (int i=0;i<target.length();i++){
//            if (f!=target.charAt(i)){
//                sum++;
//                f=(char)((int)f+fn);
//                fn=-fn;
//            }
//        }
        int sum=0;
        target="0"+target;
        for (int i=1;i<target.length();i++){
            if (target.charAt(i)!=target.charAt(i-1))
                sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s="10111";
        System.out.println(minFlips(s));
    }
}
