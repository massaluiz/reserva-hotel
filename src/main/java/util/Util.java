package util;

import java.util.Calendar;

public abstract class Util {


    public static Calendar getCalendar(int day, int month, int year) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        //This -1 is because January is 0 position
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        return calendar;
    }
}
