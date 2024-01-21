package 每日一题;

public class 构造有效字符串的最少插入数 {
    public int addMinimum(String word) {
        char[] cs = word.toCharArray();
        char last='c';
        int sum=0;
        for (char e:cs){
            if (e=='a'){
                if (last=='a'){
                    sum+=2;
                }else if (last=='b'){
                    sum++;
                }
            }else if (e=='b'){
                if (last=='a'){
                }else if (last=='b'){
                    sum+=2;
                }else {
                    sum++;
                }
            }else {
                if (last=='a'){
                    sum++;
                }else if (last=='b'){
                }else {
                    sum+=2;
                }
            }
            last=e;
        }
        if (last=='a'){
            sum+=2;
        }else if (last=='b'){
            sum++;
        }
        return sum;
    }
}
