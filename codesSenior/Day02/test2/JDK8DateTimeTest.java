package Day02.test2;

import org.junit.jupiter.api.Test;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * ********概述：
 */
public class JDK8DateTimeTest {
    @Test
    public void testDate(){
        //偏移量
        Date date1=new Date(2022-1900,9-1,8);
        System.out.println(date1);
    }

    /*
    LocalDate、LocalTime、LocalDateTime的使用
    类似于calendar
     */
    @Test
    public void test1(){
        //now（）：获取当前日期、时间、日期+时间
        //LocalDateTime使用更频繁
        LocalDate localDate=LocalDate.now();
        LocalTime localTime=LocalTime.now();
        LocalDateTime localDateTime=LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of()设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1=LocalDateTime.of(2020,12,2,12,34,45);
        System.out.println(localDateTime1);

        //getXxx():获取相关属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());

        //设置相关属性：修改与String类似，体现不可变性
        LocalDate localDate1=localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(19);
        System.out.println(localDateTime2);

        //对相关属性的添加及减少
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime3);
        LocalDateTime localDateTime4 = localDateTime.minusDays(8);
        System.out.println(localDateTime4);
    }

    /*
    Instant的使用
     */
    @Test
    public void test2(){
        //now():获取本初子午线对应的标准时间
        Instant instant=Instant.now();
        System.out.println(instant);//本初子午线时间

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));//时区偏移量
        System.out.println(offsetDateTime);

        //时间戳：获取从1970年1月1日0时0分0秒(UTC)开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //通过给定的毫秒数求出日期
        Instant instant1 = Instant.ofEpochMilli(1649070087938l);
        System.out.println(instant1);
    }

    /*
    DateTimeFormatter:格式化或解析日期、时间  类似于SimpleDateFormat
     */

    @Test
    public void test3(){
        //方式一：预定义的标准格式
        DateTimeFormatter formatter=DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化
        LocalDateTime localDateTime=LocalDateTime.now();
        String str1=formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        //解析
        TemporalAccessor parse = formatter.parse(str1);//接口方式实现
        System.out.println(parse);

        //方式二：本地化相关的格式
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //short middle long  格式上不同
        //格式化
        String str2 = formatter1.format(localDateTime);//本地化方式一
        System.out.println(str2);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //full short middle full
        String format = formatter2.format(LocalDate.now());
        System.out.println(format);

        //方式三：自定义的格式
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //解析
        String format1 = formatter3.format(LocalDateTime.now());

        System.out.println(format1);
        TemporalAccessor parse1 = formatter3.parse(format1);
        System.out.println(parse1);
    }
}
