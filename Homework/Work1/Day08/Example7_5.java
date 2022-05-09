package Work1.Day08;

import java.io.IOException;

/**
 * ********概述：
 */
public class Example7_5 {
    public static void main(String[] args) {
        int n =0, m= 0, t =1000;
        try {
            m = Integer.parseInt("8888");
            n = Integer.parseInt("ab89");
            t = 7777;
        }catch (NumberFormatException e) {
            System.out.println("发生异常" + e.getMessage());
        }
        System.out.println("n=" + n + ",m=" + m + ",t=" + t);
        try{
            System.out.println("故意抛出I/O异常");
            throw new IOException("我是故意的");
        }catch (IOException e) {
            System.out.println("发生异常" + e.getMessage());
        }
    }
}
