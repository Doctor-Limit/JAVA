package Day12.test10;

public class SubClassTest implements CompareA{
    public static void main(String[] args) {
        SubClass s=new SubClass();
        //�ӿ��еľ�̬����ֻ��ͨ���ӿ������
        //s.method1();
        CompareA.method1();
        //����д�����е�Ĭ�Ϸ��������õ���������д��ķ���
        CompareA.method2();

        s.method3();
        //�����ࣨ��ʵ���ࣩ�̳еĸ����ʵ�ֵĽӿ�������ͬ��ͬ�����ķ���
        //�����ಢδ��д��Ĭ�ϵ��õ��Ǹ�����ͬ��ͬ�����ķ���--��������ʶ��
        //��ʵ����ʵ���˶���ӿڣ��������ӿڶ�����ͬ��ͬ������Ĭ�Ϸ���
        //��ô��δ��д�˷���������£�����--���ӿڳ�ͻ
        //���Ա���Ҫ��ʵ��������д�˷���
    }
}

class SubClass extends SuperClass implements CompareA,CompareB{

    public static void method1(){
        System.out.println("3");
    }
    //�����ࣨ��ʵ���ࣩ�ķ����е��ø��ࡢ�ӿ��б���д�ķ���
    public void myMethod(){
        method3();//�����Լ��������д�ķ���
        super.method3();//���ø���������

        CompareB.method3();//����Ĭ�Ͼ�̬����
        CompareA.super.method3();//���ýӿ��еķǾ�̬����

    }
}