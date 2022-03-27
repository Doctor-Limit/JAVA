package Day12.test7;

/*
面向接口编程
 */
public class USBTest {
    public static void main(String[] args) {
        Computer computer=new Computer();
        //1、创建了接口的非匿名实现类的非匿名对象
        Flash flash=new Flash();
        computer.transferData(flash);//接口不允许创建对象,通过接口的多态性来使用
        //2、创建了接口的非匿名实现类的匿名对象
        computer.transferData(new Printer());
        //3、创建了接口的匿名实现类的非匿名对象
        USB phone=new USB() {
            @Override
            public void start() {
                System.out.println("手机开始工作");
            }
            @Override
            public void stop() {
                System.out.println("手机结束工作");
            }
        };
        computer.transferData(phone);
        //4、创建了接口的匿名实现类的匿名对象
        computer.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("不想工作");
            }
            @Override
            public void stop() {
               System.out.println("不要停下来呀");
            }
        });
    }
}

class Computer{
    public void transferData(USB usb){
        usb.start();

        System.out.println("具体传输数据细节：");

        usb.stop();
    }
}
interface USB{
    //常量：定义长、宽、最大最小的传输速度

    void start();
    void stop();
}
class Flash implements USB{
    @Override
    public void stop() {
     System.out.println("U盘结束工作");
    }

    @Override
    public void start() {
    System.out.println("U盘开始工作");
    }
}
class Printer implements USB{
    @Override
    public void start() {
        System.out.println("打印机开始工作");
    }
    @Override
    public void stop() {
         System.out.println("打印机结束工作");
    }

}
