package Work1.Day09;

/**
 * ********概述：
 */
public class Example8_7 {
    public static void main(String[] args) {
        byte[] d = "Java你好".getBytes();
        System.out.println("数组d的长度是:" + d.length);
        String hao = new String(d, 6, 2);
        System.out.println(hao);
        String javaNi = new String(d, 0, 8);
        System.out.println(javaNi);
        String highByte = Integer.toBinaryString(d[7]);
        highByte = highByte.substring(highByte.length() - 8);
        String lowByte = Integer.toBinaryString(d[6]);
        lowByte = lowByte.substring(lowByte.length() - 8);
        System.out.println(hao + "的编码:");
        System.out.println(highByte + " " + lowByte);
    }
}
