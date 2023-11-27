package 每日一题;

public class H指数二 {
    public int hIndex(int[] citations) {
        int n=citations.length-1;
        int l=0,r=n;
        while (l<r){
            int mid=(l+r)/2;
            if(n-mid+1<=citations[mid]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return citations[l]>n-l+1?n-l+1:citations[l];
    }

    public static void main(String[] args) {
        H指数二 t=new H指数二();
        int[] s={0,1,3,5,6};
        System.out.println(t.hIndex(s));
    }
}
