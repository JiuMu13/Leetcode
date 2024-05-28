package 每日一题二;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 修改后的最大二进制字符串 {
    public String maximumBinaryString(String binary) {
        char[] chars = binary.toCharArray();
        //找到第一个0的位置
        int i=0;
        for (char c:chars){
            if (c=='0')
                break;
            else
                i++;
        }
        int count0=0;
        for (int j=i;j<chars.length;j++){
            if (chars[j]=='0')
                count0++;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(chars).substring(0, i));
        for (int j=0;j<count0-1;j++){
            sb.append('1');
        }
        if (count0>0)
            sb.append('0');
        for (int j=0;j<chars.length-i-count0;j++){
            sb.append('1');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new 修改后的最大二进制字符串().maximumBinaryString("01111001100000110010"));
    }
}
