package Work1.Day07;


/**
 * ********概述：
 */

interface speakHello {
  void speakHello();
}

class Chinese implements speakHello {

    @Override
    public void speakHello() {
        System.out.println("中国人习惯问候语:你好，吃饭了吗");
    }
}

class English implements speakHello {

    @Override
    public void speakHello() {
        System.out.println("英国人习惯问候语:你好，天气不错");
    }
}

class KindHello {
    public void lookHello(speakHello hello) {
        hello.speakHello();
    }
}

public class Example6_6 {
    public static void main(String[] args) {
        KindHello a = new KindHello();
        Chinese ccc = new Chinese();
        a.lookHello(ccc);
        a.lookHello(new English());
        a.lookHello(()-> {
            System.out.println("码农问候语:no bug");
        });
    }
}
