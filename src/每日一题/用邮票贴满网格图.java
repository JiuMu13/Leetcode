package 每日一题;

//二维差分数组
public class 用邮票贴满网格图 {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int row=grid.length,col=grid[0].length;
        //构造二维前缀和数组
        //目的：通过前缀和数组可以在O（1）的时间计算出一个区域内所有元素和，
        // 因为障碍处值为1，通过判断该区域是否为零来判断该区域能否放一个邮票
        int[][] pre=new int[row+1][col+1];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                pre[i+1][j+1]=pre[i][j+1]+pre[i+1][j]-pre[i][j]+grid[i][j];
            }
        }
        //因为邮票可以有重叠，且目的是把邮票覆盖矩阵，所以我们可以贪心地把所有能放邮票的地方都放上
        // 邮票，在O（1）的时间渲染一块区域（将这块区域内所有元素加或减去一个数）可以用二维差分数组实现
        int[][] cf=new int[row+2][col+2];
        for (int i=1;i<=row;i++){
            for (int j=1;j<=col;j++){
                if (i+stampHeight<row+2 && j+stampWidth<col+2 &&
                        pre[i+stampHeight-1][j+stampWidth-1]-pre[i-1][j+stampWidth-1]
                                -pre[i+stampHeight-1][j-1]+pre[i-1][j-1]==0){
                    cf[i+stampHeight][j+stampWidth]++;
                    cf[i+stampHeight][j]--;
                    cf[i][j+stampWidth]--;
                    cf[i][j]++;
                }
            }
        }
        //最后，我们遍历一遍由差分数组累加的原数组，当出现某一位置没有障碍且为零时，说明该位置无法被填上，返回false
        //如果所有位置都被填上，返回true
        int[][] sum=new int[row+2][col+2];
        for (int i=1;i<=row;i++){
            for (int j=1;j<=col;j++){
                sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+cf[i][j];
                if (sum[i][j]==0 && grid[i-1][j-1]==0)
                    return false;
            }
        }
        return true;
    }
}
