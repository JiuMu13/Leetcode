package 每日一题;

public class 执行操作后的变量值 {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for (String s:operations) {
            if (s.equals("++X") || s.equals("X++"))
                x++;
            else
                x--;
        }
        return x;
    }
}
