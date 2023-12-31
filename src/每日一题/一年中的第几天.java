package 每日一题;

import java.util.Calendar;

public class 一年中的第几天 {
    public int dayOfYear(String date) {
        Calendar c=Calendar.getInstance();
        c.set(Integer.parseInt(date.substring(0,4)),Integer.parseInt(date.substring(5,7))-1,Integer.parseInt(date.substring(8,10)));
        return c.get(Calendar.DAY_OF_YEAR);
    }
}
