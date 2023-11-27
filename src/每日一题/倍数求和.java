package 每日一题;

public class 倍数求和 {
    public static int sumOfMultiples(int n) {
        int n3=n/3;
        int n5=n/5;
        int n7=n/7;
        int n15=n/15;
        int n21=n/21;
        int n35=n/35;
        int n105=n/105;
        return (1+n3)*n3/2*3+(1+n5)*n5/2*5+(1+n7)*n7/2*7-(1+n15)*n15/2*15-(1+n35)*n35/2*35-(1+n21)*n21/2*21+(1+n105)*n105/2*105;
    }

    public static void main(String[] args) {
        System.out.println(sumOfMultiples(9));
    }
}
