package 每日一题;

public class 找出叠涂元素 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n=arr.length;
        int[] f=new int[n+1];
        for (int i=1;i<=n;i++){
            f[arr[i-1]]=i-1;
        }
        int row=mat.length;
        int collum=mat[0].length;
        int r=n+1;
        for (int i=0;i<row;i++){
            int t=0;
            for (int j=0;j<collum;j++){
                if (f[mat[i][j]]>t)
                    t=f[mat[i][j]];
            }
            if (r>t)
                r=t;
        }
        for (int i=0;i<collum;i++){
            int t=0;
            for (int j=0;j<row;j++){
                if (f[mat[j][i]]>t)
                    t=f[mat[j][i]];
            }
            if (r>t)
                r=t;
        }
        return r;
    }

    public static void main(String[] args) {
        找出叠涂元素 t=new 找出叠涂元素();
        int[] s={1,3,4,2};
        int[][] ss={{1,4},{2,3}};
        System.out.println(t.firstCompleteIndex(s,ss));
    }
}
