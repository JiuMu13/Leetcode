package 每日一题;

public class 种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i=0;i<flowerbed.length && n>0;i++){
            if (i==0 ){
                if (flowerbed.length==1)
                    if (flowerbed[0]==0)
                        return n==1;
                    else
                        return n==0;
                if (flowerbed[0]==0 && flowerbed[1]==0) {
                    n--;
                    flowerbed[i] = 1;
                }
            }else if(i==flowerbed.length-1 ){
                if(flowerbed[i-1]==0 && flowerbed[i]==0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }else if (flowerbed[i-1]==0 && flowerbed[i]==0 && flowerbed[i+1]==0){
                flowerbed[i]=1;
                n--;
            }
        }
        return n==0;
    }
}
