package Work1.Day09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ********概述：
 */
public class Example8_14 {
    public static void main(String[] args) {
        String dataSource = "市话76.8元，长途167.38元，短信12.68元";
        String regex = "-?[1-9][0-9]*[.][0-9]*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(dataSource);
        double sum = 0;
        while (m.find()) {
            String item = m.group();
            System.out.println(item);
            sum += Double.parseDouble(item);
        }
        System.out.println("账单总价格" + sum);
    }
}
