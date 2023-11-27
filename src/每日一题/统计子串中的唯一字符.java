package 每日一题;

import java.util.HashMap;
import java.util.Map;
//其他方法：分别计算每个字符的贡献
public class 统计子串中的唯一字符 {
    public int uniqueLetterString(String s) {
        int result=0;
        char[] cs=s.toCharArray();
        int n=s.length();
        int[][] f=new int[n][2];//0为个数，1为第二个相同字符位置
        for (int i=0;i<n;i++){
            f[i][1]=-1;
        }
        //此处使用到hashmap的思想
//        Map<Character,Integer> map=new HashMap<>();
        int[] arr=new int[26];
        for (int i=0;i<26;i++)
            arr[i]=-1;
        f[n-1][0]=1;
        arr[cs[n-1]-'A']=n-1;
        result+=1;
        for (int i=n-2;i>=0;i--){
            if (arr[cs[i]-'A']!=-1){
                int t=arr[cs[i]-'A'];
                arr[cs[i]-'A']=i;
                result+=f[i+1][0];
                result+=1+(t-(i+1))-(n-1-t+1);
                if (f[t][1]!=-1){
                    result+=n-1-f[t][1]+1;
                    f[i][0]+=n-1-f[t][1]+1;
                }
                f[i][0]+=f[i+1][0]+1+(t-(i+1))-(n-1-t+1);
                f[i][1]=t;
            }else {
                arr[cs[i]-'A']=i;
                f[i][0]=f[i+1][0]+(n-1)-i+1;
                result+=f[i][0];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        统计子串中的唯一字符 t=new 统计子串中的唯一字符();
        System.out.println(t.uniqueLetterString("LEETCODE"));
    }
}
