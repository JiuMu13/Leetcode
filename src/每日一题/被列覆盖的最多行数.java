package 每日一题;

public class 被列覆盖的最多行数 {
    public int maximumRows(int[][] matrix, int numSelect) {
        int row=matrix.length;
        int col=matrix[0].length;

        int[] nums=new int[row];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                nums[i]+=matrix[i][j]<<j;
            }
        }
        int r=0;
        for (int i=0;i<(1<<col);i++){
            if (count(i)>numSelect)
                continue;
            int c=0;
            int t=i^((1<<col)-1);
            for (int j=0;j<row;j++){
                if ((nums[j]&t)==0){
                    c++;
                }
            }
            r=Math.max(r,c);
        }
        return r;
    }
    private int count(int n){
        int r=0;
        while (n!=0){
            if ((n&1)==1)
                r++;
            n>>=1;
        }
        return r;
    }
}
