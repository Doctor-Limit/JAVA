package Day12.test7;

/*
����ӿڱ��
 */
public class USBTest {
    public static void main(String[] args) {
        Computer computer=new Computer();
        //1�������˽ӿڵķ�����ʵ����ķ���������
        Flash flash=new Flash();
        computer.transferData(flash);//�ӿڲ�����������,ͨ���ӿڵĶ�̬����ʹ��
        //2�������˽ӿڵķ�����ʵ�������������
        computer.transferData(new Printer());
        //3�������˽ӿڵ�����ʵ����ķ���������
        USB phone=new USB() {
            @Override
            public void start() {
                System.out.println("�ֻ���ʼ����");
            }
            @Override
            public void stop() {
                System.out.println("�ֻ���������");
            }
        };
        computer.transferData(phone);
        //4�������˽ӿڵ�����ʵ�������������
        computer.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("���빤��");
            }
            @Override
            public void stop() {
               System.out.println("��Ҫͣ����ѽ");
            }
        });
    }
}

class Computer{
    public void transferData(USB usb){
        usb.start();

        System.out.println("���崫������ϸ�ڣ�");

        usb.stop();
    }
}
interface USB{
    //���������峤���������С�Ĵ����ٶ�

    void start();
    void stop();
}
class Flash implements USB{
    @Override
    public void stop() {
     System.out.println("U�̽�������");
    }

    @Override
    public void start() {
    System.out.println("U�̿�ʼ����");
    }
}
class Printer implements USB{
    @Override
    public void start() {
        System.out.println("��ӡ����ʼ����");
    }
    @Override
    public void stop() {
         System.out.println("��ӡ����������");
    }

}
