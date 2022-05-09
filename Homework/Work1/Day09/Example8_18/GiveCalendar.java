package Work1.Day09.Example8_18;

import java.time.LocalDate;

/**
 * ********概述：
 */
public class GiveCalendar {
    public LocalDate[] getCalendar(LocalDate date) {
        date = date.withDayOfMonth(1);
        int days = date.lengthOfMonth();
        LocalDate dataArrays[] = new LocalDate[days];
        for (int i = 0; i < days; i++) {
            dataArrays[i] = date.plusDays(i);
        }
        return dataArrays;
    }
}
