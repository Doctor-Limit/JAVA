package Work1.Day06;

/**
 * ********概述：
 */

interface ShowMessage1 {
    void 显示商标(String s);
}

public class Example6_3 {
    public static void main(String[] args) {
        ShowMessage1 sm;
        sm = (s)->{
            System.out.println("tvtvtvtv");
            System.out.println(s);
            System.out.println("tvtvtvtv");
        };
        sm.显示商标("长城牌电视机");
        sm = ( s ) -> {
            System.out.println("pcpcpcpc");
            System.out.println(s);
            System.out.println("pcpcpcpc");
        };
        sm.显示商标("华为个人电脑");
    }
}
