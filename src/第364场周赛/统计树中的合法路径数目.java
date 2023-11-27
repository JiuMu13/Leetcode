package 第364场周赛;

import java.util.LinkedList;
import java.util.Stack;

public class 统计树中的合法路径数目 {
    public long countPaths(int n, int[][] edges) {
        return -1;
    }
    public static void main(String[] args) {
        统计树中的合法路径数目 t=new 统计树中的合法路径数目();
//        int[][] s=new int[][]{{10,9},{2,10},{1,10},{3,2},{6,10},{4,3},{8,6},{5,8},{7,6}};
//        System.out.println(t.countPaths(10,s));
//        int[][] s=new int[][]{{1,2},{1,3},{2,4},{2,5}};
//        System.out.println(t.countPaths(5,s));
        int[][] s=new int[][]{{7,4},{3,4},{5,4},{1,5},{6,4},{9,5},{8,7},{2,8}};
        System.out.println(t.countPaths(9,s));
    }
}
