package 每日一题二;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 给植物浇水 {
    public int wateringPlants(int[] plants, int capacity) {
        int r=0;
        int step=0;
        int curr=0;
        for (int plant : plants) {
            step++;
            if (plant<=capacity-curr){
                curr+=plant;
                r++;
            }else {
                curr=plant;
                r+=2*step-1;
            }
        }
        return r;
    }
}
