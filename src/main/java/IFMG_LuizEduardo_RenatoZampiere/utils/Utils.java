package IFMG_LuizEduardo_RenatoZampiere.utils;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import IFMG_LuizEduardo_RenatoZampiere.utils.DatePeriod;

public class Utils {

    public static int[] getCalendar(){
        int[] calendar = new int[12];
        calendar[0] = 31;
        calendar[1] = LocalDate.now().isLeapYear() ? 29 : 28;
        calendar[2] = 31;
        calendar[3] = 30;
        calendar[4] = 31;
        calendar[5] = 30;
        calendar[6] = 31;
        calendar[7] = 31;
        calendar[8] = 30;
        calendar[9] = 31;
        calendar[10] = 30;
        calendar[11] = 31;

        return calendar;
    }


}
