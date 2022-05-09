package Work1.Day09;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * ********概述：
 */
public class Example8_16 {
    public static void main(String[] args) {
        LocalDate dateOne = LocalDate.now();
        System.out.println("本地日期:" + dateOne);
        LocalDate dateTwo = LocalDate.of(2025, 1, 22);
        System.out.println("自定日期:" + dateTwo);
        System.out.println(dateOne + "在" + dateTwo + "之后:" + dateOne.isAfter(dateTwo));
        System.out.println(dateOne + "在" + dateTwo + "之前:" + dateOne.isBefore(dateTwo));
        System.out.println(dateOne + "在" + dateTwo + "相同:" + dateOne.isEqual(dateTwo));
        int year = 18, month = 23, day = 8976;
        LocalDate dateAgo = dateOne.plusYears(-year);
        System.out.println(dateOne + " " + year + "年前是:\n" +dateAgo);
        System.out.println("那天是" + dateAgo.getDayOfWeek());
        LocalDate dateAfter = dateTwo.plusYears(year).plusMonths(month).plusDays(day);
        System.out.println(dateTwo + "再过"+ year +"年" + month +"个月" + day + "天之后是:");
        System.out.println(dateAfter);
        System.out.println("那天是"+ dateAfter.getDayOfWeek());
        int second = 1897;
        LocalTime time = LocalTime.of(23, 30, 1);
        LocalTime nextTime = time.plusSeconds(second);
        System.out.println( time+"再过"+second+"秒是" +nextTime);


    }
}
