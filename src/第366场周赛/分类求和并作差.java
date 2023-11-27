package 第366场周赛;
//AC
public class 分类求和并作差 {
    public int differenceOfSums(int n, int m) {
        int summ=0,j;
        for (j=m;j<=n;j+=m){
            summ+=j;
        }
        return (1+n)*n/2-summ*2;
    }

    public static void main(String[] args) {
        分类求和并作差 t=new 分类求和并作差();
        System.out.println(t.differenceOfSums(10,3));
    }
}
