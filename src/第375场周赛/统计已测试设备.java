package 第375场周赛;

public class 统计已测试设备 {
    public int countTestedDevices(int[] batteryPercentages) {
        int n=batteryPercentages.length;
        int[] cf=new int[n];
        cf[0]=batteryPercentages[0];
        for (int i=1;i<n;i++){
            cf[i]=batteryPercentages[i]-batteryPercentages[i-1];
        }
        int r=0;
        int curr=0;
        for (int i=0;i<n;i++){
            curr+=cf[i];
            if (curr>0) {
                r++;
                curr--;
            }
        }
        return r;
    }
}
