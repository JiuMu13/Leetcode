package 每日一题二;

import java.util.Stack;

public class 清除数字 {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c>='0' && c<='9')
                stack.pop();
            else
                stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
