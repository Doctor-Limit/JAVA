package Day12.test1;
/*
�����
1��������ʼ��������
2�����������η�����ֻ����static
3����̬�����:��1���ڲ������������䣨2��������ļ��ض�ִ����ֻ�����౻���ص�ʱ��ִ��һ��
             �����о�̬���Խ������¸�ֵ���޷����÷Ǿ�̬�ṹ��
   �������˶������飬�����Ⱥ�˳��ִ�У���̬��Զ�ڷǾ�̬ǰִ�У�

   �Ǿ�̬����飺��1���ڲ������������䣨2�����Ŷ���Ĵ�����ִ����ÿ����һ�������ִ��һ��
               �ɶԶ������Խ��г�ʼ��(���ṹ���ܵ���)

 */
public class BlockTest {
    public static void main(String[] args) {
        String desc=Person.desc;
        Person p1=new Person();
    }
}

class Person{
    //����
    String name;
    int age;
    static String desc="����һ����";

    //�����
    static {//��̬
        System.out.println("hello,static block");
        desc="�ɷ�";
    }
    static {
    }

    {//�Ǿ�̬
        System.out.println("hello,block");
        age=2;
    }

    //����
    public Person(){
    }
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void eat(){
        System.out.println("�˸ɷ�");
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
    public static void info(){
        System.out.println("������");
    }
}