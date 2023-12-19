package 每日一题;

public class 寻找峰值二 {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length,m=mat[0].length;
        int u=0,d=n-1,maxIndex=0;
        while (u<d){
            int mid=(u+d)>>1;
            maxIndex=0;
            for (int i=1;i<m;i++){
                if (mat[mid][maxIndex]<mat[mid][i])
                    maxIndex=i;
            }
            if (mat[mid][maxIndex]>mat[mid+1][maxIndex]){
                d=mid;
            }else {
                u=mid+1;
            }
        }
        maxIndex=0;
        for (int i=1;i<m;i++){
            if (mat[u][maxIndex]<mat[u][i])
                maxIndex=i;
        }
        return new int[]{u,maxIndex};
    }

    public static void main(String[] args) {
        寻找峰值二 t=new 寻找峰值二();
        int[][] s={{7,2,3,1,2},{6,5,4,2,1}};
        System.out.println(t.findPeakGrid(s)[0]);
    }
}
