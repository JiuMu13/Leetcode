package 其他练习.未分类;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 迷宫 {
    public static void main(String[] args) {
        int[][] g = new int[32][52];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 30; i++) {
            String t = sc.next();
            char[] cs = t.toCharArray();
            for (int j = 0; j < 50; j++) {
                g[i + 1][j + 1] = cs[j] - '0';
            }
        }
        for (int i = 0; i < g.length; i++) {
            g[i][0] = 1;
            g[i][51] = 1;
        }
        for (int i = 0; i < g[0].length; i++) {
            g[0][i] = 1;
            g[31][i] = 1;
        }
        class Node {
            int x;
            int y;
            Node pre;

            public Node(int x, int y, Node n) {
                this.x = x;
                this.y = y;
                pre = n;
            }
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(1, 1, null));
        while (!queue.isEmpty()) {
            Node t = queue.remove();
            int x = t.x, y = t.y;
            g[x][y] = 1;
            if (x == 30 && y == 50) {
                StringBuilder sb = new StringBuilder();
                Node tt = t;
                while (tt.pre != null) {
                    if (tt.pre.x + 1 == tt.x && tt.pre.y == tt.y) {
                        sb.append("D");
                    }
                    if (tt.pre.x - 1 == tt.x && tt.pre.y == tt.y) {
                        sb.append("U");
                    }
                    if (tt.pre.x == tt.x && tt.pre.y == tt.y + 1) {
                        sb.append("L");
                    }
                    if (tt.pre.x == tt.x && tt.pre.y == tt.y - 1) {
                        sb.append("R");
                    }
                    tt=tt.pre;
                }
                System.out.println(sb.reverse().toString());
                break;
            }
            //下
            if (g[x + 1][y] == 0) {
                queue.add(new Node(x + 1, y, t));
            }
            //左
            if (g[x][y - 1] == 0) {
                queue.add(new Node(x, y - 1, t));
            }
            //右
            if (g[x][y + 1] == 0) {
                queue.add(new Node(x, y + 1, t));
            }
            //上
            if (g[x - 1][y] == 0) {
                queue.add(new Node(x - 1, y, t));
            }
        }
    }

}
