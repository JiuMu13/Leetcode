package 第364场周赛;

public class 最大二进制奇数 {
    public String maximumOddBinaryNumber(String s) {
        char[] cs=s.toCharArray();
        int f1=-1,f0=0;
        for (int i=0;i<cs.length;i++){
            if (cs[i]=='0'){
                f0++;
            }else
                f1++;
        }
        char[] result=new char[cs.length];
        for (int i=0;i<cs.length-1;i++){
            if (f1 > 0) {
                f1--;
                result[i]='1';
                continue;
            }
            result[i]='0';
        }
        result[cs.length-1]='1';
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        最大二进制奇数 t=new 最大二进制奇数();
        String s=t.maximumOddBinaryNumber("010");
        System.out.println(s);

    }
}
