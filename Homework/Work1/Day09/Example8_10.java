package Work1.Day09;

/**
 * ********概述：
 */
public class Example8_10 {
    public static void main(String[] args) {
        String str = "培训学校的E-mail:qinghua@sina.com.cn或zhang@163.com";
        String regex = "\\w + @\\w +\\.[a-z]+(\\.[a-z]+)?";
        System.out.println("清楚\n" + str + "\n中的E-mail地址");
        str = str.replaceAll(regex,"");
        System.out.println(str);
        String money = "89,235,678￥";
        System.out.println(money + "转换成数字:");
        String s = money.replaceAll("[,\\p{Sc}]","");
        long number = Long.parseLong(s);
        System.out.println(number);
    }
}
