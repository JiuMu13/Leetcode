package 每日一题;

class SubrectangleQueries {
    private int[][] s;
    public SubrectangleQueries(int[][] rectangle) {
        s=rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        System.out.println(s.length+"   "+row1+"   "+row2);
        System.out.println(s[0].length+"  "+col1+"   "+col2);
        for (int i = col1; i <=col2 ; i++) {
            for (int j = row1; j <=row2 ; j++) {
                s[i][j]=newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return s[row][col];
    }
}