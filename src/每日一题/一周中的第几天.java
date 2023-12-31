package 每日一题;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 一周中的第几天 {
    public String dayOfTheWeek(int day, int month, int year) {
        Calendar calendar=Calendar.getInstance();
        calendar.set(year,month-1,day);
        String[] ss={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return ss[calendar.get(Calendar.DAY_OF_WEEK)-1];
    }
//    public String dayOfTheWeek(int day, int month, int year) {
//
//    }
    public static void main(String[] args) {
        一周中的第几天 t=new 一周中的第几天();

        System.out.println( t.dayOfTheWeek(30,12,2023));
    }
}
