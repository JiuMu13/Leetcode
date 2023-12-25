package 每日一题;

public class 收集足够苹果的最小花园周长 {
    public long minimumPerimeter(long neededApples) {
        long i=1;
        while (i*i*(4*i+6)+2*i <neededApples)
            i++;
        return i*8;
    }

    public static void main(String[] args) {
        收集足够苹果的最小花园周长 t=new 收集足够苹果的最小花园周长();
        System.out.println(t.minimumPerimeter(1000000000));
    }
}
