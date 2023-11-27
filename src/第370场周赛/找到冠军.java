package 第370场周赛;

public class 找到冠军 {
    public int findChampion(int[][] grid) {
        int w=0;
        int n=grid.length;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]!=0){
                    w=i;
                    break;
                }
            }
        }
        int f=0;
        while (f!=-1){
            f=-1;
            for (int i=0;i<n;i++){
                if (grid[i][w]==1){
                    w=i;
                    f=w;
                }
            }
        }
        return w;
    }
}
