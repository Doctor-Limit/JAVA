package Work1.Day09;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * ********概述：
 */
public class Example8_17 {
    public static void main(String[] args) {
        LocalDateTime dateStart = LocalDateTime.of(1931, 9, 18, 0, 0, 0);
        LocalDateTime dateEnd = LocalDateTime.of(1945, 8, 15, 0, 0, 0);
        long years = dateStart.until(dateEnd, ChronoUnit.YEARS);
        long months = dateStart.until(dateEnd, ChronoUnit.MONTHS);
        long days = dateStart.until(dateEnd, ChronoUnit.DAYS);
        long hours = dateStart.until(dateEnd, ChronoUnit.HOURS);
        long weeks = dateStart.until(dateEnd, ChronoUnit.WEEKS);
        System.out.println(dateStart + "和" + dateEnd + "相差\n(分别按年、月、日、时和星期)");
        System.out.println(years + "年(不足一年的零头按0计算)");
        System.out.println(months + "月(不足一月的零头按0计算)");
        System.out.println(days + "天(不足一天的零头按0计算)");
        System.out.println(hours + "个小时(不足一小时的零头按0计算)");
        System.out.println(weeks + "个星期(不足一星期的零头按0计算)");
        LocalDateTime nextDateStart = dateStart.plusYears(years);
        months = nextDateStart.until(dateEnd, ChronoUnit.MONTHS);
        nextDateStart = nextDateStart.plusMonths(months);
        days = nextDateStart.until(dateEnd, ChronoUnit.DAYS);
        System.out.println(dateStart + "和" + dateEnd + "相差:");
        System.out.println(years + "年、零" +months + "个月、零" + days + "天。");

    }
}
