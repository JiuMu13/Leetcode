package 每日一题二;

public class 给植物浇水二 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int r=0;
        int currA=0;
        int currB=0;
        int n= plants.length;
        if (n%2==0){
            for (int i = 0; i < n/2; i++) {
                if (plants[i]<=capacityA-currA){
                    currA+=plants[i];
                }else {
                    r++;
                    currA=plants[i];
                }
                if (plants[n-i-1]<=capacityB-currB){
                    currB+=plants[n-i-1];
                }else {
                    r++;
                    currB=plants[n-i-1];
                }
            }
        }else {
            for (int i = 0; i < n/2; i++) {
                if (plants[i]<=capacityA-currA){
                    currA+=plants[i];
                }else {
                    r++;
                    currA=plants[i];
                }
                if (plants[n-i-1]<=capacityB-currB){
                    currB+=plants[n-i-1];
                }else {
                    r++;
                    currB=plants[n-i-1];
                }
            }
            if (plants[n/2]>Math.max(capacityA-currA,capacityB-currB)){
                r++;
            }
        }
        return r;
    }
}
