package 其他练习.未分类;

import java.util.ArrayList;
import java.util.List;

public class N皇后 {
    //表示棋盘边长
    int n;

    //存放一行的所有可能状态
    String[] t;

    //相当于一个二维数组，存放结果
    //一个List<String>存放一张棋盘,则List<List<String>>存放所有可能的棋盘
    List<List<String>> result=new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //n表示棋盘大小为n*n
        this.n=n;
        //根据题目分析知：每行只能有一个皇后，且一行的长度为n，
        //所以一行中可能有n个情况
        //建立String类型数组存储这n种情况
        //例："Q...",".Q..","..Q.","...Q"
        t=new String[n];// t[0]="Q...";
        for (int i=0;i<n;i++){
            //使用StringBuilder处理字符串的追加操作   效率高,线程不安全
            StringBuilder sb=new StringBuilder();
            //通过该循环能够构建出一个表示一行状态的字符串
            for (int j=0;j<n;j++){
                if (i==j){
                    sb.append("Q");
                }else
                    sb.append(".");
            }
            t[i]=sb.toString();
        }
        //创建状态数组status，status[n]表示第n行中皇后在第status[n]列上
        //例：status[0]=1    表示当前状态下第0行中皇后在第一列，".Q.."
        int[] status=new int[n];
        //从第0行开始执行递归函数
        dg(0,status);
        return result;
    }


    /**
     * 递归函数
     *         每执行一次，处理currRow行的所有情况
     * @param currRow
     * @param status
     */
    private void dg(int currRow,int[] status){
        //终止条件：当判断到第n-1行时，
        // 整个棋盘已经被判断完了，不需要继续向下递归了
        if (currRow==n-1){
            //遍历一行的n种情况
            for (int i=0;i<n;i++){
                //判断当前行的第i列能否放置皇后棋子
                if (check(currRow,i,status)){
                    //若能放置，修改状态数组（此处也可不修改，因为下面不需要继续判断了）
                    status[currRow]=i;
                    //将这个结果存入result中
                    result.add(print(status));
                }
            }
            return;
        }

        //因为每行有n种情况，所以要通过for循环来遍历这n种情况
        for (int i=0;i<n;i++){
            //判断当前行的第i列能否放置皇后棋子
            if (check(currRow,i,status)){
                //若能放置，修改状态数组
                status[currRow]=i;
                //将更新后的状态传入递归函数，递归进行判断下一行
                dg(currRow+1,status);
            }
        }
    }

    /**
     * 在前currRow行的状态已经确定的情况下
     *         判断第currRow行第column列能否放置一个皇后棋子
     * @param currRow
     * @param column
     * @param status
     * @return
     */
    private boolean check(int currRow,int column,int[] status){
        //检查列
        for (int i=0;i<currRow;i++){
            if (status[i]==column)
                return false;
        }
        //检查左侧对角线
        for (int i=currRow-1,j=column-1;i>=0 && j>=0;i--,j--){
            if (status[i]==j)
                return false;
        }
        //检查右侧对角线
        for (int i=currRow-1,j=column+1;i>=0 && j<n;i--,j++){
            if (status[i]==j)
                return false;
        }
        return true;
    }

    /**
     * 根据状态数组的值，打印出棋盘状态
     *         例：status[0]=1,status[1]=3,status[2]=0,status[3]=2
     *         返回的List集合为{".Q..","...Q","Q...","..Q."}
     * @param status
     * @return
     */
    private List<String> print(int[] status){
        List<String> r=new ArrayList<>();
        for (int i=0;i<n;i++){
            r.add(t[status[i]]);
        }
        return r;
    }

    public static void main(String[] args) {
        N皇后 t=new N皇后();
        System.out.println(t.solveNQueens(4));
    }
}
