package Day11.test7;
/*
*************************�������ģʽ
* 1����ȡһ���ķ�����֤�������ϵͳ�У���ĳ����ֻ����һ������ʵ��
* 2������ʽ  ����ʽ
* 3������
*   ����ʽ���������ʱ�����(�׶�)  �̰߳�ȫ(�洦)
*   ����ʽ���ӳٶ���Ĵ���(�洦)    �̲߳���ȫ(�׶�)
*
 */
//����ʽ����  ��ǰ���½���
public class SingletonTest1 {
    public static void main(String[] args) {

        Bank bank1=Bank.getInstance();
        Bank bank2=Bank.getInstance();//ֻ����һ��ʵ������û���½������Զ��ߵ�ַ��ͬ

        System.out.println(bank1==bank2);
    }
}
class Bank{

    //˽�л�������:����������洴������
    private Bank(){
    }

    //�ڲ�������ľ�̬����(��̬����ֱ�ӵ��ã�����Ҫ��������)
    private static Bank instance=new Bank();

    //�ṩ������̬������������Ķ���
    public static Bank getInstance(){
        return instance;
    }

}














