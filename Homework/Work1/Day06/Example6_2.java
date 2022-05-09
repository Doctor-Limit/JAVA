package Work1.Day06;

/**
 * ********概述：
 */

interface ShowMessage {
    void 显示商标(String s);
    default void outPutStart(){
        System.out.println("*******");
    }
}

class TV implements ShowMessage {

    @Override
    public void 显示商标(String s) {
        System.out.println("tvtvtvtv");
        System.out.println(s);
        System.out.println("tvtvtvtv");
    }
}

class PC implements ShowMessage {

    @Override
    public void 显示商标(String s) {
        System.out.println("pcpcpcpc");
    }
}

public class Example6_2 {
    public static void main(String[] args) {
        ShowMessage sm;
        sm = new TV();
        sm.显示商标("长城牌电视机");
        sm =new PC();
        sm.outPutStart();
        sm.显示商标("华为个人电脑");
        sm.outPutStart();
    }
}
