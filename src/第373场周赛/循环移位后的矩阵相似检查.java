package 第373场周赛;

public class 循环移位后的矩阵相似检查 {
    public boolean areSimilar(int[][] mat, int k) {
        int row=mat.length;
        int column=mat[0].length;
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                if (i%2==1){
                    if (mat[i][j]!=mat[i][(j+k)%column]){
                        return false;
                    }
                }else {
                    if (mat[i][j]!=mat[i][(column+j-k%column)%column]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
